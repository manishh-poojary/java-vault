# ⏱️ Time Complexity — Java Collections Framework

A quick-reference guide to the time complexity of common operations across Java's Collection implementations. Useful for choosing the right data structure and for interview prep.

---

## 📋 List Implementations

| Operation                   | `ArrayList` | `LinkedList` |
|----------------------------:|:-----------:|:------------:|
| Access (get/set by index)   | O(1)        | O(n)         |
| Search (contains/indexOf)   | O(n)        | O(n)         |
| Insert at end (append)      | O(1)*       | O(1)         |
| Insert at beginning         | O(n)        | O(1)         |
| Insert at middle            | O(n)        | O(n)         |
| Delete at end               | O(1)        | O(1)         |
| Delete at beginning         | O(n)        | O(1)         |
| Delete at middle            | O(n)        | O(n)         |

*O(1) amortized — occasionally O(n) when the internal array needs to resize.

Takeaway: Use `ArrayList` for frequent random access/reads. Use `LinkedList` for frequent inserts/deletes at the ends (e.g., implementing a queue or deque).

---

## 🟢 Set Implementations

| Operation         | `HashSet`  | `LinkedHashSet` | `TreeSet`   |
|------------------:|:----------:|:---------------:|:-----------:|
| Add               | O(1) avg   | O(1) avg        | O(log n)   |
| Remove            | O(1) avg   | O(1) avg        | O(log n)   |
| Contains          | O(1) avg   | O(1) avg        | O(log n)   |
| Iteration order   | None       | Insertion order | Sorted     |

Takeaway: `HashSet` is fastest when order doesn't matter. `LinkedHashSet` provides predictable iteration order. `TreeSet` is for sorted elements or range queries (`headSet`, `tailSet`).

---

## 🗺️ Map Implementations

| Operation        | `HashMap`     | `LinkedHashMap` | `TreeMap`   | `Hashtable`           | `ConcurrentHashMap`   |
|-----------------:|:-------------:|:---------------:|:-----------:|:---------------------:|:---------------------:|
| Get              | O(1) avg      | O(1) avg        | O(log n)   | O(1) avg              | O(1) avg              |
| Put              | O(1) avg      | O(1) avg        | O(log n)   | O(1) avg              | O(1) avg              |
| Remove           | O(1) avg      | O(1) avg        | O(log n)   | O(1) avg              | O(1) avg              |
| Thread-safe?     | No            | No              | No         | Yes (synchronized)    | Yes (concurrent)      |
| Null keys/values | 1 null key, multiple null values | Same as `HashMap` | No null keys | No nulls allowed | No nulls allowed |

Takeaway: Default to `HashMap` for general use. Use `TreeMap` when you need sorted keys. Use `ConcurrentHashMap` (not `Hashtable`) for modern thread-safe access.

---

## 📥 Queue / Deque Implementations

| Operation             | `ArrayDeque`     | `LinkedList` | `PriorityQueue` |
|----------------------:|:----------------:|:------------:|:----------------:|
| Insert (offer/add)    | O(1) amortized   | O(1)        | O(log n)        |
| Remove (poll/remove)  | O(1)             | O(1)        | O(log n)        |
| Peek                  | O(1)             | O(1)        | O(1)            |
| Search                | O(n)             | O(n)        | O(n)            |

Takeaway: `ArrayDeque` is generally faster than `LinkedList` for stack/queue use cases (better cache locality, no per-node overhead). `PriorityQueue` is ideal for priority-based processing.

---

## ⚠️ Important Notes on "Average vs Worst Case"

- `HashMap` / `HashSet`: O(1) average assumes a good hash function with minimal collisions. In the worst case (many collisions) operations can degrade to O(n), but since Java 8 buckets convert to a balanced tree after a threshold, capping worst case at O(log n).
- `TreeMap` / `TreeSet`: Always O(log n) — backed by a Red-Black Tree.
- `ArrayList` resizing: Appending is amortized O(1) because the internal array occasionally grows and copies — most inserts are O(1), but a resize is O(n).

---

## 🧠 Quick Decision Guide

| Need                                   | Best Choice                 |
|----------------------------------------|-----------------------------|
| Fast random access by index            | `ArrayList`                 |
| Frequent insert/delete at ends         | `LinkedList` / `ArrayDeque` |
| No duplicates, no order needed         | `HashSet`                   |
| No duplicates, insertion order matters | `LinkedHashSet`             |
| No duplicates, sorted order needed     | `TreeSet`                   |
| Key-value pairs, fastest lookup        | `HashMap`                   |
| Key-value pairs, sorted by key         | `TreeMap`                   |
| Key-value pairs, thread-safe           | `ConcurrentHashMap`         |
| Priority-based processing              | `PriorityQueue`             |
| Stack or Queue behavior                | `ArrayDeque`                |

---
