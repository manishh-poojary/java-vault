package com.toolkit.java.vault.core_concepts.collections.sets;

import java.util.TreeSet;

/**
 * TreeSet
 *
 * <p>
 * A TreeSet is a collection in Java that implements the Set interface and is based on a tree structure (specifically, a Red-Black tree).
 * It stores elements in a sorted and ascending order, and it does not allow duplicate elements.
 * The TreeSet class is part of the Java Collections Framework.
 *
 * <p>
 * Key points about TreeSet in Java:
 * 1. Sorted Order: Elements in a TreeSet are stored in their natural order (for example,
 * numbers in ascending order or strings in lexicographical order).
 * 2. No Duplicates: TreeSet does not allow duplicate elements. If you try to add a duplicate element, it will be ignored.
 * 3. Performance: The time complexity for basic operations like add, remove, and contains is O(log n)
 * due to the underlying tree structure.
 * 4. Null Elements: TreeSet does not allow null elements. Attempting to add a null element will throw a NullPointerException.
 * 5. NavigableSet Interface: TreeSet implements the NavigableSet interface, which provides methods for
 * navigation and retrieval of elements based on their order.
 * 6. Thread Safety: TreeSet is not synchronized, meaning it is not thread-safe. If multiple
 *  threads access a TreeSet concurrently, and at least one of the threads modifies the set,
 *  it must be synchronized externally.
 */
public class TreeSets {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Adding elements
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(8);

        // Displaying elements in sorted order
        System.out.println("TreeSet: " + treeSet); // Output: TreeSet: [2, 5, 8]

        // Removing an element
        treeSet.remove(5);

        // Checking if an element exists
        boolean contains = treeSet.contains(2); // true

        // Displaying the updated TreeSet
        System.out.println("Updated TreeSet: " + treeSet); // Output: Updated TreeSet: [2, 8]
    }
}
