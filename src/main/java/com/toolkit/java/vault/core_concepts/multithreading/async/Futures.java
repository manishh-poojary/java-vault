package com.toolkit.java.vault.core_concepts.multithreading.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Futures in Java
 *
 * <p>
 * In Java, a Future represents the result of an asynchronous computation. It provides methods to check if the
 * computation is complete, to wait for its completion, and to retrieve the result of the computation.
 *
 * <p>
 * The Future interface is part of the java.util.concurrent package and is commonly used in conjunction with
 * ExecutorService to manage asynchronous tasks.
 *
 * <p>
 * Key Methods of Future:
 * - get(): Waits for the computation to complete and retrieves the result. If the computation has not completed,
 *  it blocks until it is done.
 * - cancel(boolean mayInterruptIfRunning): Attempts to cancel the execution of the task. If the task has already
 *  completed or been canceled, it has no effect.
 * - isDone(): Returns true if the task has completed, either normally or through cancellation.
 * - isCancelled(): Returns true if the task was canceled before it completed normally.
 *
 * <p>
 * Example usage:
 * - You can submit a Callable task to an ExecutorService and obtain a Future object. You can then use the Future
 * to check if the task is done and retrieve its result when available.
 */
public class Futures {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> future = executorService.submit(() -> {
            // Simulate a long-running task
            Thread.sleep(2000);
            return Futures.increment(10);
        });

        Integer value = future.get(); // This will block until the result is available
        System.out.println("Result: " + value);
        executorService.shutdown();
    }

    static Integer increment(Integer i) {
        return i + 1;
    }
}


