package com.toolkit.java.vault.core_concepts.collections.maps;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap:
 * <p>
 * ConcurrentHashMap is a thread-safe implementation of the Map interface in Java.
 * It allows concurrent access to the map by multiple threads without the need for external synchronization.
 * It achieves this by dividing the map into segments and locking only the segment that is being accessed,
 * allowing other threads to access other segments concurrently.
 *
 * <p>
 * Key Features:
 * 1. Thread-Safety: ConcurrentHashMap is designed for concurrent access and provides thread-safe operations
 * without the need for external synchronization.
 * 2. High Performance: It allows multiple threads to read and write to the map concurrently, providing better
 * performance compared to synchronized maps.
 * 3. No Null Keys or Values: ConcurrentHashMap does not allow null keys or null values. Attempting to insert
 * a null key or value will result in a NullPointerException.
 * 4. Iterators: The iterators returned by ConcurrentHashMap are weakly consistent, meaning they reflect some,
 * but not necessarily all, of the changes made to the map after the iterator was created.
 */
public class ConcurrentHashMaps {
}

class ConcurrentHashMapExample {
    public static void main(String[] args) {
        // Create a ConcurrentHashMap instance
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        // Adding key-value pairs to the ConcurrentHashMap
        concurrentHashMap.put("One", 1);
        concurrentHashMap.put("Two", 2);
        concurrentHashMap.put("Three", 3);
        concurrentHashMap.put("Four", 4);

        // Retrieving a value by key
        Integer value = concurrentHashMap.get("Two");
        System.out.println("Value associated with key 'Two': " + value); // Output: Value associated with key 'Two': 2

        // Removing a key-value pair by key
        concurrentHashMap.remove("Three");

        // Iterating over the entries using an Entry Set and Iterator
        System.out.println("\nIterating over entries using Entry Set and Iterator:"); // Output: Iterating over entries using Entry Set and Iterator:
        for (java.util.Map.Entry<String, Integer> entry : concurrentHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}