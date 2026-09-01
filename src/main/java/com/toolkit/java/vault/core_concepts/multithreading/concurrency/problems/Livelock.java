package com.toolkit.java.vault.core_concepts.multithreading.concurrency.problems;

/**
 * Livelock is a concurrency problem that occurs when two or more threads are actively trying to acquire resources
 * but are unable to make progress because they keep yielding to each other. In a livelock situation, the threads
 * are not blocked, but they are unable to proceed with their tasks due to constant interference from each other.
 *
 * <p>
 * In a livelock scenario, the threads may continuously change their state or behavior in response to each other's
 * actions, resulting in a situation where they are effectively "stuck" and unable to complete their work.
 *
 * <p>
 * Example:
 * Consider two threads trying to acquire two locks (Lock A and Lock B) in a specific order. If both threads
 * acquire Lock A and then try to acquire Lock B, they may end up in a livelock situation where they keep releasing
 * and reacquiring the locks without making any progress.
 *
 * <p>
 * To avoid livelock, it is important to design algorithms and synchronization mechanisms that allow threads
 * to make progress even in the presence of contention for shared resources. This may involve using timeouts,
 * backoff strategies, or other techniques to ensure that threads can eventually complete their tasks.
 */
public class Livelock {

    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (lockA) {
                    System.out.println("Thread 1: Holding Lock A...");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ignored) {
                    }
                    System.out.println("Thread 1: Waiting for Lock B...");
                    synchronized (lockB) {
                        System.out.println("Thread 1: Acquired Lock B!");
                        break;
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (lockB) {
                    System.out.println("Thread 2: Holding Lock B...");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ignored) {
                    }
                    System.out.println("Thread 2: Waiting for Lock A...");
                    synchronized (lockA) {
                        System.out.println("Thread 2: Acquired Lock A!");
                        break;
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

