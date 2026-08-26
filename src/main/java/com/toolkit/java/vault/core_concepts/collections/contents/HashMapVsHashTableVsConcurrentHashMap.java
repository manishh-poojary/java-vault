package com.toolkit.java.vault.core_concepts.collections.contents;

/**
 * HashMap vs HashTable vs ConcurrentHashMap
 *
 * <p>
 * HashMap and Hashtable are both implementations of the Map interface in Java, used to store key-value pairs.
 * However, they have some differences in terms of synchronization, performance, and usage.
 *
 * <p>
 * Key points about HashMap:
 * 1. Not Synchronized: HashMap is not synchronized, which means it is not thread-safe. Multiple threads can
 * access it concurrently without any issues.
 * 2. Allows Null Keys and Values: HashMap allows one null key and multiple null values.
 * 3. Performance: HashMap generally provides better performance than Hashtable due to the lack of synchronization
 * overhead.
 * 4. Use Cases: HashMap is suitable for scenarios where thread safety is not a concern, and you want better performance.
 *
 * <p>
 * Key points about Hashtable:
 * 1. Synchronized: Hashtable is synchronized, which means it is thread-safe. Only one thread can access it at a time.
 * 2. Does Not Allow Null Keys or Values: Hashtable does not allow null keys or values.
 * 3. Legacy Class: Hashtable is considered a legacy class and is generally not recommended for new code.
 * It has been largely replaced by ConcurrentHashMap for thread-safe operations.
 * 4. Performance: Due to synchronization, Hashtable may have lower performance compared to HashMap in single-threaded scenarios.
 *
 * <p>
 * Key points about ConcurrentHashMap:
 * 1. Synchronized: ConcurrentHashMap is a thread-safe implementation of the Map interface that allows concurrent
 * access by multiple threads.
 * 2. Allows Null Values but Not Null Keys: ConcurrentHashMap allows null values but does not allow null keys.
 * 3. Performance: ConcurrentHashMap provides better performance than Hashtable in multithreaded environments due to
 * its finer-grained locking mechanism, which allows multiple threads to read and write concurrently.
 * 4. Use Cases: ConcurrentHashMap is suitable for scenarios where multiple threads need to read and write to a shared map.
 *
 * <p>
 * Summary:
 * - Use HashMap when you do not need synchronization and want better performance.
 * - Use Hashtable when you need thread safety, but consider using ConcurrentHashMap instead for better
 * performance in multithreaded environments.
 */
public class HashMapVsHashTableVsConcurrentHashMap {
}
