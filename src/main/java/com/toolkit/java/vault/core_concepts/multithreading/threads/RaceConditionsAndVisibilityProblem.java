package com.toolkit.java.vault.core_concepts.multithreading.threads;

/**
 * Race Conditions and Visibility Problem in Java
 * <p>
 * Race conditions and visibility problems are common issues in multithreaded programming that can lead to
 * unpredictable behavior and bugs. Understanding these problems is crucial for writing correct and efficient
 * concurrent code.
 *
 * <p>
 * Race Conditions:
 * - A race condition occurs when two or more threads access shared data and try to change it at the same time.
 * The final outcome depends on the timing of the threads' execution, which can lead to inconsistent or incorrect
 * results.
 * - It can occur when multiple threads read and write shared variables without proper synchronization, leading to
 * unexpected behavior.
 *
 * <p>
 * Visibility Problem:
 * - The visibility problem occurs when changes made by one thread to a shared variable are not immediately visible
 * to other threads. This can happen due to caching mechanisms in the JVM, where each thread may have its own copy
 * of the variable in its local memory.
 * - To ensure visibility, threads must use synchronization mechanisms (like synchronized blocks or volatile variables)
 * to guarantee that changes made by one thread are visible to others.
 * <p>
 *
 */
public class RaceConditionsAndVisibilityProblem {

    static Counter counter;

    public static void main(String[] args) throws InterruptedException {
        RaceConditionsAndVisibilityProblem instance = new RaceConditionsAndVisibilityProblem();
        counter = new Counter();
        instance.demonstrateRaceCondition();
        int finalCount = instance.visibilityProblemExample();
        System.out.println("Final count from visibility problem example: " + finalCount);
    }


    void demonstrateRaceCondition() throws InterruptedException {
        int numThreads = 10;
        Thread[] threads = new Thread[numThreads];

        // Create and start multiple threads
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    // Non-atomic operation (Read -> Increment -> Write) causes the race condition
                    counter.increment();
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish execution
        for (Thread t : threads) {
            t.join();
        }

        int expected = numThreads * 100000;
        System.out.println("Expected Count: " + expected);
        System.out.println("Actual Count (Race Condition Result): " + counter.getCount());
    }

    public int visibilityProblemExample() {
        return counter.getCount();
    }

}


/**
 * Example class demonstrating a race condition and visibility problem.
 */
class Counter {
    private int counter = 0;

    public void increment() {
        counter++; // Not thread-safe
    }

    public int getCount() {
        return counter; // Not thread-safe
    }
}

