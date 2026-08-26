package com.toolkit.java.vault.core_concepts.strings;

/**
 * Strings
 *
 * <p>
 * In Java, a String is an object that represents a sequence of characters. Strings are immutable,
 * meaning that once a String object is created, its value cannot be changed.
 * Any operation that seems to modify a String actually creates a new String object.
 *
 * <p>
 * Strings can be created using string literals or by using the String class constructor.
 * The String class provides various methods for manipulating and working with strings,
 * such as concatenation, substring extraction, and searching for characters or substrings.
 *
 * <p>
 * Immutability of Strings:
 * - Once a String object is created, its value cannot be changed.
 * - Any operation that modifies a String will create a new String object.
 *
 * <p>
 * Why Strings are Immutable?
 * - Immutability provides security, as Strings are often used to represent sensitive data like passwords.
 * - It allows for safe sharing of String objects across multiple threads without synchronization.
 *
 * <p>
 * Equals vs ==:
 * - The equals() method compares the content of two String objects for equality.
 * - The == operator compares the references of two String objects to check if they point to the same memory location.
 *
 * <p>
 * String Pool:
 * - Java maintains a pool of unique String literals to optimize memory usage.
 * - When a String literal is created, Java checks the pool to see if an identical String already exists.
 * - If it does, the existing String is reused; otherwise, a new String object is created and added to the pool.
 *
 * <p>
 * String Concatenation:
 * - Strings can be concatenated using the + operator or the concat() method.
 * - Concatenation creates a new String object, as Strings are immutable.
 *
 * <p>
 * String Comparison:
 * - Strings can be compared using the equals() method for content equality and the == operator for reference equality.
 * - The equalsIgnoreCase() method can be used to compare strings while ignoring case differences.
 *
 * <p>
 * String Formatting:
 * - The String.format() method allows for formatted string creation using format specifiers.
 * - It provides a way to create strings with dynamic content, similar to printf-style formatting.
 *
 * <p>
 * String Methods:
 * - length(): Returns the length of the String.
 * - charAt(int index): Returns the character at the specified index.
 * - substring(int beginIndex, int endIndex): Returns a new String that is a substring of the original String.
 * - indexOf(String str): Returns the index of the first occurrence of the specified substring, or -1 if not found.
 * - equals(Object obj): Compares the String to the specified object for equality.
 * - equalsIgnoreCase(String str): Compares the String to the specified String, ignoring case considerations.
 * - toUpperCase(): Converts all characters in the String to uppercase.
 * - toLowerCase(): Converts all characters in the String to lowercase.
 * - trim(): Removes leading and trailing whitespace from the String.
 * - replace(char oldChar, char newChar): Returns a new String resulting from replacing all occurrences of oldChar with newChar.
 * - split(String regex): Splits the String into an array of substrings based on the specified regular expression.
 * - contains(CharSequence sequence): Returns true if the String contains the specified sequence of characters.
 * - startsWith(String prefix): Returns true if the String starts with the specified prefix.
 * - endsWith(String suffix): Returns true if the String ends with the specified suffix.
 * - isEmpty(): Returns true if the String is empty (length is 0).
 * - valueOf(int i): Returns the String representation of the specified integer.
 * - format(String format, Object... args): Returns a formatted String using the specified format string and arguments.
 *
 *
 */
public class Strings {
}

class StringLiteralExample {
    public static void main(String[] args) {
        // Creating a String using a string literal
        String str1 = "Hello, World!";
        System.out.println("String 1: " + str1);
    }
}

class StringConstructorExample {
    public static void main(String[] args) {
        // Creating a String using the String class constructor
        String str2 = new String("Hello, Java!");
        System.out.println("String 2: " + str2);
    }
}

class ImmutableStringExample {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println("Original String: " + str);

        // Attempting to modify the String
        str.concat(", World!");
        System.out.println("After concat (immutable): " + str);

        // Creating a new String after modification
        String modifiedStr = str.concat(", World!");
        System.out.println("Modified String: " + modifiedStr);
    }
}