package com.toolkit.java.vault.core_concepts.oops;

/**
 * A constructor in Java is a special method that is used to initialize objects.
 * It is called when an instance of a class is created. Constructors have the same name
 * as the class and do not have a return type, not even void. They can be overloaded to
 * provide different ways of initializing an object.
 *
 * <p>
 * Key points about constructors:
 * 1. A constructor is invoked when an object of a class is created.
 * 2. It can be used to set initial values for object attributes.
 * 3. If no constructor is defined, Java provides a default constructor.
 * 4. Constructors can be overloaded to allow different ways of initializing an object.
 * <p>
 * Types of constructors:
 * 1. Default Constructor: A constructor with no parameters.
 * 2. Parameterized Constructor: A constructor that takes parameters to initialize an object with specific values.
 * 3. Copy Constructor: A constructor that creates a new object as a
 * copy of an existing object (not natively supported in Java, but can be implemented).
 */
public class Constructor {

    public static void main(String[] args) {
        // Using Default Constructor
        DefaultConstructor defaultObj = new DefaultConstructor();
        System.out.println("Default Constructor Name: " + defaultObj.getName());

        // Using Parameterized Constructor
        ParameterizedConstructor paramObj = new ParameterizedConstructor("John Doe", 30);
        System.out.println("Parameterized Constructor Name: " + paramObj.getName() + ", Age: " + paramObj.getAge());

        // Using Copy Constructor
        CopyConstructor originalObj = new CopyConstructor("Jane Doe", 25);
        CopyConstructor copyObj = new CopyConstructor(originalObj);
        System.out.println("Copy Constructor Name: " + copyObj.getName() + ", Age: " + copyObj.getAge());
    }
}

/**
 * DefaultConstructor class demonstrates a constructor with no parameters.
 */
class DefaultConstructor {
    private final String name;

    // Default constructor
    public DefaultConstructor() {
        this.name = "Default Name";
    }

    public String getName() {
        return name;
    }
}

/**
 * ParameterizedConstructor class demonstrates a constructor that takes parameters to
 * initialize an object with specific values.
 */
class ParameterizedConstructor {
    private final String name;
    private final int age;

    // Parameterized constructor
    public ParameterizedConstructor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

/**
 * CopyConstructor class demonstrates a constructor that creates a new object as a
 * copy of an existing object. This is not natively supported in Java, but can be implemented.
 */
class CopyConstructor {
    private final String name;
    private final int age;

    // Parameterized constructor
    public CopyConstructor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public CopyConstructor(CopyConstructor other) {
        this.name = other.name;
        this.age = other.age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
