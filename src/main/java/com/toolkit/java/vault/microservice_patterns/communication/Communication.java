package com.toolkit.java.vault.microservice_patterns.communication;

/**
 * Communication in Microservices
 *
 * <p>
 * Communication is a critical aspect of microservice architecture, as services need to interact with each other to
 * fulfill business requirements. There are two primary communication patterns in microservices: synchronous and
 * asynchronous communication.
 *
 * <p>
 * 1. Synchronous Communication:
 * - In synchronous communication, the client sends a request to the service and waits for a response before proceeding.
 * - Common protocols for synchronous communication include HTTP/REST and gRPC.
 * - Example: A user service calling an order service to retrieve order details.
 *
 * <p>
 * 2. Asynchronous Communication:
 * - In asynchronous communication, the client sends a request and continues processing without waiting for an
 * immediate response.
 * - Common mechanisms for asynchronous communication include message queues (e.g., RabbitMQ, Kafka) and event-driven
 * architectures.
 * - Example: A payment service publishing an event when a payment is completed, which other services can subscribe to.
 *
 * <p>
 * 3. API Gateway:
 * - An API Gateway can be used to manage and route requests between clients and microservices, providing a single
 * entry point for communication.
 * - It can handle tasks such as authentication, rate limiting, and request routing, simplifying the communication
 * between clients and services.
 *
 * <p>
 * 4. Database-per-service:
 * - Each microservice manages its own database, promoting loose coupling and independence between services.
 * - Services communicate through APIs or messaging rather than sharing a database, ensuring data encapsulation
 * and independence.
 *
 * <p>
 * Choosing the right communication pattern depends on the specific use case, performance requirements, and system
 * architecture.
 */
public class Communication {
}
