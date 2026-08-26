package com.toolkit.java.vault.core_concepts.collections.contents;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Fail-Fast vs Fail-Safe
 *
 * <p>
 * Fail-Fast:
 * A fail-fast iterator immediately throws a ConcurrentModificationException if it detects that the collection has been
 * modified while iterating over it. This behavior is designed to prevent unpredictable behavior and ensure that the collection
 * remains in a consistent state.
 * Examples of fail-fast collections in Java include ArrayList, HashMap, and HashSet.
 *
 * <p>
 * Fail-Safe:
 * A fail-safe iterator does not throw an exception if the collection is modified while iterating over it. Instead,
 * it works on a clone or a snapshot of the collection, allowing for safe iteration even when the underlying collection
 * is being modified. However, this may lead to inconsistencies between the iterator and the actual collection.
 * Examples of fail-safe collections in Java include CopyOnWriteArrayList and ConcurrentHashMap.
 *
 *
 */
public class FailFastVsFailSafe {
}

class FailFastExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for (Integer value : list) {
            System.out.println("Value: " + value);
            // Modifying the collection while iterating will cause a ConcurrentModificationException
            if (value == 2) {
                list.remove(value);
            }
        }
    }
}

class FailSafeExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // Using a fail-safe iterator (CopyOnWriteArrayList) to avoid ConcurrentModificationException
        List<Integer> failSafeList = new CopyOnWriteArrayList<>(list);
        for (Integer value : failSafeList) {
            System.out.println("Value: " + value);
            // Modifying the collection while iterating will not cause an exception
            if (value == 2) {
                failSafeList.remove(value);
            }
        }

        System.out.println("Final List: " + failSafeList); // Output: Final List: [1, 3]
    }
}