package com.toolkit.java.vault.core_concepts.oops;

/**
 * Inheritance is one of the fundamental principles of Object-Oriented Programming (OOP).
 * It allows a class (subclass or derived class) to inherit properties and behaviors (methods)
 * from another class (superclass or base class). This promotes code reusability and establishes
 * a hierarchical relationship between classes.
 *
 * <p>
 * It forms as chain of hierarchy where a class can inherit from another class, which in turn can
 * inherit from another class, and so on and where classes are categorized into parent and child classes.
 *
 * <p>
 * Key Points:
 * 1. Base Class: The class whose properties and methods are inherited is called the base class or superclass.
 * 2. Derived Class: The class that inherits from the base class is called the derived class or subclass.
 * 3. Access Modifiers: Inherited members can have different access levels (public, protected, private),
 * which determine their visibility in the derived class.
 * 4. Method Overriding: A derived class can provide its own implementation of a method defined in the base class,
 * allowing for polymorphic behavior.
 */
public class Inheritance {
    public static void main(String[] args) {
        // Create instances of Dog and Cat
        Dog dog = new Dog();
        Cat cat = new Cat();

        // Call the eat method on both instances
        dog.eat(); // Output: Dog is eating.
        cat.eat(); // Output: Cat is eating.
    }
}

class Animal {
    // Base class (superclass)
    public void eat() {
        System.out.println("Animal is eating.");
    }
}

class Dog extends Animal {
    // Derived class (subclass)
    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }
}

class Cat extends Animal {
    // Derived class (subclass)
    @Override
    public void eat() {
        System.out.println("Cat is eating.");
    }
}
