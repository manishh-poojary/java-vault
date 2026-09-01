package com.toolkit.java.vault.core_concepts.memorymanagement;

/**
 * Heap Memory Deep Dive
 *
 * <p>
 * Heap memory is a crucial part of Java's memory management system. It is the runtime data area from which memory
 * for all class instances and arrays is allocated. The heap is shared among all threads and is managed by the garbage
 * collector, which automatically reclaims memory that is no longer in use.
 *
 * <p>
 * Key characteristics of heap memory:
 * - Shared Memory: All threads share the heap, allowing for efficient memory usage across the application.
 * - Dynamic Allocation: Objects are allocated on the heap at runtime, allowing for flexible memory management.
 * - Garbage Collection: The Java Virtual Machine (JVM) automatically manages memory in the heap through garbage collection,
 * freeing up memory occupied by objects that are no longer reachable.
 *
 * <p>
 * Understanding how heap memory works is essential for optimizing performance and preventing memory leaks in Java applications.
 *
 * <p>
 * Common issues related to heap memory include:
 * - OutOfMemoryError: This occurs when the JVM cannot allocate an object because it is out of heap memory.
 * It can be caused by memory leaks or excessive object creation.
 * - Memory Leaks: This happens when objects are no longer needed but are still referenced, preventing the
 * garbage collector from reclaiming their memory.
 * - Performance Degradation: Inefficient use of heap memory can lead to increased garbage collection activity,
 * which can degrade application performance.
 *
 * <p>
 * Generations of Heap Memory:
 * - Young Generation: This is where new objects are allocated. It is divided into Eden space and Survivor spaces.
 * Objects that survive garbage collection in the young generation are promoted to the old generation.
 * - Old Generation: This is where long-lived objects are stored. It is larger than the young generation and is
 * collected less frequently.
 *
 */
public class HeapMemoryDeepDive {
}

/* Young Generation:
 *
 * - Eden Space: This is where new objects are initially allocated. It is the first area of the young generation.
 *      When the Eden space fills up, a minor garbage collection occurs, and surviving objects are moved to the Survivor spaces.
 * - Survivor Spaces: These are two smaller areas (S0 and S1) that hold objects that have survived garbage collection
 *      in the Eden space. Objects are copied between these spaces during garbage collection.
 */
class YoungGeneration {
}
/*
 * Old Generation:
 *
 * - This is where long-lived objects are stored. Objects that have survived multiple garbage collection cycles
 *   in the young generation are promoted to the old generation.
 * - The old generation is larger than the young generation and is collected less frequently, typically during a
 *   major garbage collection event.
 * - Objects in the old generation are usually those that are expected to live for a long time, such as static variables
 *   and objects that are referenced by long-lived data structures.
 * - The old generation is also known as the tenured generation, and it is managed by the garbage collector to reclaim memory
 *   from objects that are no longer reachable.
 * - The old generation can be a source of performance issues if it becomes too full, leading to longer garbage collection pauses.
 * - If a huge number of objects are promoted to the old generation, it can lead to increased memory usage and potential
 * OutOfMemoryError.
 * - If a huge objects are added then it bypass Eden and Survivor space and directly goes to Old Generation.
 * This is called as Promotion.
 * - If the Old Generation is full and cannot accommodate new objects, it can lead to a Full GC, which is a more
 * expensive garbage collection process that can cause application pauses.
 * - Whenever the Eden space is full, a minor GC is triggered. If the Survivor spaces are also full, objects that
 *  survive the minor GC are promoted to the Old Generation.
 * - Everytime an object survives a Minor GC, it age counter increases. Once the age counter reaches a certain threshold
 *  (default 15), the object is promoted to the Old Generation.
 * - Premature promotion can occur if the Survivor spaces are too small to hold all the surviving objects, leading to
 *  objects being promoted to the Old Generation before they have reached the age threshold.
 */
class OldGeneration {

}

