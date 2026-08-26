package com.toolkit.java.vault.core_concepts.generics;

import java.util.List;

/**
 * Wildcards in Java generics are used to represent an unknown type. They provide flexibility when working
 * with generic types, allowing you to specify a range of acceptable types without knowing the exact type
 * at compile time.
 *
 * <p>
 * There are three main types of wildcards:
 * 1. Unbounded Wildcard (<?>): Represents any type. It is used when you want to accept any type of object.
 * 2. Bounded Wildcard (<? extends T>): Represents a type that is a subclass of T (including T itself).
 * It is used for covariance.
 * 3. Bounded Wildcard (<? super T>): Represents a type that is a superclass of T (including T itself).
 * It is used for contravariance.
 *
 * <p>
 * Key Points:
 * - Wildcards are useful in method parameters and return types to increase flexibility.
 * - They help in writing more general and reusable code.
 */
public class Wildcards {
}

class UnboundedWildcardExample {
    public static void printList(List<?> list) {
        for (Object element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

class BoundedWildcardExample {
    public static void printNumbers(List<? extends Number> list) {
        for (Number number : list) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}

class ContravariantWildcardExample {
    public static void addNumbers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }
}
