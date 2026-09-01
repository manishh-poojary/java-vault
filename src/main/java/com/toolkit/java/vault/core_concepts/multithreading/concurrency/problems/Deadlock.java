package com.toolkit.java.vault.core_concepts.multithreading.concurrency.problems;

/**
 * Deadlock is a situation in concurrent programming where two or more threads are blocked forever,
 * waiting for each other to release resources.It occurs when multiple threads hold locks on
 * resources and each thread is waiting for a resource held by another thread, creating a circular
 * dependency.
 *
 * <p>
 * Example of Deadlock:
 * - Thread A holds Lock 1 and waits for Lock 2.
 * - Thread B holds Lock 2 and waits for Lock 1.
 * - Both threads are now blocked indefinitely, resulting in a deadlock.
 *
 * <p>
 * To avoid deadlocks, developers can use techniques such as:
 * - Lock ordering: Always acquire locks in a consistent order to prevent circular dependencies.
 * - Try-lock with timeout: Use tryLock() with a timeout to avoid waiting indefinitely for a lock.
 * - Deadlock detection: Implement algorithms to detect deadlocks and take corrective actions.
 */
public class Deadlock {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock 1...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (lock2) {
                    System.out.println("Thread 1: Acquired lock 2!");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock 2...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
                System.out.println("Thread 2: Waiting for lock 1...");
                synchronized (lock1) {
                    System.out.println("Thread 2: Acquired lock 1!");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}


