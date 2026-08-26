package com.toolkit.java.vault.core_concepts.collections.contents;

/* Internal Working of HashMap

Internal Working of HashMap in Java:
1. HashMap is a part of the Java Collections Framework and is used to store key-value pairs.
 It is implemented as a hash table, which allows for fast retrieval of values based on their keys.
2. HashMap uses a hash function to compute an index (hash code) for each key and stores the
key-value pair at that index in an array.
3. If two keys have the same hash code (collision), HashMap uses a linked list or a balanced tree
(in Java 8 and later) to store multiple key-value pairs at the same index.
4. HashMap allows null values and one null key, but it is not synchronized, meaning it is not thread-safe.
5. The default initial capacity of a HashMap is 16, and the load factor is 0.75, which means that
when the number of entries exceeds 75% of the capacity, the HashMap will resize itself to maintain efficient performance.
6. HashMap provides constant-time performance for basic operations like get and put,
 assuming the hash function disperses the elements properly among the buckets.
7. HashMap is not ordered, meaning that the order of the key-value pairs is not guaranteed to be the same
 as the order in which they were added.

 Components of HashMap:
 1. Buckets: An array of linked lists or trees where the key-value pairs are stored.
 2. Hash Function: A function that computes the hash code for a given key and determines the index in the buckets array.
 3. Entry: A key-value pair stored in the HashMap, represented by the Entry class.
 4. Load Factor: A measure of how full the HashMap can get before it needs to be resized. The default load factor is 0.75.
 5. Capacity: The number of buckets in the HashMap. The default capacity is 16, and it is always a power of two.
 6. Resizing: When the number of entries exceeds the product of the load factor and capacity, the HashMap resizes
 itself by creating a new array of buckets with double the capacity and rehashing all existing entries into the new array.
 7. Rehashing: The process of recalculating the hash codes for all existing entries
 and placing them into the new array of buckets during resizing.
 8. Hashing: The process of converting a key into a hash code using the hash function, which is then used to determine
  the index in the buckets array.
 9. Collision Resolution: The method used to handle cases where two keys have the same hash code and are placed in the
 same bucket. HashMap uses separate chaining (linked lists or trees) for collision resolution.

 What does equals() and hashCode() methods do in HashMap?
1. The equals() method is used to compare two keys for equality. When a key is added to the HashMap,
 the equals() method is called to check if the key already exists in the map. If the key exists, the value is updated;
 otherwise, a new entry is created.
2. The hashCode() method is used to compute the hash code for a given key. The hash code is used by the HashMap to
determine the index in the buckets array where the key-value pair should be stored. It is important that objects that
are equal according to the equals() method have the same hash code.

Treeification in HashMap:
1. Treeification is the process of converting a linked list of entries in a bucket into a balanced tree
(specifically, a red-black tree) when the number of entries in that bucket exceeds a certain threshold
(TREEIFY_THRESHOLD, which is 8 in Java 8 and later).
2. The purpose of treeification is to improve the performance of the HashMap when there are many collisions in a
 single bucket. When the number of entries in a bucket exceeds the threshold,
 */
public class InternalWorkingOfHashMap {
}
