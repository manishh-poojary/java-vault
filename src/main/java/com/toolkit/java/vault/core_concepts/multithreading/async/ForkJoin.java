package com.toolkit.java.vault.core_concepts.multithreading.async;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoin is a class that demonstrates the Fork/Join framework in Java.
 * The Fork/Join framework is designed to take advantage of multiple processors and
 * efficiently execute tasks that can be broken down into smaller subtasks.
 *
 * <p>
 * The Fork/Join framework uses a work-stealing algorithm, where idle threads can "steal"
 * tasks from busy threads, improving overall performance and resource utilization.
 *
 * <p>
 * Example usage:
 * - Divide a large task into smaller subtasks using the fork() method.
 * - Execute the subtasks concurrently using the join() method to wait for their completion.
 *
 * <p>
 * Important Points:
 * - The Fork/Join framework is suitable for tasks that can be recursively divided into smaller tasks.
 * - It is part of the java.util.concurrent package and provides classes like ForkJoinPool and RecursiveTask.
 * <p>
 * RecuresiveTask is an abstract class that represents a task that returns a result and can be recursively
 * divided into smaller tasks.
 * RecursiveAction is an abstract class that represents a task that does not return a result and can be recursively
 * divided into smaller tasks.
 */
public class ForkJoin {

    public static void main(String[] args) {
        int[] numbers = new int[10000];
        // Filling array with 1s for easy verification
        Arrays.fill(numbers, 1);

        // Use the common ForkJoin pool instance
        ForkJoinPool pool = ForkJoinPool.commonPool();
        ArraySumTask task = new ArraySumTask(numbers, 0, numbers.length);

        long totalSum = pool.invoke(task);
        System.out.println("Total Sum: " + totalSum); // Print the total sum
    }
}

class ArraySumTask extends RecursiveTask<Long> {
    private final int[] array;
    private final int start, end;
    private static final int THRESHOLD = 2500; // Limit where splitting stops

    public ArraySumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        // Base case: If array slice is small enough, compute sequentially
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        }

        // Recursive case: Split the task into two halves
        int mid = start + (end - start) / 2;
        ArraySumTask leftTask = new ArraySumTask(array, start, mid);
        ArraySumTask rightTask = new ArraySumTask(array, mid, end);

        // Fork the left task to run asynchronously in the pool
        leftTask.fork();

        // Compute the right task directly on the current thread
        long rightResult = rightTask.compute();

        // Wait for and retrieve the result of the left task
        long leftResult = leftTask.join();

        return leftResult + rightResult;
    }
}