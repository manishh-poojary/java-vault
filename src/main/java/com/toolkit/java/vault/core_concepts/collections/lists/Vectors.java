package com.toolkit.java.vault.core_concepts.collections.lists;

import java.util.Vector;

/**
 * Vector
 *
 * <p>
 * A vector is a dynamic array that can grow or shrink in size as needed.
 * It is part of the Java Collections Framework and provides a way to store and
 * manipulate a collection of objects.
 *
 * <p>
 * Key points about vectors in Java:
 * 1. Dynamic Size: Vectors can change their size dynamically, allowing for efficient memory usage.
 * 2. Synchronized: Vectors are synchronized, meaning they are thread-safe and can be used in
 * multithreaded environments.
 * 3. Indexed: Elements in a vector can be accessed using their index, with the first element at index 0.
 * 4. Memory Allocation: Vectors are stored in contiguous memory locations, which allows for
 * efficient access to elements.
 *
 * <p>
 * Type of Vectors:
 * 1. Single-Dimensional Vectors: A linear vector that holds a single list of elements.
 * 2. Multidimensional Vectors: Vectors that hold vectors as their elements, such as 2D vectors (matrix) or 3D vectors.
 *
 */
public class Vectors {
}

class SingleDimensionalVectorExample {
    public static void main(String[] args) {
        // Create a single-dimensional vector
        Vector<Integer> vector = new Vector<>();

        // Add elements to the vector
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);

        // Access and print elements of the vector
        for (int i = 0; i < vector.size(); i++) {
            System.out.println("Element at index " + i + ": " + vector.get(i));
        }
    }
}

class MultiDimensionalVectorExample {
    public static void main(String[] args) {
        // Create a 2D vector (vector of vectors)
        Vector<Vector<Integer>> matrix = new Vector<>();

        // Add rows to the 2D vector
        for (int i = 0; i < 3; i++) {
            Vector<Integer> row = new Vector<>();
            for (int j = 0; j < 3; j++) {
                row.add(i * 3 + j + 1); // Fill with values 1 to 9
            }
            matrix.add(row);
        }

        // Access and print elements of the 2D vector
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}