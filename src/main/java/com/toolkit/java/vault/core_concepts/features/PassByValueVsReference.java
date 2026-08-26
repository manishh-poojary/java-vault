package com.toolkit.java.vault.core_concepts.features;

/**
 * Pass By Value vs Pass By Reference
 *
 * <p>
 * In Java, all primitive data types (int, float, double, char, etc.) are passed by value.
 * This means that when you pass a primitive type to a method, a copy of the value is made and passed to the method.
 * Changes made to the parameter inside the method do not affect the original value.
 *
 * <p>
 * In contrast, all objects in Java are passed by reference.
 * This means that when you pass an object to a method, a reference to the object is passed.
 * Changes made to the object inside the method will affect the original object.
 */
public class PassByValueVsReference {
}

class PassByValueExample {
    public static void main(String[] args) {
        int originalValue = 10;
        System.out.println("Original Value before method call: " + originalValue);
        modifyPrimitive(originalValue);
        System.out.println("Original Value after method call: " + originalValue);
    }

    public static void modifyPrimitive(int value) {
        value = 20; // This change will not affect the original value
    }
}

class PassByReferenceExample {
    public static void main(String[] args) {
        Person originalPerson = new Person("John", 30);
        System.out.println("Original Person before method call: " + originalPerson);
        modifyObject(originalPerson);
        System.out.println("Original Person after method call: " + originalPerson);
    }

    public static void modifyObject(Person person) {
        person.setAge(31); // This change will affect the original object
    }
}
