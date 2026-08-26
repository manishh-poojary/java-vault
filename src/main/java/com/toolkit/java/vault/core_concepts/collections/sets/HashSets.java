package com.toolkit.java.vault.core_concepts.collections.sets;

import java.util.HashSet;

/**
 * HashSet
 *
 * <p>
 * A HashSet is a collection that implements the Set interface and is backed by a hash table.
 * It does not allow duplicate elements and does not guarantee any specific order of elements.
 *
 * <p>
 * Key points about HashSet in Java:
 * 1. Uniqueness: HashSet ensures that all elements are unique, meaning no duplicates are allowed.
 * 2. No Order: The elements in a HashSet are not ordered, and the order may change over time.
 * 3. Null Elements: HashSet allows one null element.
 * 4. Performance: HashSet provides constant-time performance for basic operations like add, remove, and contains,
 * assuming the hash function disperses elements properly.
 * 5. Thread Safety: HashSet is not inherently thread-safe, and concurrent modifications may require synchronization.
 *
 * <p>
 * Use Cases:
 * - Storing unique elements
 * - Removing duplicates from a collection
 * - Performing set operations like union, intersection, and difference
 *
 */
public class HashSets {

    public static void main(String[] args) {
        // Create a HashSet
        HashSet<String> set = new HashSet<>();

        // Add elements to the HashSet
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple"); // Duplicate element, will not be added

        // Print the HashSet
        System.out.println("HashSet: " + set);

        // Check if an element exists
        System.out.println("Contains 'Banana': " + set.contains("Banana"));

        // Remove an element
        set.remove("Cherry");
        System.out.println("After removing 'Cherry': " + set);
    }
}
