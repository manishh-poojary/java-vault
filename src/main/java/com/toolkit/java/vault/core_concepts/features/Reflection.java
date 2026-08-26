package com.toolkit.java.vault.core_concepts.features;

/**
 * Reflection in Java
 * <p>
 * Reflection is a feature in the Java programming language that allows a program to examine and modify the runtime
 * behavior of applications running in the Java Virtual Machine (JVM). It provides the ability to inspect classes,
 * interfaces, fields, and methods at runtime, without knowing their names at compile time.
 *
 * <p>
 * Reflection is part of the java.lang.reflect package and is commonly used for:
 * - Inspecting class properties (fields, methods, constructors)
 * - Creating new instances of classes dynamically
 * - Invoking methods dynamically
 * - Accessing private fields and methods
 *
 * <p>
 * However, reflection should be used with caution as it can lead to performance overhead and security risks.
 *
 * <p>
 * How Reflection Works:
 * 1. Class Inspection: You can obtain a Class object for any class using Class.forName("className") or by calling
 * getClass() on an object. This Class object provides methods to inspect the class's fields, methods, and constructors.
 * 2. Field Access: You can access fields of a class using the Field class. You can get a Field object for a specific
 * field using Class.getDeclaredField("fieldName") and then use Field.get() and Field.set() to read and modify the
 * field's value.
 * 3. Method Invocation: You can invoke methods dynamically using the Method class. You can get a Method object for
 * a specific method using Class.getDeclaredMethod("methodName", parameterTypes) and then use Method.invoke() to
 * call the method on an object.
 * 4. Constructor Invocation: You can create new instances of a class using the Constructor class. You can get a
 * Constructor object for a specific constructor using Class.getDeclaredConstructor(parameterTypes) and then use
 * Constructor.newInstance() to create a new instance of the class.
 */
public class Reflection {

    public static void main(String[] args) {
        try {
            // Obtain the Class object for the Person class
            Class<?> personClass = Class.forName("com.toolkit.java.vault.core_concepts.features.Person");

            // Create a new instance of the Person class using the default constructor
            Object personInstance = personClass.getDeclaredConstructor().newInstance();

            // Access and modify the private field 'name'
            java.lang.reflect.Field nameField = personClass.getDeclaredField("name");
            nameField.setAccessible(true); // Make the private field accessible
            nameField.set(personInstance, "Alice");

            // Access and modify the private field 'age'
            java.lang.reflect.Field ageField = personClass.getDeclaredField("age");
            ageField.setAccessible(true); // Make the private field accessible
            ageField.set(personInstance, 25);

            // Invoke the toString method to print the person's details
            java.lang.reflect.Method toStringMethod = personClass.getDeclaredMethod("toString");
            String result = (String) toStringMethod.invoke(personInstance);
            System.out.println(result); // Output: Person{name='Alice', age=25}

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

