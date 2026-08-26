package com.toolkit.java.vault.core_concepts.strings;

/**
 * StringBuilder vs StringBuffer
 *
 * <p>
 * In Java, both StringBuilder and StringBuffer are classes used to create mutable sequences of characters.
 * The main difference between them is that StringBuffer is synchronized, which means
 * it is thread-safe and can be used in a multithreaded environment, while StringBuilder is not
 * synchronized and is faster in single-threaded scenarios.
 *
 * <p>
 * Use StringBuilder when you need to perform a lot of modifications to a string in a single-threaded
 * context, and use StringBuffer when you need to ensure thread safety in a multithreaded context.
 *
 *
 */
public class StringBuilderVsStringBuffer {
}

class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("Hello");
        stringBuilder.append(" World");
        System.out.println("StringBuilder: " + stringBuilder); // StringBuilder: Hello World
    }
}

class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("Hello");
        stringBuffer.append(" World");
        System.out.println("StringBuffer: " + stringBuffer); // StringBuffer: Hello World
    }
}