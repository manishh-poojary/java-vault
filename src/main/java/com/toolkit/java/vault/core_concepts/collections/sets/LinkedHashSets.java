package com.toolkit.java.vault.core_concepts.collections.sets;

/**
 * LinkedHashSet
 *
 * <p>
 * A LinkedHashSet is a collection that combines the features of a HashSet and a LinkedList.
 * It maintains the uniqueness of elements like a HashSet, while also preserving the insertion
 * order of elements like a LinkedList.
 *
 * <p>
 * Key points about LinkedHashSet in Java:
 * 1. Uniqueness: Like a HashSet, a LinkedHashSet does not allow duplicate elements.
 * 2. Insertion Order: Unlike a HashSet, a LinkedHashSet maintains the order in which elements were added.
 * 3. Performance: The performance of basic operations (add, remove, contains) is generally O(1),
 *    similar to HashSet.
 * 4. Null Elements: A LinkedHashSet allows one null element.
 * 5. Iteration: The iteration order of elements is predictable and follows the order of insertion.
 * 6. Thread Safety: LinkedHashSet is not synchronized, so if multiple threads access it concurrently,
 *    external synchronization is required.
 *
 * <p>
 * Use Cases:
 * - When you need to maintain a collection of unique elements while preserving their insertion order.
 * - Useful in scenarios where you want to eliminate duplicates but still need to process elements
 *   in the order they were added.
 */
public class LinkedHashSets {

    public static void main(String[] args) {
        // Create a LinkedHashSet
        java.util.LinkedHashSet<String> linkedHashSet = new java.util.LinkedHashSet<>();

        // Add elements to the LinkedHashSet
        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Cherry");
        linkedHashSet.add("Date");
        linkedHashSet.add("Elderberry");

        // Attempt to add a duplicate element
        boolean isAdded = linkedHashSet.add("Apple"); // This will not be added
        System.out.println("Was 'Apple' added again? " + isAdded); // Output: false

        // Print the elements of the LinkedHashSet
        System.out.println("Elements in LinkedHashSet: " + linkedHashSet);

        // Iterate through the LinkedHashSet
        System.out.println("Iterating through LinkedHashSet:");
        for (String fruit : linkedHashSet) {
            System.out.println(fruit);
        }
    }
}