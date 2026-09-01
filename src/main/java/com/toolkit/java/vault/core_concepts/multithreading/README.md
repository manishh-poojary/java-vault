Title: Java Vault — concurrency package

Description
A compact collection of Java concurrency examples and notes demonstrating core concepts: threads, executors, scheduled tasks, thread pools, and common patterns for learning and experimentation.

Contents
- ExecutorServices.java — examples: FixedThreadPool, CachedThreadPool, SingleThreadExecutor, ScheduledThreadPool
- (Add more classes as you expand: BlockingQueue, ReentrantLock, CompletableFuture, ForkJoin examples)

Quick start (compile & run)
1. From repo root:
   javac -d out src/main/java/com/toolkit/java/vault/core_concepts/multithreading/concurrency/*.java
2. Run an example:
   java -cp out com.toolkit.java.vault.core_concepts.multithreading.concurrency.FixedThreadPoolExample
   java -cp out com.toolkit.java.vault.core_concepts.multithreading.concurrency.SchedulerThreadPoolExample

Notes
- Scheduler examples may call shutdown() too early; delay shutdown or awaitTermination to observe scheduled runs.
- Use an IDE or Maven for easier execution if preferred.

Learning path (recommended)
1. Threads & Runnable
2. Synchronization & volatile
3. Executors & Futures
4. Concurrent collections
5. Locks & Conditions
6. ForkJoin & CompletableFuture
