package com.toolkit.java.vault.core_concepts.multithreading.concurrency.collections;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList is a thread-safe variant of ArrayList in Java that provides a way to handle concurrent
 * modifications to the list without the need for explicit synchronization. It is part of the java.util.concurrent
 * package and is designed for scenarios where read operations are more frequent than write operations.
 *
 * <p>
 * Key Features of CopyOnWriteArrayList:
 * - Thread Safety: CopyOnWriteArrayList is designed to be thread-safe, allowing multiple threads to read from the list
 * concurrently without the risk of data corruption or inconsistent state.
 * - Copy-on-Write Mechanism: When a write operation (add, remove, or update) is performed on the list, a new copy of
 * the underlying array is created. This ensures that readers can continue to access the old version of the list while
 * writers work on the new version.
 * - Iterators: The iterators returned by CopyOnWriteArrayList are fail-safe, meaning they do not throw
 * ConcurrentModificationException. They operate on a snapshot of the list at the time the iterator was created.
 * - Performance Considerations: While CopyOnWriteArrayList provides excellent performance for read-heavy workloads,
 * it may not be suitable for write-heavy scenarios due to the overhead of creating new copies of the array on each
 * modification.
 *
 */
public class CopyOnWriteArrayLists {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        // Adding elements to the list
        list.add(1);
        list.add(2);
        list.add(3);

        // Iterating over the list
        for (Integer number : list) {
            System.out.println("Number: " + number);
        }

        // Modifying the list while iterating
        for (Integer number : list) {
            if (number == 2) {
                list.remove(number); // This will not throw ConcurrentModificationException
            }
        }

        System.out.println("List after modification: " + list);
    }
}

