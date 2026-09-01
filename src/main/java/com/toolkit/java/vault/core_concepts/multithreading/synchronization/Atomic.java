package com.toolkit.java.vault.core_concepts.multithreading.synchronization;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic in Java
 *
 * <p>
 * In Java, the term "atomic" refers to operations that are performed as a single, indivisible unit of work.
 * Atomic operations are crucial in multithreaded programming to ensure that shared data is accessed and modified
 * safely without the risk of race conditions or inconsistent states.
 *
 * <p>
 * Key characteristics of atomic operations:
 * - Indivisibility: An atomic operation is executed completely or not at all, meaning that no other thread can
 * observe the operation in an intermediate state.
 * - Thread Safety: Atomic operations provide a way to safely manipulate shared data in a concurrent environment
 * without the need for explicit synchronization mechanisms like locks.
 * - Performance: Atomic operations are generally more efficient than using locks, as they avoid the overhead
 * associated with acquiring and releasing locks.
 *
 * <p>
 * Common atomic operations in Java:
 * - Atomic Variables: Java provides classes in the java.util.concurrent.atomic package, such as AtomicInteger,
 * AtomicLong, and AtomicReference, which offer atomic operations for primitive types and object references.
 * - Compare-And-Swap (CAS): Many atomic operations are implemented using the CAS mechanism, which allows a thread
 * to update a variable only if it has not been modified by another thread since it was last read.
 * - Atomic Methods: The atomic classes provide methods like get(), set(), increment AndGet(), and compareAndSet()
 * that perform atomic operations on the underlying variable.
 *
 */
public class Atomic {
    private static final AtomicInteger atomicCounter = new AtomicInteger(0);

    public static void main(String[] args) {
        // Increment the atomic counter
        int newValue = atomicCounter.incrementAndGet();
        System.out.println("New Value after increment: " + newValue);

        // Compare and set example
        boolean wasUpdated = atomicCounter.compareAndSet(newValue, 10);
        System.out.println("Was the value updated? " + wasUpdated);
        System.out.println("Current Value: " + atomicCounter.get());
    }
}

