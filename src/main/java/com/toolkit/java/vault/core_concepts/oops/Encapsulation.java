package com.toolkit.java.vault.core_concepts.oops;

/**
 * Encapsulation is one of the fundamental principles of Object-Oriented Programming (OOP).
 * It refers to the bundling of data (attributes) and methods (functions) that operate on
 * that data into a single unit, known as a class.
 *
 * <p>
 * Encapsulation helps to protect the internal state of an object from unintended interference
 * and misuse by restricting access to its internal representation.
 *
 * <p>
 * Encapsulation is just like a capsule holding powdered medicine. The medicine is encapsulated
 * in a capsule, and the capsule protects the medicine from external factors. Similarly,
 * encapsulation in OOP protects the internal state of an object from external factors.
 *
 * <p>
 * Key Points:
 * 1. Access Modifiers: Encapsulation is achieved using access modifiers
 * (private, protected, public) to control the visibility of class members.
 * 2. Getters and Setters: Public methods (getters and setters) are often
 * provided to allow controlled access to private attributes.
 * 3. Data Hiding: By keeping attributes private, encapsulation ensures
 * that the internal representation of an object is hidden from the outside world.
 * 4. Improved Maintainability: Encapsulation allows for changes in the
 * internal implementation without affecting external code that uses the class.
 */
public class Encapsulation {
    public static void main(String[] args) {
        // Create a new Person object
        Person person = new Person("Alice", 30);

        // Accessing private attributes using getters
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());

        // Modifying private attributes using setters
        person.setName("Bob");
        person.setAge(35);

        // Accessing modified attributes
        System.out.println("Updated Name: " + person.getName());
        System.out.println("Updated Age: " + person.getAge());
    }
}

class Person {
    // Private attributes
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        if (age >= 0) { // Validation to ensure age is not negative
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}
