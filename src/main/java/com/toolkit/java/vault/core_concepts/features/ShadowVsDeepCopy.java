package com.toolkit.java.vault.core_concepts.features;

/**
 * Shadow Copy vs Deep Copy
 * <p>
 * Shadow Copy:
 * A shadow copy is a copy of an object that shares the same memory reference as the original object.
 * This means that if you modify the shadow copy, the changes will also affect the original object, and vice versa.
 * In Java, when you assign one object to another, you are creating a shadow copy.
 *
 * <p>
 * Deep Copy:
 * A deep copy is a copy of an object that creates a new instance of the object and copies all the values from the original object to the new instance.
 * This means that if you modify the deep copy, the changes will not affect the original object, and vice versa.
 * In Java, you can create a deep copy by implementing the Cloneable interface and overriding the clone() method, or by using serialization.
 */
public class ShadowVsDeepCopy {
}

class ShadowCopyExample {
    public static void main(String[] args) {
        // Create an original object
        Person original = new Person("John", 30);

        // Create a shadow copy (both references point to the same object)
        Person shadowCopy = original;

        // Modify the shadow copy
        shadowCopy.setAge(31);

        // Print both objects
        System.out.println("Original: " + original); // Original: Person{name='John', age=31}
        System.out.println("Shadow Copy: " + shadowCopy); // Shadow Copy: Person{name='John', age=31}
    }
}

class DeepCopyExample {
    public static void main(String[] args) {
        // Create an original object
        Person original = new Person("John", 30);

        // Create a deep copy (new instance with the same values)
        Person deepCopy = new Person(original.getName(), original.getAge());

        // Modify the deep copy
        deepCopy.setAge(31);

        // Print both objects
        System.out.println("Original: " + original); // Original: Person{name='John', age=30}
        System.out.println("Deep Copy: " + deepCopy); // Deep Copy: Person{name='John', age=31}
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
