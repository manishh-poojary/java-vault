package com.toolkit.java.vault.core_concepts.collections.maps;

import java.util.Map;

/**
 * HashMap
 *
 * <p>
 * A HashMap is a data structure that implements the Map interface in Java. It stores key-value pairs,
 * where each key is unique and maps to a specific value. HashMaps are part of the Java Collections
 * Framework and provide efficient retrieval and storage of data.
 *
 * <p>
 * Key points about HashMaps in Java:
 * 1. Key-Value Pairs: Each entry in a HashMap consists of a key and a corresponding value.
 * 2. Unique Keys: Keys in a HashMap must be unique, while values can be duplicated.
 * 3. Null Values: HashMaps allow one null key and multiple null values.
 * 4. Performance: HashMaps provide average constant-time complexity (O(1)) for basic operations like get() and put().
 * 5. Non-Synchronized: HashMaps are not synchronized, making them unsuitable for concurrent access without external synchronization.
 *
 * <p>
 * Use Cases:
 * - Caching data for quick retrieval
 * - Storing configuration settings
 * - Implementing associative arrays or dictionaries
 */
public class HashMaps {

    public static void main(String[] args) {
        // Creating a HashMap instance
        java.util.HashMap<String, Integer> hashMap = new java.util.HashMap<>();

        // Adding key-value pairs to the HashMap
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);
        hashMap.put("Four", 4);

        // Retrieving a value by key
        Integer value = hashMap.get("Two");
        System.out.println("Value associated with key 'Two': " + value); // Output: Value associated with key 'Two': 2

        // Removing a key-value pair by key
        hashMap.remove("Three");

        // Iterating over the entries using an Entry Set and Iterator
        System.out.println("\nIterating over entries using Entry Set and Iterator:");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
