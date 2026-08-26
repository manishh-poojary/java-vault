package com.toolkit.java.vault.core_concepts.features;

/**
 * Static and Final Keywords
 *
 * <p>
 * In Java, the static keyword is used to indicate that a member (variable or method)
 * belongs to the class rather than an instance of the class. This means that static
 * members can be accessed without creating an instance of the class.
 *
 * <p>
 * The final keyword is used to indicate that a variable's value cannot be changed
 * once it has been assigned. A final variable can only be assigned once, and its value
 * cannot be modified afterward.
 */
public class StaticAndFinalKeywords {
}

class StaticExample {
    // Static variable
    static int staticCounter = 0;

    // Static method
    static void incrementCounter() {
        staticCounter++;
    }

    public static void main(String[] args) {
        System.out.println("Initial staticCounter: " + staticCounter); // 0
        incrementCounter();
        System.out.println("After incrementing: " + staticCounter); // 1
        incrementCounter();
        System.out.println("After incrementing again: " + staticCounter); // 2
    }
}

class FinalExample {
    // Final variable
    final int finalValue;

    // Constructor to initialize the final variable
    FinalExample(int value) {
        this.finalValue = value;
    }

    public static void main(String[] args) {
        FinalExample example = new FinalExample(10);
        System.out.println("Final value: " + example.finalValue); // 10

        // Uncommenting the following line will cause a compilation error
        // example.finalValue = 20; // Error: cannot assign a value to final variable finalValue
    }
}