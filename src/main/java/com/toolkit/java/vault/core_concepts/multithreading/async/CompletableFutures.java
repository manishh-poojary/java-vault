package com.toolkit.java.vault.core_concepts.multithreading.async;

import java.util.concurrent.CompletableFuture;

/*
 * CompletableFutures is a class that demonstrates the usage of CompletableFuture in Java for asynchronous programming.
 * CompletableFuture is a powerful feature introduced in Java 8 that allows you to write non-blocking, asynchronous code
 * using a functional programming style.
 *
 * <p>
 * Advantages of Using CompletableFuture:
 * <p>
 * - Asynchronous Programming: CompletableFuture enables you to write asynchronous code that can run concurrently,
 * allowing you to perform multiple tasks simultaneously without blocking the main thread.
 * - Chaining and Composition: CompletableFuture provides methods for chaining multiple asynchronous operations together,
 * allowing you to create complex workflows and handle results in a more readable and maintainable way.
 * - Exception Handling: CompletableFuture provides built-in mechanisms for handling exceptions that may occur during
 * asynchronous operations, making it easier to manage error scenarios.
 * - Non-blocking I/O: CompletableFuture can be used with non-blocking I/O operations, allowing you to build scalable
 * applications that can handle a large number of concurrent requests efficiently.
 *
 * <p>
 * Internal Working of CompletableFuture:
 * <p>
 * - CompletableFuture internally uses a combination of threads and the ForkJoinPool to execute asynchronous tasks.
 * - When you create a CompletableFuture, it can be completed either by a separate thread or by the main thread. The
 * tasks are executed in a non-blocking manner, allowing other tasks to run concurrently.
 * - CompletableFuture provides methods like thenApply, thenAccept, and thenCompose to chain tasks together,
 * allowing you to define a sequence of operations that will be executed asynchronously.
 * - It also provides methods like exceptionally and handle to handle exceptions that may occur during the execution
 *  of tasks.
 *
 */
public class CompletableFutures {

    public static void main(String[] args) {

        // Create a CompletableFuture that performs an asynchronous computation
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running computation
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 42;
        });

        // Chain another computation to the CompletableFuture
        CompletableFuture<String> resultFuture = future.thenApply(result -> "Result: " + result);

        // Handle the result asynchronously
        resultFuture.thenAccept(System.out::println);

        // Wait for the result to be printed before exiting the program
        try {
            Thread.sleep(3000); // Wait for the asynchronous tasks to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
