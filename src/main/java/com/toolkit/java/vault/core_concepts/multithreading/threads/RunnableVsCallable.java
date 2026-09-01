package com.toolkit.java.vault.core_concepts.multithreading.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Runnable vs Callable in Java
 *
 * <p>
 * In Java, both Runnable and Callable are interfaces that represent tasks that can be executed by a thread. However,
 * they have some key differences:
 *
 * <p>
 * 1. Return Value:
 * - Runnable: The run() method of the Runnable interface does not return any value (void).
 * - Callable: The call() method of the Callable interface returns a value of type V (generic).
 *
 * <p>
 * 2. Exception Handling:
 * - Runnable: The run() method cannot throw checked exceptions.
 * - Callable: The call() method can throw checked exceptions.
 *
 * <p>
 * 3. Usage:
 * - Runnable: It is typically used when you want to execute a task that does not need to return a result.
 * - Callable: It is used when you want to execute a task that needs to return a result or may throw an exception.
 *
 * <p>
 * Example usage:
 * - Runnable can be executed using Thread or ExecutorService.
 * - Callable can be executed using ExecutorService and returns a Future object to retrieve the result.
 */
public class RunnableVsCallable {

    public static void main(String[] args) {
        // Using Runnable
        RunnableExample runnableTask = new RunnableExample();
        Thread thread1 = new Thread(runnableTask);
        thread1.start();

        // Using Callable
        CallableExample callableTask = new CallableExample();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> futureResult = executorService.submit(callableTask);

        try {
            String result = futureResult.get(); // This will block until the result is available
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}


class RunnableExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable is running in thread: " + Thread.currentThread().getName());
    }
}

class CallableExample implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Callable is running in thread: " + Thread.currentThread().getName();
    }
}
