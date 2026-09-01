package com.toolkit.java.vault.core_concepts.multithreading.threads;

/**
 * ThreadLocal is a class in Java that provides thread-local variables. Each thread accessing a ThreadLocal variable
 * has its own, independently initialized copy of the variable. ThreadLocal variables are typically used to store
 * data that is specific to a particular thread and should not be shared among multiple threads.
 *
 * <p>
 * Advantages of Using ThreadLocal:
 * <p>
 * - Thread Isolation: ThreadLocal provides thread isolation by maintaining separate copies of variables for each
 * thread. This prevents concurrent threads from accessing or modifying each other's data, enhancing thread safety
 * and avoiding race conditions.
 * - Thread Confinement: ThreadLocal supports the concept of thread confinement, where data is confined to a specific
 * thread's execution context. This helps in encapsulating thread-specific data and prevents the need for
 * synchronization or locks when accessing the data.
 * - Reduced Synchronization Overhead: Since each thread has its own copy of ThreadLocal variables, there is no need
 * for explicit synchronization mechanisms like locks or atomic operations when accessing these variables. This
 * can lead to improved performance and scalability in multi-threaded applications.
 * - Avoids Memory Leaks: ThreadLocal variables are garbage collected along with the thread that owns them. This
 * helps in preventing memory leaks that may occur when using shared resources across multiple threads, as the
 * resources are automatically released when the thread terminates.
 * - Contextual Data Storage: ThreadLocal variables are often used to store contextual data related to the current
 * thread's execution context. This can include user sessions, transaction contexts, request-specific data in web
 * applications, and more. Using ThreadLocal makes it easy to access and manage such contextual data within the thread.
 */
public class ThreadLocals {

    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        // Set thread-local value for main thread
        threadLocal.set(100);
        System.out.println("ThreadLocal value in main thread: " + threadLocal.get());

        // Create and start a new thread
        Thread thread = new Thread(() -> {
            threadLocal.set(1000);
            // Access thread-local value in the new thread
            System.out.println("ThreadLocal value in new thread: " + threadLocal.get());
        });
        thread.start();
    }
}