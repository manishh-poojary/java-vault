package com.toolkit.java.vault.core_concepts.exceptions;

/**
 * The Exception class in Java is the superclass of all exceptions that can be thrown during the normal
 * operation of the Java Virtual Machine (JVM). It is part of the java.lang package and serves as the base
 * class for both checked and unchecked exceptions.
 *
 * <p>
 * Key Points:
 * - Checked Exceptions: These are exceptions that must be either caught or declared in the method signature
 * using the 'throws' keyword. Examples include IOException, SQLException, etc.
 * - Unchecked Exceptions: These are exceptions that do not need to be declared or caught. They are subclasses
 * of RuntimeException. Examples include NullPointerException, ArrayIndexOutOfBoundsException, etc.
 * - Exception Hierarchy: The Exception class is a subclass of Throwable, which is the superclass of all
 * errors and exceptions in Java.
 *
 * <p>
 * - Handling Exceptions: You can handle exceptions using try-catch blocks or propagate them using the
 * 'throws' keyword.
 *
 */
 public class Exceptions extends Throwable {
    public Exceptions(String message) {
        super(message);
    }
}

class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            throw new java.io.IOException("This is a checked exception");
        } catch (java.io.IOException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }
    }
}

class UncheckedExceptionExample {
    public static void main(String[] args) {
        try {
            throw new NullPointerException("This is an unchecked exception");
        } catch (NullPointerException e) {
            System.out.println("Caught unchecked exception: " + e.getMessage());
        }
    }
}

class finallyBlockExample {
    public static void main(String[] args) {
        try {
            System.out.println("Inside try block");
            // Simulating an exception
            throw new RuntimeException("Simulated exception");
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            System.out.println("Inside finally block - This will always execute");
        }
    }
}

class multipleCatchExample {
    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            arr[10] = 50; // This will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
