package com.toolkit.java.vault.core_concepts.collections.maps;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Set;

/**
 * Hash Tables
 *
 * <p>
 * A hash table is a data structure that implements an associative array abstract data type, a structure that can map keys to values.
 * It uses a hash function to compute an index into an array of buckets or slots, from which the desired value can be found.
 *
 * <p>
 * Key points about hash tables in Java:
 * 1. Hash Function: A hash function is used to convert the key into an index in the array.
 * 2. Collision Handling: When two keys hash to the same index, a collision occurs. Common methods for handling collisions include chaining and open addressing.
 * 3. Performance: Hash tables provide average-case constant time complexity O(1) for search, insert, and delete operations.
 * 4. Load Factor: The load factor is a measure of how full the hash table is allowed to get before its capacity is automatically increased.
 * 5. Resizing: When the load factor exceeds a certain threshold, the hash table is resized to maintain performance.
 *
 * <p>
 * Types of Hash Tables:
 * 1. Separate Chaining: Each bucket contains a linked list of entries that hash to the same index.
 * 2. Open Addressing: All entry records are stored in the array itself, and when a collision occurs, the algorithm searches for the next available slot.
 */
public class HashTables {

    public static void main(String[] args) {
        // Creating a Hashtable instance
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        // Adding key-value pairs to the Hashtable
        hashtable.put("One", 1);
        hashtable.put("Two", 2);
        hashtable.put("Three", 3);
        hashtable.put("Four", 4);

        // Retrieving a value by key
        Integer value = hashtable.get("Two");
        System.out.println("Value associated with key 'Two': " + value); // Output: Value associated with key 'Two': 2

        // Removing a key-value pair by key
        hashtable.remove("Three");

        // Iterating over the keys using an Enumeration
        System.out.println("\nIterating over keys using Enumeration:"); // Output: Iterating over keys using Enumeration:
        Enumeration<String> keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println("Key: " + key + ", Value: " + hashtable.get(key));
        }
//        Output:
//        Key: One, Value: 1
//        Key: Four, Value: 4
//        Key: Two, Value: 2


        // Iterating over the entries using an Entry Set and Iterator
        System.out.println("\nIterating over entries using Entry Set and Iterator:"); // Output: Iterating over entries using Entry Set and Iterator:
        Set<Entry<String, Integer>> entrySet = hashtable.entrySet();
        Iterator<Entry<String, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Entry<String, Integer> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
//        Output:
//        Key: One, Value: 1
//        Key: Four, Value: 4
//        Key: Two, Value: 2
    }
}

