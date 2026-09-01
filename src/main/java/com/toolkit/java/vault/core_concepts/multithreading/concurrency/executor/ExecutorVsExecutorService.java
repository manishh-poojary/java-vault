package com.toolkit.java.vault.core_concepts.multithreading.concurrency.executor;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * Executor:
 * - It is a simple interface in Java that provides a way to decouple task submission from task execution.
 * It defines a single method, execute(Runnable command), which executes the given command in a thread pool.
 *
 * <p>
 * ExecutorService:
 * - It is a subinterface of Executor that represents a more complete version of the Executor, providing methods
 * to manage the lifecycle of the thread pool, submit tasks for execution, and obtain Futures representing task
 * results.
 *
 * <p>
 * Differences between them:
 *
 * <p>
 * 1. Lifecycle Management:
 * - Executor: It does not provide methods for managing the lifecycle of the underlying thread pool.
 * It only provides a way to execute tasks.
 * - ExecutorService: It extends Executor and adds methods for managing the lifecycle of the thread pool,
 * such as shutdown(), shutdownNow(), and awaitTermination().
 *
 * <p>
 * 2. Task Submission and Execution:
 * - Both Executor and ExecutorService provide methods to submit tasks for execution (execute(Runnable command) in
 * Executor, submit(Runnable task) and submit(Callable<T> task) in ExecutorService).
 *
 * <p>
 * Task Result Handling:
 * - Executor: It does not provide a way to obtain the result of a task execution directly.
 * - ExecutorService: It provides methods to submit tasks that return a Future representing the result of the task
 * execution (submit(Callable<T> task)). It also allows for task result retrieval through the Future interface.
 *
 * <p>
 * Termination:
 * - Executor: It does not provide methods for terminating the thread pool.
 * - ExecutorService: It provides methods to gracefully shut down the thread pool (shutdown()), forcibly shut down
 * the thread pool (shutdownNow()), and await termination of all tasks (awaitTermination()).
 *
 * <p>
 * Use Case Scenarios:
 * - Use Executor when you only need to execute tasks asynchronously without managing the thread pool's lifecycle.
 * - Use ExecutorService when you need more control over the thread pool, such as managing its lifecycle, submitting
 * tasks with results, and awaiting termination.
 */
public class ExecutorVsExecutorService {
}

class ExecutorExample implements Executor {
    @Override
    public void execute(Runnable command) {
        // Execute the command in a new thread
        new Thread(command).start();
    }
}

class ExecutorServiceExample implements ExecutorService {

    @Override
    public void shutdown() {

    }

    @Override
    public List<Runnable> shutdownNow() {
        return List.of();
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return null;
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return null;
    }

    @Override
    public Future<?> submit(Runnable task) {
        return null;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return List.of();
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return List.of();
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    @Override
    public void close() {
        ExecutorService.super.close();
    }

    @Override
    public void execute(Runnable command) {

    }
}
