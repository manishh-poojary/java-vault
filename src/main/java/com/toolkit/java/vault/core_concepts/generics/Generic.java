package com.toolkit.java.vault.core_concepts.generics;

/**
 * Generics in Java allow you to create classes, interfaces, and methods with a placeholder for types.
 * This enables type safety and code reusability.
 *
 * <p>
 * Generics are defined using angle brackets (e.g., <T>) and can be used to specify the type of objects
 * that a class or method can work with. It enforces type checking at compile time, reducing the risk of
 * ClassCastException at runtime.
 *
 * <p>
 * Key Points:
 * - Generics provide compile-time type checking and eliminate the need for casting.
 * - You can define generic classes, interfaces, and methods using type parameters (e.g., T, E, K, V).
 * - Commonly used in collections (e.g., List<T>, Map<K, V>).
 *
 * <p>
 * Limitations of Generics:
 * - Cannot use primitive types as type parameters (use wrapper classes instead).
 * - Cannot create instances of generic types (e.g., new T()).
 * - Cannot use instanceof with generic types.
 *
 *
 * <p>
 * Following parameters are commonly used in generics:
 * - T: Type
 * - E: Element (used in collections)
 * - K: Key (used in maps)
 * - V: Value (used in maps)
 */
public class Generic {
}

class GenericClass<T> {
    private T value;

    public GenericClass(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class GenericMethod {
    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
