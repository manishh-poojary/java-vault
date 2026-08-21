# ☕ Java Vault

A curated collection of core Java concepts, design patterns, and backend engineering practices — documented and implemented with clean, working code examples.

This repo is my personal reference and learning log, built to deepen my understanding of Java and to serve as a quick-lookup resource for interviews, projects, and day-to-day development.

---

## 📚 What's Inside

### 1. Core Java Concepts
- OOP Principles (Encapsulation, Inheritance, Polymorphism, Abstraction)
- Collections Framework
- Exception Handling
- Multithreading & Concurrency
- Generics
- Java 8+ Features (Streams, Lambdas, Optional, etc.)
- Memory Management & JVM Internals

### 2. Design Patterns (Gang of Four)
| Category | Patterns |
|---|---|
| Creational | Singleton, Factory, Abstract Factory, Builder, Prototype |
| Structural | Adapter, Decorator, Facade, Proxy, Composite, and many more |
| Behavioral | Observer, Strategy, Command, State, Template Method and many more |

### 3. Microservice & Resilience Patterns
- Retry
- Circuit Breaker
- Bulkhead
- Timeout & Fallback
- Rate Limiter

*(Implemented using Spring Boot / Resilience4j where applicable)*

---

## 🗂️ Repository Structure

```
java-vault/
│
├── core_concepts/
│   ├── oop/
│   ├── collections/
│   ├── multithreading/
│   └── java8_features/
│
├── design_patterns/
│   ├── creational/
│   ├── structural/
│   └── behavioral/
│
├── microservice_patterns/
│   ├── retry/
│   ├── circuit_breaker/
│   └── bulkhead/
│
└── README.md
```

---

## 🚀 Getting Started

Clone the repo:
```bash
git clone https://github.com/manishh-poojary/java-vault.git
cd java-vault
```

Each concept/pattern lives in its own folder with:
- A short explanation (`README.md` or comments)
- A runnable code example
- (Where relevant) a real-world use case

---

## 🎯 Purpose

This repo exists to:
- Reinforce Java fundamentals through hands-on implementation
- Build muscle memory for design patterns and when to use them
- Explore how resilience patterns work in distributed/microservice systems
- Serve as a quick-reference for interviews and real-world projects

---

## 🛠️ Tech Stack

- Java 21+
- Maven
- Spring Boot (for microservice pattern demos)
- Resilience4j (for retry, circuit breaker, etc.)

---

## 📌 Status

🚧 Actively growing — new concepts and patterns are added regularly.

---

## 🤝 Contributions

This is primarily a personal learning repo, but suggestions, corrections, or discussions are welcome via Issues or Pull Requests.
