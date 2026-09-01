package com.toolkit.java.vault.core_concepts.multithreading.concurrency.collections;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap is a thread-safe implementation of the Map interface in Java that allows concurrent access
 * and modification of its elements by multiple threads without the need for explicit synchronization.
 *
 * <p>
 * Key Features of ConcurrentHashMap:
 * <p>
 * - Thread Safety: ConcurrentHashMap provides thread-safe operations, allowing multiple threads to read and write
 * to the map concurrently without causing data corruption or inconsistencies.
 * - High Concurrency: It achieves high concurrency by dividing the map into segments, allowing multiple threads
 * to operate on different segments simultaneously. This reduces contention and improves performance in multi-threaded
 * environments.
 * - Locking Mechanism: ConcurrentHashMap uses a combination of fine-grained locking and non-blocking algorithms to
 * ensure thread safety. It employs a technique called "lock striping," where each segment has its own lock, allowing
 * multiple threads to access different segments concurrently.
 * - Iteration: Iterators returned by ConcurrentHashMap are weakly consistent, meaning they reflect the state of the
 * map at some point during or after the creation of the iterator. They do not throw ConcurrentModificationException,
 * allowing safe iteration even when other threads are modifying the map.
 *
 */
public class ConcurrentHashMaps {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();

        // Adding elements to the ConcurrentHashMap
        concurrentMap.put("A", 1);
        concurrentMap.put("B", 2);
        concurrentMap.put("C", 3);

        // Accessing elements from the ConcurrentHashMap
        System.out.println("Value for key A: " + concurrentMap.get("A"));
        System.out.println("Value for key B: " + concurrentMap.get("B"));

        // Removing an element from the ConcurrentHashMap
        concurrentMap.remove("C");

        // Iterating over the ConcurrentHashMap
        System.out.println("Iterating over ConcurrentHashMap:");
        for (java.util.Map.Entry<String, Integer> entry : concurrentMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

