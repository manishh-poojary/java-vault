package com.toolkit.java.vault.core_concepts.multithreading.concurrency.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * Locks in Java
 *
 * <p>
 * In Java, locks are synchronization mechanisms that allow threads to have exclusive access to shared resources.
 * The primary purpose of locks is to prevent race conditions and ensure thread safety when multiple threads access
 * shared data concurrently.
 *
 * <p>
 * Java provides several types of locks, including:
 * 1. Intrinsic Locks (Synchronized Blocks/Methods): Every object in Java has an intrinsic lock associated with it.
 * When a thread enters a synchronized block or method, it acquires the intrinsic lock of the object, preventing
 * other threads from entering any synchronized block or method on the same object until the lock is released.
 * 2. Reentrant Locks (java.util.concurrent.locks.ReentrantLock): ReentrantLock is a more flexible locking mechanism
 * that allows threads to acquire the same lock multiple times. It provides additional features like fairness policies,
 * tryLock(), and the ability to interrupt threads waiting for the lock.
 * 3. ReadWrite Locks (java.util.concurrent.locks.ReentrantReadWriteLock): ReadWriteLock allows multiple threads to
 * read a shared resource concurrently while ensuring exclusive access for write operations. It provides separate
 * locks for reading and writing, improving performance in scenarios with frequent reads and infrequent writes.
 * 4. Stamped Locks (java.util.concurrent.locks.StampedLock): StampedLock is a more advanced locking mechanism that
 * provides optimistic and pessimistic locking strategies. It allows threads to acquire a lock with a stamp, enabling
 * them to perform optimistic reads and upgrade to exclusive locks when necessary.
 * 5. Semaphore (java.util.concurrent.Semaphore): Although not a traditional lock, Semaphore can be used to control
 * access to a shared resource by limiting the number of threads that can access it concurrently. It maintains a set
 * of permits, and threads must acquire a permit before accessing the resource.
 * <p>
 */
public class Locks {
}

class IntrinsicLockExample {

    private int count = 0;

    synchronized void increment() {
        count++;
    }

    void decrement() {
        synchronized (this) {
            count--;
        }
    }

    int getCount() {
        return this.count;
    }

    public static void main(String[] args) {
        IntrinsicLockExample intrinsicLockExample = new IntrinsicLockExample();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            for (int i = 0; i < 1000000; i++) {
                intrinsicLockExample.increment();
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 1000000; i++) {
                intrinsicLockExample.decrement();
            }
        });
        System.out.println("Final Count: " + intrinsicLockExample.getCount());
        executorService.shutdownNow();
    }
}

class ReentrantLockExample {
    // Implementation of ReentrantLock example can be added here

    private int count = 0;
    ReentrantLock lock = new ReentrantLock();

    void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    void decrement() {
        lock.lock();
        try {
            count--;
        } finally {
            lock.unlock();
        }
    }

    int getCount() {
        return this.count;
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            for (int i = 0; i < 1000000; i++) {
                reentrantLockExample.increment();
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 1000000; i++) {
                reentrantLockExample.decrement();
            }
        });
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Final Count: " + reentrantLockExample.getCount());
    }
}

class ReadWriteLockExample {
    // Implementation of ReadWriteLock example can be added here

    private int count = 0;
    ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    void increment() {
        rwLock.writeLock().lock();
        try {
            count++;
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    void decrement() {
        rwLock.writeLock().lock();
        try {
            count--;
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    int count() {
        rwLock.readLock().lock();
        try {
            return count;
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockExample readWriteLockExample = new ReadWriteLockExample();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            for (int i = 0; i < 1000000; i++) {
                readWriteLockExample.increment();
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 1000000; i++) {
                readWriteLockExample.decrement();
            }
        });
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Final Count: " + readWriteLockExample.count());
    }
}

class StampedLockExample {
    // Implementation of StampedLock example can be added here

    private int count = 0;
    private final StampedLock stampedLock = new StampedLock();

    void increment() {
        long stamp = stampedLock.writeLock();
        try {
            count++;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    void decrement() {
        long stamp = stampedLock.writeLock();
        try {
            count--;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    int count() {
        long stamp = stampedLock.readLock();
        try {
            return count;
        } finally {
            stampedLock.unlockRead(stamp);
        }
    }

    public static void main(String[] args) {
        StampedLockExample stampedLockExample = new StampedLockExample();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            for (int i = 0; i < 1000000; i++) {
                stampedLockExample.increment();
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 1000000; i++) {
                stampedLockExample.decrement();
            }
        });

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Final Count: " + stampedLockExample.count());
    }
}

class SemaphoreExample {
    // Implementation of Semaphore example can be added here

    private int count = 0;
    Semaphore semaphore = new Semaphore(1);

    void increment() {
        try {
            semaphore.acquire();
            count++;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }

    void decrement() {
        try {
            semaphore.acquire();
            count--;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }

    int count() {
        try {
            semaphore.acquire();
            return count;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return -1; // Return an error value if interrupted
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        SemaphoreExample semaphoreExample = new SemaphoreExample();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            for (int i = 0; i < 1000000; i++) {
                semaphoreExample.increment();
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 1000000; i++) {
                semaphoreExample.decrement();
            }
        });

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Final Count: " + semaphoreExample.count());
    }
}
