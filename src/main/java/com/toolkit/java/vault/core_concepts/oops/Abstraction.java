package com.toolkit.java.vault.core_concepts.oops;

/**
 * Abstraction is a fundamental concept in object-oriented programming (OOP) that focuses
 * on hiding the complex implementation details of a system and exposing only the essential
 * features to the user. It allows developers to create abstract classes and interfaces
 * that define a blueprint for other classes to follow, without revealing the underlying implementation.
 *
 * <p>
 * It processes on the "what" rather than the "how". In other words, abstraction allows you to
 * define what an object does, and doesn't concern itself with how it does it.
 * This helps in reducing complexity and increasing efficiency in the code.
 *
 * <p>
 * In Java, abstraction can be achieved using abstract classes and interfaces.
 * An abstract class can have both abstract methods (without implementation)
 * and concrete methods (with implementation), while an interface can only have
 * abstract methods (prior to Java 8) and default/static methods (from Java 8 onwards).
 *
 * <p>
 * Benefits of Abstraction:
 * 1. Simplifies complex systems by breaking them into manageable parts.
 * 2. Enhances code reusability by allowing different classes to implement
 * the same interface or extend the same abstract class.
 * 3. Improves maintainability by allowing changes in the implementation
 * without affecting the users of the abstraction.
 * <p>
 */
public class Abstraction {
    public static void main(String[] args) {
        Shape triangle = new Triangle(5, 10);
        triangle.display("Triangle");
        System.out.println("Area: " + triangle.area());

        Shape circle = new Circle(7);
        circle.display("Circle");
        System.out.println("Area: " + circle.area());

        Shape square = new Square(4);
        square.display("Square");
        System.out.println("Area: " + square.area());
    }

}

abstract class Shape {
    // Abstract method (does not have a body)
    public abstract double area();

    // Concrete method
    public void display(String shapeName) {
        System.out.println("This is a " + shapeName + ".");
    }
}

class Triangle extends Shape {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Square extends Shape {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}

