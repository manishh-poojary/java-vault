package com.toolkit.java.vault.core_concepts.features;

/**
 * Wrapper classes provide a way to use primitive data types (int, boolean, etc.) as objects.
 *
 * <p>
 * Each primitive type has a corresponding wrapper class:
 * - int -> Integer
 * - boolean -> Boolean
 * - char -> Character
 * - double -> Double
 * - float -> Float
 * - long -> Long
 * - short -> Short
 * - byte -> Byte
 *
 * <p>
 * Wrapper classes are useful when working with collections that require objects,
 * such as ArrayList.
 *
 * <p>
 * Type conversion between primitives and wrapper classes is known as autoboxing
 * (primitive to wrapper) and unboxing (wrapper to primitive).
 *
 * <p>
 * Casting Types:
 * - Widening Casting (automatically) (Upcasting) (Implicit) - converting a smaller type to a larger type size
 * - Narrowing Casting (manually) (Down casting) (Explicit) - converting a larger type to a smaller size
 */
public class Wrapper {

}

class AutoBoxingExample {
    public static void main(String[] args) {
        // Autoboxing: Converting primitive to wrapper
        int primitiveInt = 10;
        Integer wrapperInt = primitiveInt; // Autoboxing
        System.out.println("Wrapper Integer: " + wrapperInt); // Output: Wrapper Integer: 10
    }
}

class UnBoxingExample {
    public static void main(String[] args) {
        // Unboxing: Converting wrapper to primitive
//        Integer wrapperInt = new Integer(20);
//        int primitiveInt = wrapperInt; // Unboxing
//        System.out.println("Primitive int: " + primitiveInt); // Output: Primitive int: 20
    }
}
