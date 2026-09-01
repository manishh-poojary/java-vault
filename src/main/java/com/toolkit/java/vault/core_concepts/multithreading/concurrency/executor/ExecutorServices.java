package com.toolkit.java.vault.core_concepts.multithreading.concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.*;

/**
 * ExecutorService in Java
 *
 * <p>
 * ExecutorService is a high-level concurrency framework in Java that provides a way to manage and control the execution
 * of asynchronous tasks. It is part of the java.util.concurrent package and allows developers to submit tasks for
 * execution, manage thread pools, and handle task completion.
 *
 * <p>
 * Key features of ExecutorService:
 * - Thread Pool Management: ExecutorService manages a pool of threads, allowing for efficient reuse of threads and
 * reducing the overhead of thread creation.
 * - Task Submission: Developers can submit tasks (Runnable or Callable) for execution, and the ExecutorService will
 * handle their scheduling and execution.
 * - Future Objects: When submitting Callable tasks, ExecutorService returns a Future object that can be used to
 * retrieve the result of the task once it is completed.
 * - Graceful Shutdown: ExecutorService provides methods to shut down the executor gracefully, allowing currently
 * executing tasks to complete before termination.
 *
 * <p>
 * Common implementations of ExecutorService include:
 * - ThreadPoolExecutor: A flexible implementation that allows customization of thread pool size, queueing policies,
 * and rejection handling.
 * - ScheduledThreadPoolExecutor: An implementation that supports scheduling tasks to run after a delay or periodically.
 *
 * <p>
 * Types of ExecutorService:
 * - FixedThreadPool: A thread pool with a fixed number of threads.
 * - CachedThreadPool: A thread pool that creates new threads as needed and reuses previously constructed threads when available.
 * - SingleThreadExecutor: An executor that uses a single worker thread to execute tasks sequentially.
 * - ScheduledThreadPool: An executor that can schedule tasks to run after a delay or periodically.
 *
 */
public class ExecutorServices {

    static void executorFunction(ExecutorService executorService) {
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                System.out.println("Executing task " + taskId + " by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

class FixedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executorService = newFixedThreadPool(3);
        ExecutorServices.executorFunction(executorService);
        executorService.shutdown();
    }
}

class CachedThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executorService = newCachedThreadPool();
        ExecutorServices.executorFunction(executorService);
        executorService.shutdown();
    }
}

class SingleThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executorService = newSingleThreadExecutor();
        ExecutorServices.executorFunction(executorService);
        executorService.shutdown();
    }
}

class SchedulerThreadPoolExample {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService = newScheduledThreadPool(3);

        // Schedule a task to execute after 5 seconds
        executorService.schedule(() ->
                ExecutorServices.executorFunction(executorService), 5, TimeUnit.SECONDS);

        // Schedule a task to execute every 1 second, starting immediately
        executorService.scheduleAtFixedRate(() ->
                ExecutorServices.executorFunction(executorService), 0, 1, TimeUnit.SECONDS);

        // Let scheduled tasks run for a while, then shut down
        try {
            Thread.sleep(7000); // observe a few runs
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        executorService.shutdown();
//        executorService.awaitTermination(5, TimeUnit.SECONDS);
    }

}
