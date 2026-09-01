package com.toolkit.java.vault.core_concepts.multithreading.synchronization;

/**
 * Volatile in Java
 *
 * <p>
 * The volatile keyword in Java is used to indicate that a variable's value will be modified by different threads.
 * Declaring a variable as volatile ensures that its value is always read from and written to the main memory, rather than
 * being cached in a thread's local memory. This guarantees visibility of changes made by one thread to other threads.
 *
 * <p>
 * Key characteristics of volatile variables:
 * - Visibility: Changes made to a volatile variable by one thread are immediately visible to other threads.
 * - Atomicity: Reads and writes to volatile variables are atomic for reference types and primitive types
 * (except for long and double).
 * - No Caching: Volatile variables are not cached, ensuring that the most up-to-date value is always read from main memory.
 *
 * <p>
 * Use cases for volatile:
 * - Flags: Volatile is often used for flags that indicate whether a thread should continue running or stop.
 * - State Variables: It can be used for state variables that are accessed by multiple threads without complex synchronization.
 *
 * <p>
 * Limitations of volatile:
 * - Volatile does not provide atomicity for compound actions (e.g., incrementing a counter).
 * - It does not replace proper synchronization mechanisms when multiple threads need to coordinate access to shared resources.
 */
public class Volatile {
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (running) {
                Thread.onSpinWait();
                // Do some work
            }
            System.out.println("Thread stopped.");
        });

        thread.start();

        // Let the thread run for a while
        Thread.sleep(1000);

        // Stop the thread
        running = false;
        thread.join();
    }
}

