package com.toolkit.java.vault.core_concepts.collections.lists;

/**
 * ArrayList
 *
 * <p>
 * An ArrayList is a resizable array implementation in Java that allows dynamic addition and removal of elements.
 * It is part of the Java Collections Framework and provides a more flexible alternative to traditional arrays.
 *
 * <p>
 * Key points about ArrayList in Java:
 * 1. Resizable: The size of an ArrayList can be changed dynamically.
 * 2. Homogeneous: All elements in an ArrayList must be of the same data type.
 * 3. Indexed: Elements in an ArrayList can be accessed using their index, with the first element at index 0.
 * 4. Memory Allocation: ArrayLists are stored in contiguous memory locations, which allows for efficient access to
 * elements.
 * 5. Multidimensional ArrayLists: Java supports multidimensional ArrayLists, which are ArrayLists of ArrayLists.
 * 6. ArrayList is not synchronized, meaning it is not thread-safe. If multiple threads access an
 *    ArrayList concurrently, and at least one of the threads modifies the list structurally, it
 *    must be synchronized externally.
 *
 * <p>
 * Type of ArrayLists:
 * 1. Single-Dimensional ArrayLists: A linear ArrayList that holds a single list of elements.
 * 2. Multidimensional ArrayLists: ArrayLists that hold ArrayLists as their elements, such as 2D ArrayLists (matrix)
 * or 3D ArrayLists.
 *
 */
public class Arrays {
}

class SingleDimensionalArrayExample {
    public static void main(String[] args) {
        // Declare and initialize a single-dimensional array
        int[] numbers = {1, 2, 3, 4, 5};

        // Access and print elements of the array
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element at index " + i + ": " + numbers[i]);
        }
    }
}

class MultiDimensionalArrayExample {
    public static void main(String[] args) {
        // Declare and initialize a 2D array (matrix)
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Access and print elements of the 2D array
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
