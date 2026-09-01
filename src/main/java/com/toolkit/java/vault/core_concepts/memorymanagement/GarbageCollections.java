package com.toolkit.java.vault.core_concepts.memorymanagement;

/**
 * Garbage Collection in Java
 *
 * <p>
 * Garbage collection is the process of automatically identifying and reclaiming memory that is no longer in use by the
 * program. In Java, the garbage collector (GC) is responsible for managing memory and freeing up resources that are no
 * longer needed.
 *
 * <p>
 * The garbage collector works by identifying objects that are no longer reachable from any live thread or static references.
 * When an object becomes unreachable, it is considered eligible for garbage collection. The GC then reclaims the memory
 * occupied by these objects, making it available for future allocations.
 *
 * <p>
 * There are different algorithms used for garbage collection, including:
 * - Mark-and-Sweep: This algorithm marks all reachable objects and then sweeps through the heap to collect unmarked objects.
 * - Generational Garbage Collection: This approach divides the heap into generations (young, old) and collects objects
 *   based on their age.
 * - Reference Counting: This technique keeps track of the number of references to an object and collects it when the
 *   count reaches zero.
 * - Serial and Parallel Collectors: These collectors use multiple threads to perform garbage collection, improving performance.
 * - CMS (Concurrent Mark-Sweep) and G1 (Garbage-First) Collectors: These are advanced collectors that aim to minimize
 *   pause times and improve throughput.
 *
 * <p>
 * Developers can also suggest garbage collection using System.gc(), but it is not guaranteed to run immediately or at all.
 *
 * <p>
 * Types of References in Java:
 * - Strong Reference: The default type of reference in Java. Objects with strong references are not eligible for garbage collection.
 * - Soft Reference: Objects with soft references are collected only when the JVM is low on memory.
 *    They are useful for implementing memory-sensitive caches.
 * - Weak Reference: Objects with weak references are collected during the next garbage collection cycle,
 *    regardless of memory availability.
 * - Phantom Reference: Objects with phantom references are collected after they have been finalized, and they are used
 *    for scheduling cleanup operations.
 *
 */
public class GarbageCollections {
}

/**
 * GarbageFirstCollector (~200ms)
 *
 * <p>
 * The Garbage-First (G1) Collector is a server-style garbage collector for multi-processor machines with large memories.
 * It is designed to meet the needs of applications that require low pause times and high throughput. G1 divides the heap
 * into regions and prioritizes the collection of regions with the most garbage, hence the name "Garbage-First."
 *
 * <p>
 * Key Features of G1:
 * - Region-Based Heap: The heap is divided into equal-sized regions, which can be collected independently.
 * - Concurrent Marking: G1 performs concurrent marking to identify live objects while minimizing pause times.
 * - Predictable Pause Times: G1 aims to provide predictable pause times by allowing developers to set pause time goals.
 * - Mixed Collections: G1 can perform mixed collections, collecting both young and old regions in a single cycle.
 *
 * <p>
 * G1 is suitable for applications that require low latency and can tolerate some level of throughput trade-offs. It is
 * particularly effective for applications with large heaps and complex object graphs.
 */
class GarbageFirstCollector {
    public static void main(String[] args) {

    }
}

/**
 * Z Garbage Collector (ZGC) (-10ms)
 *
 * <p>
 * ZGC is a scalable, low-latency garbage collector designed for applications that require large heaps and minimal pause times.
 * It is capable of handling heaps ranging from a few gigabytes to terabytes in size. ZGC uses colored pointers and load barriers
 * to achieve concurrent garbage collection with very low pause times.
 *
 * <p>
 * Key Features of ZGC:
 * - Low Pause Times: ZGC aims to keep pause times below 10 milliseconds, even for large heaps.
 * - Concurrent Collection: Most of the garbage collection work is done concurrently with the application threads.
 * - Region-Based Heap: Similar to G1, ZGC divides the heap into regions for efficient memory management.
 * - Load Barriers: ZGC uses load barriers to track object references and manage memory without stopping the application threads.
 *
 * <p>
 * ZGC is suitable for applications that require high responsiveness and can tolerate some level of throughput trade-offs.
 * It is particularly effective for applications with large heaps and complex object graphs.
 */
class ZGC {
}

/**
 * Shenandoah Garbage Collector
 *
 * <p>
 * Shenandoah is a low-pause-time garbage collector designed for applications that require large heaps and minimal pause times.
 * It aims to reduce pause times by performing concurrent compaction of the heap, allowing the application to continue running
 * while garbage collection is in progress.
 *
 * <p>
 * Key Features of Shenandoah:
 * - Low Pause Times: Shenandoah aims to keep pause times low, even for large heaps.
 * - Concurrent Compaction: Shenandoah performs concurrent compaction of the heap, reducing fragmentation and improving
 *      memory utilization.
 * - Region-Based Heap: Similar to G1 and ZGC, Shenandoah divides the heap into regions for efficient memory management.
 *
 * <p>
 * Shenandoah is suitable for applications that require high responsiveness and can tolerate some level of throughput trade-offs.
 * It is particularly effective for applications with large heaps and complex object graphs.
 */
class ShenandoahGC {
    public static void main(String[] args) {

    }
}
