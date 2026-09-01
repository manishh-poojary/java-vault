package com.toolkit.java.vault.core_concepts.multithreading.threads;

/**
 * InterThreadCommunication is a class that demonstrates inter-thread communication in Java.
 * Inter-thread communication allows threads to communicate and coordinate their actions, enabling
 * them to share data and synchronize their execution.
 *
 * <p>
 * In this class, we can implement various inter-thread communication techniques such as wait(),
 * notify(), and notifyAll() methods, which are used to facilitate communication between threads.
 *
 * <p>
 * - wait():
 * Purpose: The wait() method is used to make a thread wait until another thread notifies it.
 * It is typically called inside a synchronized block or method.
 * Usage: Threads call wait() when they need to wait for a condition to be satisfied before
 * proceeding with their execution. For example, a consumer thread may wait for a producer thread to produce data.
 * <p>
 * - notify():
 * Purpose: The notify() method is used to wake up a single waiting thread that is waiting on
 * the same object's monitor. It notifies one of the waiting threads to resume its execution.
 * Usage: Threads call notify() to signal other threads that a particular condition has been
 * met or a resource is available for consumption. For example, a producer thread may notify
 * a consumer thread when new data is available.
 * <p>
 * - notifyAll():
 * Purpose: The notifyAll() method is used to wake up all waiting threads that are waiting
 * on the same object's monitor. It notifies all waiting threads to resume their execution.
 * Usage: Threads call notifyAll() when multiple threads are waiting for the same condition
 * or resource. It ensures that all waiting threads are notified and can compete for the shared
 * resource or condition. This method is generally used to prevent potential deadlock situations.
 *
 * <p>
 * Example usage:
 * - A producer thread can produce data and notify a consumer thread when the data is available.
 * - A consumer thread can wait for the producer to produce data before consuming it.
 *
 * <p>
 * Important Points:
 * - wait(), notify(), and notifyAll() must be called from within a synchronized block or method to
 * ensure proper thread coordination and avoid race conditions.
 * - These methods are used to implement the classic producer-consumer pattern, where producers produce
 * data and notify consumers when data is available for consumption.
 * It's important to use these methods carefully to prevent potential issues such as deadlock or livelock.
 */
public class InterThreadCommunication {

    private static final Object lock = new Object();
    private static boolean isDataAvailable = false;

    public static void main(String[] args) {

        Thread producerThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Producer: Producing data...");
                isDataAvailable = true;
                lock.notify(); // Notify the consumer that data is available
            }
        });

        Thread consumerThread = new Thread(() -> {
            synchronized (lock) {
                while (!isDataAvailable) {
                    try {
                        System.out.println("Consumer: Waiting for data...");
                        lock.wait(); // Wait for the producer to produce data
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Consumer: Consuming data...");
            }
        });

        consumerThread.start();
        producerThread.start();
    }
}
