package com.toolkit.java.vault.core_concepts.collections.maps;

import java.util.TreeMap;

/**
 * TreeMap
 *
 * <p>
 * A TreeMap is a part of the Java Collections Framework and is an implementation of the Map interface that uses a
 * Red-Black tree structure to store key-value pairs in sorted order based on the natural ordering of the keys or a
 * specified comparator.
 *
 * <p>
 * Key points about TreeMap in Java:
 * 1. Sorted Order: TreeMap maintains the keys in sorted order, either by their natural ordering or by a custom
 * comparator provided at the time of creation.
 * 2. Key-Value Pairs: TreeMap stores data in key-value pairs, where each key is unique, and each key maps to a single
 * value.
 * 3. Null Keys: TreeMap does not allow null keys but allows multiple null values.
 * 4. Performance: The time complexity for basic operations (get, put, remove) is O(log n) due to the underlying tree
 * structure.
 * 5. NavigableMap Interface: TreeMap implements the NavigableMap interface, which provides additional methods for
 * navigation and retrieval of entries based on their order.
 *
 * <p>
 * Use Cases:
 * - When you need to maintain a sorted order of keys.
 * - When you need efficient retrieval and insertion of key-value pairs.
 */
public class TreeMaps {
    public static void main(String[] args) {

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");

        System.out.println("TreeMap: " + treeMap); // Output: TreeMap: {1=One, 2=Two, 3=Three}

    }
}
