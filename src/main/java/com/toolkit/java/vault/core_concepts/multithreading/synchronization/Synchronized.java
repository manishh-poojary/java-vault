package com.toolkit.java.vault.core_concepts.multithreading.synchronization;

/**
 * Synchronized in Java
 *
 * <p>
 * In Java, the synchronized keyword is used to control access to shared resources in a multithreaded
 * environment. It ensures that only one thread can execute a block of code or method at a time,
 * preventing race conditions and ensuring thread safety.
 *
 * <p>
 * There are two main ways to use synchronized in Java:
 * 1. Synchronized Methods: You can declare a method as synchronized by adding the synchronized keyword
 * to its declaration. This means that only one thread can execute that method on the same object instance
 * at a time.
 * 2. Synchronized Blocks: You can also use synchronized blocks to synchronize a specific section of
 * code within a method. This allows for more fine-grained control over synchronization, as you can
 * synchronize only the critical section of code that needs to be thread-safe.
 *
 *
 */
public class Synchronized {
    private int count = 0;

    // Synchronized method
    public synchronized void increment() {
        count++;
    }

    // Synchronized block
    public void decrement() {
        synchronized (this) {
            count--;
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Synchronized sync = new Synchronized();

        // Create threads to increment and decrement the count
        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sync.increment();
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sync.decrement();
            }
        });

        // Start the threads
        incrementThread.start();
        decrementThread.start();

        // Wait for both threads to finish
        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final count
        System.out.println("Final count: " + sync.getCount());
    }
}