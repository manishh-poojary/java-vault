package com.toolkit.java.vault.core_concepts.collections.contents;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Synchronized HashMap
 *
 * <p>
 * A synchronized HashMap is a thread-safe version of the standard HashMap in Java. It allows multiple threads to
 * access and modify the map concurrently without causing data inconsistency or corruption.
 *
 * <p>
 * Key points about synchronized HashMap in Java:
 * 1. Thread Safety: Synchronized HashMap ensures that only one thread can access the map at a time, preventing
 * concurrent modification issues.
 * 2. Performance: While synchronized HashMap provides thread safety, it may have lower performance compared to
 * non-synchronized maps due to the overhead of synchronization.
 * 3. Usage: Synchronized HashMap is suitable for scenarios where multiple threads need to read and write to the map
 * concurrently.
 * 4. Alternatives: For better performance in concurrent scenarios, consider using ConcurrentHashMap, which allows
 * for more fine-grained locking and better scalability.
 *
 * <p>
 * Internal Working of Synchronized HashMap:
 * 1. Synchronized HashMap is typically implemented by wrapping a standard HashMap with synchronized methods.
 * 2. Each method that modifies the map (e.g., put, remove) is synchronized, ensuring that only one thread can execute it at a time.
 * 3. Read operations (e.g., get) may also be synchronized to ensure visibility of changes made by other threads
 * 4. Iterators returned by synchronized HashMap are not fail-fast, meaning they may not throw
 * ConcurrentModificationException if the map is modified while iterating.
 * 5. To iterate over a synchronized HashMap safely, it is recommended to synchronize on the map object during iteration.
 *
 */
public class SynchronizedHashMap {

    public static void main(String[] args) {
        Map<String, Integer> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
        synchronizedMap.put("key1", 1);
        synchronizedMap.put("key2", 2);
    }
}
