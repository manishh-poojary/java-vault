package com.toolkit.java.vault.core_concepts.collections.queues;

import java.util.LinkedList;

/**
 * Deque (Double-Ended Queue)
 *
 * <p>
 * A deque (double-ended queue) is a linear data structure that allows insertion and removal of elements from both ends,
 * i.e., the front and the rear. It can be visualized as a queue where elements can be added or removed from either end.
 *
 * <p>
 * Key points about deques in Java:
 * 1. Double-Ended: Elements can be added or removed from both the front and the rear of the deque.
 * 2. Operations: Common operations on a deque include addFirst, addLast, removeFirst, removeLast, peekFirst, and peekLast.
 * 3. Implementation: Deques can be implemented using arrays or linked lists.
 * 4. Use Cases: Deques are used in various applications such as task scheduling, undo mechanisms, and sliding window problems.
 * 5. Thread Safety: Deques are not inherently thread-safe, and concurrent modifications may require synchronization.
 *
 * <p>
 * Types of Deques:
 * 1. ArrayDeque: A resizable array implementation of a deque that provides efficient access to elements.
 * 2. LinkedList: A linked list implementation of a deque that allows for dynamic resizing and efficient insertion/removal.
 */
public class Deques {
}

class ArrayDequeExample {
    public static void main(String[] args) {
        java.util.ArrayDeque<Integer> deque = new java.util.ArrayDeque<>();

        // Add elements to the front and rear of the deque
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        deque.addLast(3);

        System.out.println("Deque after adding elements: " + deque);

        // Remove elements from the front and rear of the deque
        int removedFirst = deque.removeFirst();
        int removedLast = deque.removeLast();

        System.out.println("Removed first element: " + removedFirst);
        System.out.println("Removed last element: " + removedLast);
        System.out.println("Deque after removing elements: " + deque);
    }
}

class LinkedListDequeExample {
    public static void main(String[] args) {
        LinkedList<Integer> deque = new LinkedList<>();

        // Add elements to the front and rear of the deque
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        deque.addLast(3);

        System.out.println("Deque after adding elements: " + deque);

        // Remove elements from the front and rear of the deque
        int removedFirst = deque.removeFirst();
        int removedLast = deque.removeLast();

        System.out.println("Removed first element: " + removedFirst);
        System.out.println("Removed last element: " + removedLast);
        System.out.println("Deque after removing elements: " + deque);
    }
}
