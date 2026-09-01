package com.toolkit.java.vault.core_concepts.multithreading.threads;

/**
 * Threads in Java
 *
 * <p>
 * Threads are the smallest unit of execution within a process. In Java, threads allow for concurrent execution of code,
 * enabling applications to perform multiple tasks simultaneously. Each thread runs independently and can share resources
 * with other threads within the same process.
 *
 * <p>
 * Key characteristics of threads:
 * - Lightweight: Threads are lighter than processes, as they share the same memory space and resources of the parent process.
 * - Concurrency: Threads enable concurrent execution, allowing for better resource utilization and responsiveness in applications.
 * - Multithreading: Java supports multithreading, where multiple threads can run in parallel, improving performance for CPU-bound tasks.
 *
 * <p>
 * Common use cases for threads include:
 * - Performing background tasks without blocking the main application flow.
 * - Handling multiple client requests in server applications.
 * - Implementing parallel processing for computationally intensive tasks.
 *
 */
public class Threads {

    public static void main(String[] args) {
        // Create a new thread using the Thread class
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1: " + i);
                try {
                    Thread.sleep(500); // Sleep for 500 milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create another thread using the Thread class
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 2: " + i);
                try {
                    Thread.sleep(300); // Sleep for 300 milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Both threads have finished execution");
    }
}

/**
 * State of a Thread in Java
 *
 * <p>
 * In Java, a thread can be in one of several states during its lifecycle. The state of a thread can be queried using the
 * getState() method of the Thread class. The possible states of a thread are:
 * <p>
 * - NEW: A thread that has been created but not yet started.
 * - RUNNABLE: A thread that is ready to run and is waiting for CPU time.
 * - BLOCKED: A thread that is blocked waiting for a monitor lock.
 * - WAITING: A thread that is waiting indefinitely for another thread to perform a particular action.
 * - TIMED_WAITING: A thread that is waiting for another thread to perform an action for up to a specified waiting time.
 * - TERMINATED: A thread that has completed execution.
 * - YIELDING: A thread that has temporarily paused its execution to allow other threads to run.
 * - SLEEPING: A thread that is in a sleeping state for a specified period of time.
 * - INTERRUPTED: A thread that has been interrupted while it was in a waiting or sleeping state.
 *
 */
class StateOfThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Thread is running");
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread has finished execution");
        });

        System.out.println("Thread state before start: " + thread.getState());
        thread.start();
        System.out.println("Thread state after start: " + thread.getState());

        Thread yieldingThread = new Thread(() -> {
            System.out.println("Yielding thread is running");
            Thread.yield(); // Yield execution to other threads
            System.out.println("Yielding thread has finished execution");
        });
        yieldingThread.start();

        Thread sleepingThread = new Thread(() -> {
            System.out.println("Sleeping thread is running");
            try {
                Thread.sleep(2000); // Sleep for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sleeping thread has finished execution");
        });
        sleepingThread.start();

        Thread interruptedThread = new Thread(() -> {
            System.out.println("Interrupted thread is running");
            try {
                Thread.sleep(3000); // Sleep for 3 seconds
            } catch (InterruptedException e) {
                System.out.println("Interrupted thread was interrupted");
            }
            System.out.println("Interrupted thread has finished execution");
        });
        interruptedThread.start();

        try {
            Thread.sleep(500); // Sleep for 500 milliseconds
            System.out.println("Thread state while running: " + thread.getState());
            thread.join(); // Wait for the thread to finish
            yieldingThread.join();
            sleepingThread.join();
            interruptedThread.interrupt(); // Interrupt the sleeping thread
            interruptedThread.join();
            System.out.println("Thread state after join: " + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
 * Daemon Threads in Java
 *
 * <p>
 * In Java, a daemon thread is a background thread that runs in the background and does not prevent the JVM from exiting
 * when all user threads have finished execution. Daemon threads are typically used for tasks such as garbage collection,
 * background monitoring, and other low-priority tasks that should not block the termination of the application.
 *
 * <p>
 * Key characteristics of daemon threads:
 * - Daemon threads run in the background and do not prevent the JVM from exiting.
 * - When all user threads have finished execution, the JVM will terminate, and any remaining daemon threads will be stopped.
 * - Daemon threads can be created by calling the setDaemon(true) method on a Thread object before starting it.
 *
 */
class DaemonThread{

    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread is running...");
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        daemonThread.setDaemon(true); // Set the thread as a daemon thread
        daemonThread.start();

        try {
            Thread.sleep(3000); // Sleep for 3 seconds to allow the daemon thread to run
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread is finished");
    }
}
