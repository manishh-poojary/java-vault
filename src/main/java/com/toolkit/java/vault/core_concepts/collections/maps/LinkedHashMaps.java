package com.toolkit.java.vault.core_concepts.collections.maps;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap
 *
 * <p>
 * A LinkedHashMap is a hash table and linked list implementation of the Map interface in Java. It maintains a
 * doubly-linked list running through all of its entries, which defines the iteration ordering. This ordering is
 * normally the order in which keys were inserted into the map (insertion-order).
 *
 * <p>
 * Key points about LinkedHashMap in Java:
 * 1. Maintains Insertion Order: The order of elements is preserved based on their insertion order.
 * 2. Allows Null Values: It allows one null key and multiple null values.
 * 3. Performance: Provides constant-time performance for basic operations (get and put), assuming
 * the hash function disperses elements properly among the buckets.
 * 4. Iteration: The iteration over the entries is predictable and follows the insertion order.
 * 5. Use Cases: Useful when you need a map that maintains the order of its elements, such as caching
 * or maintaining a history of operations.
 *
 */
public class LinkedHashMaps {

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
