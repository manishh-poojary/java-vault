package com.toolkit.java.vault.core_concepts.multithreading.concurrency.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * BlockingQueues is a class that demonstrates the usage of blocking queues in Java.
 * Blocking queues are thread-safe data structures that allow multiple threads to
 * safely add and remove elements from the queue. They provide blocking operations
 * for adding and removing elements, which means that if the queue is full, a thread
 * trying to add an element will block until space becomes available, and if the queue
 * is empty, a thread trying to remove an element will block until an element becomes
 * available.
 *
 * <p>
 * In this class, we can implement various types of blocking queues such as ArrayBlockingQueue,
 * LinkedBlockingQueue, PriorityBlockingQueue, etc., and demonstrate their usage in a multi-threaded
 * environment.
 */
public class BlockingQueues {
}

class ArrayBlockingQueueExample {
    private static final int BUFFER_SIZE = 5;
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(BUFFER_SIZE);

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();
    }
}

class PriorityBlockingQueueExample {
    private static final int BUFFER_SIZE = 5;
    private static BlockingQueue<Integer> queue = new PriorityBlockingQueue<>(BUFFER_SIZE);

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();
    }
}

class LinkedBlockingQueueExample {
    private static final int BUFFER_SIZE = 5;
    private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(BUFFER_SIZE);

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                queue.put(i);
                System.out.println("Produced: " + i);
                Thread.sleep(100); // Simulate time taken to produce an item
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                int value = queue.take();
                System.out.println("Consumed: " + value);
                Thread.sleep(150); // Simulate time taken to consume an item
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
