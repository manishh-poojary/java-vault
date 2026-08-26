package com.toolkit.java.vault.core_concepts.oops;

/**
 * Polymorphism is a core concept in object-oriented programming (OOP) that allows objects
 * of different classes to be treated as objects of a common superclass. It enables a
 * single interface to represent different underlying forms (data types). In Java,
 * polymorphism is mainly achieved through method overriding and method overloading.
 *
 * <p>
 * There are two types of polymorphism in Java:
 * 1. Compile-time polymorphism (Method Overloading)
 * 2. Runtime polymorphism (Method Overriding)
 */

public class Polymorphism {
}

/**
 * Method Overloading: Same method name with different parameters
 */
class CompileTimePolymorphism {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

/**
 * Method Overriding: Subclass provides a specific implementation of a method already
 * defined in its superclass
 */
class RuntimePolymorphism {

    static class Animal {
        void sound() {
            System.out.println("Animal makes a sound");
        }
    }

    static class Dog extends Animal {
        @Override
        void sound() {
            System.out.println("Dog barks");
        }
    }

    static class Cat extends Animal {
        @Override
        void sound() {
            System.out.println("Cat meows");
        }
    }

    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myDog.sound(); // Outputs: Dog barks
        myCat.sound(); // Outputs: Cat meows
    }
}
