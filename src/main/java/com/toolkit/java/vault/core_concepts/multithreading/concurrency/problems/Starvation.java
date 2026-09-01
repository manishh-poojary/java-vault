package com.toolkit.java.vault.core_concepts.multithreading.concurrency.problems;

/**
 * Starvation is a concurrency problem that occurs when a thread is unable to gain regular access to shared resources
 * and is unable to make progress because other threads are continuously consuming those resources.
 *
 * <p>
 * In a multi-threaded environment, starvation can happen when higher-priority threads monopolize the CPU or other
 * resources, preventing lower-priority threads from executing. As a result, the lower-priority threads may be
 * indefinitely delayed or "starved" of the resources they need to complete their tasks.
 *
 * <p>
 * Causes of Starvation:
 * - Priority Inversion: When a low-priority thread holds a resource needed by a high-priority thread, causing the
 *   high-priority thread to wait indefinitely.
 * - Unfair Scheduling: When the thread scheduler does not allocate CPU time fairly among threads, leading to some
 *   threads being consistently favored over others.
 * - Resource Contention: When multiple threads compete for limited resources, and some threads are consistently denied
 *   access due to the behavior of other threads.
 *
 * <p>
 * Solutions to Starvation:
 * - Fair Scheduling: Implementing fair scheduling algorithms that ensure all threads get a chance to execute based on
 *   their priority and waiting time.
 * - Priority Aging: Gradually increasing the priority of waiting threads over time to prevent them from being starved.
 * - Resource Management: Using locks, semaphores, or other synchronization mechanisms to manage access to shared
 *   resources more effectively and prevent monopolization by certain threads.
 */
public class Starvation {

    private static final Object lock = new Object();
    private static boolean isResourceAvailable = false;

    public static void main(String[] args) {
        Thread highPriorityThread = new Thread(() -> {
            synchronized (lock) {
                while (!isResourceAvailable) {
                    try {
                        System.out.println("High-priority thread waiting for resource...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("High-priority thread acquired resource.");
            }
        });

        Thread lowPriorityThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Low-priority thread acquiring resource...");
                isResourceAvailable = true;
                lock.notify(); // Notify the high-priority thread that the resource is available
                System.out.println("Low-priority thread released resource.");
            }
        });

        highPriorityThread.setPriority(Thread.MAX_PRIORITY);
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

        highPriorityThread.start();
        lowPriorityThread.start();
    }
}

