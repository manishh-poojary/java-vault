# Microservices Architecture — Reference Example

A general-purpose microservices system demonstrating core patterns using four services: **Auth**, **Product**, **Order**, and **Notification**. Use this as a study reference / boilerplate structure for designing your own microservice systems.

---

## Architecture Overview

```
                        ┌─────────────────┐
                        │   API Gateway    │
                        │ (routing, auth)  │
                        └────────┬─────────┘
                                 │
        ┌────────────┬──────────┼───────────┬──────────────┐
        │             │          │           │              │
 ┌──────▼─────┐ ┌─────▼──────┐ ┌▼──────────┐ │       ┌──────▼───────┐
 │auth-service│ │product-svc │ │order-svc  │ │       │notification- │
 │            │ │            │ │           │ │       │service       │
 └──────┬─────┘ └─────┬──────┘ └────┬──────┘ │       └──────┬───────┘
        │             │             │        │              │
   ┌────▼────┐   ┌────▼────┐   ┌────▼────┐   │        ┌─────▼─────┐
   │ auth_db │   │product_db│   │ order_db│   │        │notif_db   │
   └─────────┘   └─────────┘   └─────────┘   │        └───────────┘
                                              │
                                    ┌─────────▼─────────┐
                                    │   Kafka Broker      │
                                    │ (event bus, async)  │
                                    └─────────────────────┘
```

Each service is independently deployable, owns its own database, and communicates with others via REST (synchronous) or Kafka events (asynchronous).

---

## Services

### 1. `auth-service`
Handles identity and access management for the whole system.

**Responsibilities**
- User registration, login, logout
- JWT issuance and refresh token flow
- Role-based access control (RBAC)
- OAuth2 / social login integration

**Owns:** `auth_db` — `users`, `roles`, `refresh_tokens`

**Exposes**
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/register` | Create new user |
| POST | `/api/auth/login` | Authenticate, issue JWT |
| POST | `/api/auth/refresh` | Refresh access token |
| GET | `/api/auth/users/{id}` | Get user by ID (internal, used by other services) |

---

### 2. `product-service`
Owns the product catalog.

**Responsibilities**
- Product CRUD
- Inventory/stock tracking
- Category and pricing management

**Owns:** `product_db` — `products`, `categories`, `inventory`

**Exposes**
| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/products` | List products |
| GET | `/api/products/{id}` | Get product detail |
| POST | `/api/products` | Create product (admin) |
| PATCH | `/api/products/{id}/stock` | Adjust stock (internal, called by order-service) |

---

### 3. `order-service`
Owns the order lifecycle — the service most other services orbit around.

**Responsibilities**
- Order creation and status tracking
- Coordinates the order saga (validate user → check stock → reserve → confirm)
- Publishes order lifecycle events

**Owns:** `order_db` — `orders`, `order_items`, `order_status_history`

**Exposes**
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/orders` | Place a new order |
| GET | `/api/orders/{id}` | Get order status |
| GET | `/api/orders/user/{userId}` | List a user's orders |

**Publishes (Kafka topics)**
- `order.created`
- `order.confirmed`
- `order.cancelled`

---

### 4. `notification-service`
Stateless consumer — reacts to events, doesn't expose much of its own API.

**Responsibilities**
- Sends email/SMS/push notifications
- Listens to events from order-service, auth-service

**Owns:** `notification_db` — `notification_log` (delivery status only)

**Consumes (Kafka topics)**
- `order.created` → send order confirmation email
- `order.cancelled` → send cancellation email
- `user.registered` → send welcome email

---

## Communication Patterns Used

| Pattern | Where | Why |
|---|---|---|
| **Synchronous REST** | order-service → product-service (stock check), order-service → auth-service (user validation) | Caller needs an immediate answer before proceeding |
| **Asynchronous events (Kafka)** | order-service → notification-service | Decouples order flow from email delivery; notification-service being down shouldn't block order placement |
| **API Gateway** | Client → Gateway → services | Single entry point, centralizes auth/rate-limiting, hides internal topology |
| **Database-per-service** | All services | No service reads/writes another's tables directly; isolation and independent scaling |

---

## Order Placement Flow — Saga Pattern (Both Styles)

### A. Choreography-based Saga
No central coordinator — each service reacts to events published by the previous one.

```
1. Client → order-service: POST /api/orders
2. order-service → auth-service: validate user (sync REST)
3. order-service → product-service: check & reserve stock (sync REST)
4. order-service: creates order (status = PENDING)
5. order-service → Kafka: publish "order.created"
6. notification-service ← Kafka: consumes "order.created" → sends confirmation email
7. order-service: updates order status = CONFIRMED
```

**Failure/compensation example:** if stock reservation fails at step 3, order-service publishes `order.cancelled` instead, and no downstream email is sent — no rollback needed since no distributed transaction was opened in the first place.

**Pros:** simple, no single point of failure, services stay loosely coupled.
**Cons:** flow logic is scattered across services — harder to see the "big picture" or debug a broken saga, and cyclic event dependencies can creep in as the saga grows.

---

### B. Orchestration-based Saga
A central **Order Saga Orchestrator** explicitly tells each service what to do, step by step, and handles compensation on failure.

```
1. Client → order-service: POST /api/orders
2. order-service → Saga Orchestrator: start "PlaceOrderSaga"

3. Orchestrator → auth-service: ValidateUserCommand
   auth-service → Orchestrator: UserValidated (or UserValidationFailed)

4. Orchestrator → product-service: ReserveStockCommand
   product-service → Orchestrator: StockReserved (or StockReservationFailed)

5. Orchestrator → order-service: ConfirmOrderCommand
   order-service → Orchestrator: OrderConfirmed

6. Orchestrator → notification-service: SendConfirmationCommand
   notification-service → Orchestrator: NotificationSent

7. Orchestrator: marks saga COMPLETE
```

**Failure/compensation example:** if `ReserveStockCommand` fails at step 4, the orchestrator runs compensating commands in reverse for every step already completed:
```
Orchestrator → auth-service: ReleaseUserValidationHold (no-op / release lock, if any)
Orchestrator → order-service: CancelOrderCommand → order status = CANCELLED
Orchestrator → notification-service: SendOrderFailedCommand
Orchestrator: marks saga FAILED
```

**Pros:** the entire flow lives in one place (the orchestrator) — easy to visualize, test, and add steps to; compensation logic is centralized rather than scattered.
**Cons:** orchestrator becomes a critical component (needs its own resilience), and adds a bit more coupling since services now respond to explicit commands rather than emitting independent events.

---

### Choosing Between Them

| | Choreography | Orchestration |
|---|---|---|
| Coordination | Distributed (event reactions) | Centralized (orchestrator service) |
| Best for | Few steps, simple flows | Complex flows, many steps, need visibility |
| Coupling | Looser | Tighter (services depend on orchestrator's commands) |
| Debugging | Harder — trace across services | Easier — one place to see saga state |
| Single point of failure | None inherently | Orchestrator itself, unless made resilient |

For this reference architecture, choreography (A) fits the current 4-service scope well; if more services join the order flow later (e.g. `payment-service`, `shipping-service`), orchestration (B) tends to scale better operationally.

---

## Resilience

- **Circuit Breaker** (Resilience4j) wraps all synchronous inter-service calls (order → auth, order → product) — falls back gracefully instead of cascading failures.
- **Retry with backoff** on transient network failures.
- **Timeouts** set explicitly on every REST client call — no unbounded waits.

---

## Deployment Patterns

| Pattern | Description | Where it applies here |
|---|---|---|
| **Single Service per Container** | Each service (auth, product, order, notification) ships as its own Docker image with its own lifecycle | Every service in this repo |
| **Service Discovery** | Services find each other by name instead of hardcoded IPs/ports — via a registry (Eureka, Consul) or platform-native DNS (Kubernetes) | Replaces hardcoded URLs in `application.yml` once moving past Docker Compose |
| **Sidecar** | A helper process deployed alongside a service in the same pod/host — e.g. a log shipper, service mesh proxy (Envoy), or metrics exporter — without modifying the service's own code | Adding Prometheus/Envoy sidecars to each service pod in Kubernetes |
| **API Gateway as Edge Deployment** | Gateway is the only externally exposed service; all others sit on an internal network | `api-gateway/` is the sole ingress point in this repo's topology |
| **Blue-Green Deployment** | Two identical production environments ("blue" = current, "green" = new); traffic is switched over once the new version is verified healthy | Deploying a new `order-service` version with zero downtime |
| **Canary Release** | Roll out a new version to a small percentage of traffic first, then gradually increase if no errors surface | Testing a new `product-service` release against real traffic before full rollout |
| **Rolling Update** | Replace instances of a service one (or a few) at a time rather than all at once | Default Kubernetes Deployment strategy for all four services |
| **Strangler Fig** | Incrementally migrate a monolith to microservices by routing an increasing slice of traffic to new services while the old system still handles the rest | Common when this architecture replaces an existing monolithic e-commerce backend rather than being greenfield |
| **Externalized Configuration** | Config (DB URLs, secrets, feature flags) lives outside the built artifact — env vars, Spring Cloud Config, or Kubernetes ConfigMaps/Secrets | `application.yml` per service pulls from environment, not hardcoded values |

**Note on orchestration:** Docker Compose (used in "Running Locally" below) is fine for local dev, but doesn't provide service discovery, rolling updates, or self-healing — moving to Kubernetes is the natural next step for anything resembling production.


## Repository Structure

```
microservices-example/
├── api-gateway/
├── auth-service/
│   ├── src/
│   ├── Dockerfile
│   └── application.yml
├── product-service/
│   ├── src/
│   ├── Dockerfile
│   └── application.yml
├── order-service/
│   ├── src/
│   ├── Dockerfile
│   └── application.yml
├── notification-service/
│   ├── src/
│   ├── Dockerfile
│   └── application.yml
├── docker-compose.yml
└── README.md
```

---

## Patterns Reference Summary

| Category | Patterns Covered |
|---|---|
| Decomposition | Decompose by business capability, Database-per-service |
| Communication | Sync REST, Async events (Kafka), API Gateway |
| Data Management | Saga (choreography & orchestration), eventual consistency |
| Resilience | Circuit breaker, retry, timeout |
| Observability | Distributed tracing, centralized logging, health checks |
| Deployment | Single service per container, service discovery, sidecar, blue-green, canary, rolling update, strangler fig, externalized config |