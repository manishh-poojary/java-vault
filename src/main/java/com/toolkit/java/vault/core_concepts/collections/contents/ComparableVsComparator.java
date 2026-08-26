package com.toolkit.java.vault.core_concepts.collections.contents;

import java.util.Comparator;

/**
 * Comparable vs Comparator
 *
 * <p>
 * Comparable:
 * The Comparable interface is used to define the natural ordering of objects of a class.
 * A class that implements the Comparable interface must override the compareTo() method,
 * which compares the current object with another object of the same type.
 * The compareTo() method returns a negative integer, zero, or a positive integer if the current
 * object is less than, equal to, or greater than the specified object, respectively.
 *
 * <p>
 * Comparator:
 * The Comparator interface is used to define custom ordering of objects of a class.
 * A class that implements the Comparator interface must override the compare() method,
 * which compares two objects of the same type.
 * The compare() method returns a negative integer, zero, or a positive integer if the
 * first object is less than, equal to, or greater than the second object, respectively.
 */
public class ComparableVsComparator {
}

class ComparableExample implements Comparable<ComparableExample> {
    private int value;

    public ComparableExample(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(ComparableExample other) {
        return Integer.compare(this.value, other.value);
    }
}

class ComparatorExample implements Comparator<ComparatorExample> {
    private int value;

    public ComparatorExample(int value) {
        this.value = value;
    }

    @Override
    public int compare(ComparatorExample o1, ComparatorExample o2) {
        return Integer.compare(o1.value, o2.value);
    }
}
