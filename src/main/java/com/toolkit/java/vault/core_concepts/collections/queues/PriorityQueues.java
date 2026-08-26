package com.toolkit.java.vault.core_concepts.collections.queues;

import java.util.PriorityQueue;

/**
 * Priority Queue
 *
 * <p>
 * A priority queue is an abstract data type that operates similarly to a regular queue,
 * but with an added feature: each element in the priority queue has a "priority"
 * associated with it. Elements with higher priority are dequeued before elements with
 * lower priority, regardless of their order in the queue.
 *
 * <p>
 * Key points about priority queues in Java:
 * 1. Priority: Each element has a priority level, and elements are served based
 * on their priority rather than their insertion order.
 * 2. Implementation: In Java, the `PriorityQueue` class is part of the `java.util` package
 * and implements the `Queue` interface.
 * 3. Ordering: By default, the `PriorityQueue` orders its elements according to their natural
 * ordering (if they implement `Comparable`) or by a provided `Comparator`.
 * 4. Operations: Common operations include adding elements (`offer`), removing the
 * highest-priority element (`poll`), and peeking at the highest-priority element without
 * removing it (`peek`).
 * 5. Use Cases: Priority queues are used in various applications such as scheduling tasks,
 * managing resources, and implementing algorithms like Dijkstra's shortest path.
 *
 * <p>
 * Types of Priority Queues:
 * 1. Min-Heap: A priority queue where the element with the lowest priority is served first.
 * 2. Max-Heap: A priority queue where the element with the highest priority is served first.
 * 3. Custom Priority: A priority queue that allows custom ordering based on user-defined criteria.
 */
public class PriorityQueues {
}

class MinHeapPriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Adding elements to the priority queue
        minHeap.offer(5);
        minHeap.offer(1);
        minHeap.offer(3);

        // Removing elements based on priority (lowest first)
        while (!minHeap.isEmpty()) {
            System.out.println("Removed: " + minHeap.poll());
        }
    }
}

class MaxHeapPriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Adding elements to the priority queue
        maxHeap.offer(5);
        maxHeap.offer(1);
        maxHeap.offer(3);

        // Removing elements based on priority (highest first)
        while (!maxHeap.isEmpty()) {
            System.out.println("Removed: " + maxHeap.poll());
        }
    }
}

class CustomPriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<String> customPriorityQueue = new PriorityQueue<>((a, b) -> a.length() - b.length());

        // Adding elements to the priority queue
        customPriorityQueue.offer("apple");
        customPriorityQueue.offer("banana");
        customPriorityQueue.offer("kiwi");

        // Removing elements based on custom priority (shortest string first)
        while (!customPriorityQueue.isEmpty()) {
            System.out.println("Removed: " + customPriorityQueue.poll());
        }
    }
}