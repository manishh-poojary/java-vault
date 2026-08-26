package com.toolkit.java.vault.core_concepts.features;

/**
 * Stack and Heap are two types of memory used in Java for different purposes.
 *
 * <p>
 * Key Points:
 * - Stack Memory: Used for static memory allocation, stores method calls, local variables, and references.
 * It follows Last In First Out (LIFO) principle. Memory is automatically managed and released when a method
 * call is completed.
 *
 * <p>
 * - Heap Memory: Used for dynamic memory allocation, stores objects and class instances. It is managed by
 * the Garbage Collector (GC) which automatically frees up memory that is no longer in use.
 *
 * <p>
 * Differences:
 * - Stack is faster but limited in size, while Heap is larger but slower due to GC overhead.
 * - Stack memory is thread-specific, while Heap memory is shared among all threads.
 *
 * <p>
 * Thread Specific
 * - Stack Memory: Each thread in Java has its own stack memory, which is used to store method calls and local variables
 * specific to that thread. This isolation ensures that one thread's stack does not interfere with another's, providing
 * thread safety for local variables.
 * - Heap Memory: In contrast, heap memory is shared among all threads in a Java application. Objects created in the heap
 * can be accessed by any thread, which means that proper synchronization is necessary when multiple threads access shared
 * objects to avoid concurrency issues.
 */
public class StackAndHeap {
}

class StackMemoryExample {
    public static void main(String[] args) {
        int a = 10; // Local variable stored in stack memory
        int b = 20; // Local variable stored in stack memory
        int sum = add(a, b); // Method call stored in stack memory
        System.out.println("Sum: " + sum);
    }

    public static int add(int x, int y) {
        return x + y; // Local variables x and y are stored in stack memory
    }
}

class HeapMemoryExample {
    public static void main(String[] args) {
        Person person = new Person("John", 30); // Object stored in heap memory
        System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
    }
}
