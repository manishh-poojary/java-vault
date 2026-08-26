package com.toolkit.java.vault.core_concepts.oops;

/**
 * Interface is a fundamental concept in object-oriented programming (OOP) that defines a contract
 * for classes to implement. It specifies a set of abstract methods (methods without implementation)
 * that a class must provide implementations for. Interfaces allow for multiple inheritance in Java,
 * enabling classes to implement multiple interfaces and thus inherit behavior from multiple sources.
 *
 * <p>
 * In Java, an interface can contain abstract methods, default methods (with implementation), static methods,
 * and constants (public static final fields). Classes that implement an interface must provide concrete
 * implementations for all its abstract methods, unless the class is declared as abstract.
 *
 * <p>
 * Benefits of Interfaces:
 * 1. Promotes code reusability by allowing different classes to implement the same interface.
 * 2. Enhances flexibility and scalability by enabling polymorphism, where objects of different classes
 * can be treated as instances of the same interface type.
 * 3. Encourages loose coupling between components, making it easier to change or replace implementations
 * without affecting the rest of the system.
 *
 */
public class Interface {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.start();
        car.stop();

        Vehicle bike = new Bike();
        bike.start();
        bike.stop();
    }
}

interface Vehicle {
    void start();

    void stop();
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting.");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping.");
    }
}

class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike is starting.");
    }

    @Override
    public void stop() {
        System.out.println("Bike is stopping.");
    }
}