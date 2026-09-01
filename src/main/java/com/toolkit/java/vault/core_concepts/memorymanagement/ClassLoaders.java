package com.toolkit.java.vault.core_concepts.memorymanagement;

/**
 * Class Loaders in Java
 *
 * <p>
 * Class loaders are a fundamental part of the Java Runtime Environment (JRE) that dynamically load classes into the
 * Java Virtual Machine (JVM) at runtime. They are responsible for locating, loading, and linking classes and resources
 * needed by a Java application.
 *
 * <p>
 * Class Loading process:
 * 1. Loading: The class loader reads the binary data of a class from the file system or network and creates a Class
 * object in the JVM.
 * 2. Linking: The class loader verifies the correctness of the class, prepares it for use by allocating memory for
 * its fields and methods.
 * 3. Initialization: The class loader initializes the class by executing its static initializers and static blocks.
 *
 * <p>
 * Key characteristics of class loaders:
 * - Hierarchical Structure: Class loaders follow a parent-child delegation model, where a child class loader delegates
 * the loading of a class to its parent before attempting to load it itself.
 * - Dynamic Loading: Classes can be loaded at runtime, allowing for flexible and modular application design.
 * - Custom Class Loaders: Developers can create custom class loaders to load classes from non-standard sources or to
 * implement specific loading behavior.
 *
 * <p>
 * Common types of class loaders in Java include:
 * - Bootstrap Class Loader: Loads core Java classes from the Java Runtime Environment (JRE).
 * - Extension Class Loader: Loads classes from the JDK extensions directory.
 * - System/Application Class Loader: Loads classes from the application's classpath.
 *
 * <p>
 * Understanding class loaders is essential for advanced Java programming, especially when dealing with complex
 * applications, modular systems, or custom loading requirements.
 */
public class ClassLoaders {
}

/**
 * Metaspace in Java
 *
 * <p>
 * Metaspace is a memory area in the Java Virtual Machine (JVM) that stores class metadata. It was introduced in
 * Java 8 as a replacement for the Permanent Generation (PermGen) space, which was used in earlier versions of Java.
 *
 * <p>
 * Components of Metaspace:
 * - Class Structure: Metaspace stores information about classes, including their structure, methods, fields, and annotations.
 * - Method Metadata: It holds metadata related to methods, such as method signatures and bytecode.
 * - Field Metadata: Metaspace contains metadata about fields, including their types and access modifiers.
 * - Annotations: It stores information about annotations applied to classes, methods, and fields.
 * - Constant Pool: Metaspace includes a constant pool that holds references to constants used in the class,
 * such as string literals and numeric constants.
 *
 * <p>
 * Key characteristics of Metaspace:
 * - Dynamic Sizing: Unlike PermGen, Metaspace can grow dynamically based on the application's needs, reducing the
 * risk of OutOfMemoryError related to class metadata.
 * - Native Memory: Metaspace uses native memory (outside of the Java heap) to store class metadata, which allows
 * for better memory management and performance.
 * - Class Metadata Storage: Metaspace stores information about classes, such as their structure, methods, fields,
 * and annotations.
 *
 * <p>
 * Common issues related to Metaspace include:
 * - OutOfMemoryError: This can occur if the application loads a large number of classes or if there are memory leaks
 * related to class loading.
 * - Class Loader Leaks: If classes are not properly unloaded or if custom class loaders are used incorrectly,
 * it can lead to memory leaks in Metaspace.
 *
 * <p>
 * Understanding Metaspace is important for optimizing memory usage and preventing memory-related issues in Java
 * applications.
 */

class Metaspace {

}