package com.toolkit.java.vault.core_concepts.multithreading.concurrency.problems;

/**
 * Race conditions occur when multiple threads access shared data and try to change it at the same time.
 * Because thread scheduling can vary, the outcome of a race condition is unpredictable and can lead to
 * inconsistent or incorrect results. Race conditions are a common problem in concurrent programming and
 * can be difficult to detect and reproduce.
 *
 * <p>
 * To prevent race conditions, you can use synchronization mechanisms such as locks, semaphores,
 * or synchronized blocks to ensure that only one thread can access the shared resource at a time.
 * This helps maintain data integrity and consistency in multi-threaded applications.
 */
public class RaceConditions {

    private int counter = 0;

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {
        RaceConditions example = new RaceConditions();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                example.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                example.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final Counter Value: " + example.getCounter());
    }
}

