package com.toolkit.java.vault.core_concepts.multithreading.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Producer-Consumer Problem in Java
 *
 * <p>
 * The Producer-Consumer problem is a classic synchronization problem in concurrent programming.
 * It involves two types of threads: producers and consumers, which share a common buffer.
 * The producer generates data and puts it into the buffer, while the consumer takes data from the
 * buffer and processes it. The challenge is to ensure that the producer does not add data to a full
 * buffer and the consumer does not remove data from an empty buffer.
 *
 * <p>
 * In this implementation, we use a shared queue as the buffer, along with synchronization mechanisms
 * (wait() and notify()) to coordinate access between producer and consumer threads.
 */
public class ProducerConsumerProblem {
}

/**
 * ProducerConsumerExample demonstrates a simple implementation of the Producer-Consumer problem
 * using a BlockingQueue to handle synchronization between producer and consumer threads.
 */
class ProducerConsumerExample {

    private static final int BUFFER_SIZE = 10;
    private static BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(BUFFER_SIZE);

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable {
    private final BlockingQueue<Integer> buffer;

    public Producer(BlockingQueue<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                buffer.put(i);
                System.out.println("Produced: " + i);
                Thread.sleep(100); // Simulate time taken to produce an item
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> buffer;

    public Consumer(BlockingQueue<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                int item = buffer.take();
                System.out.println("Consumed: " + item);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            try {
                Thread.sleep(150); // Simulate time taken to consume an item
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

/**
 * ProducerConsumerWithWaitNotify demonstrates a simple implementation of the Producer-Consumer problem
 * using wait() and notify() for synchronization between producer and consumer threads.
 */

class ProducerConsumerWithWaitNotify {
    private static final int BUFFER_SIZE = 10;
    private final int[] buffer = new int[BUFFER_SIZE];
    private int count = 0;

    public synchronized void produce(int value) throws InterruptedException {
        while (count == BUFFER_SIZE) {
            wait(); // Wait if the buffer is full
        }
        buffer[count++] = value;
        System.out.println("Produced: " + value);
        notify(); // Notify the consumer that an item has been produced
    }

    public synchronized int consume() throws InterruptedException {
        while (count == 0) {
            wait(); // Wait if the buffer is empty
        }
        int value = buffer[--count];
        System.out.println("Consumed: " + value);
        notify(); // Notify the producer that an item has been consumed
        return value;
    }

    public static void main(String[] args) {
        ProducerConsumerWithWaitNotify pc = new ProducerConsumerWithWaitNotify();

        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    pc.produce(i);
                    Thread.sleep(100); // Simulate time taken to produce an item
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    pc.consume();
                    Thread.sleep(150); // Simulate time taken to consume an item
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
