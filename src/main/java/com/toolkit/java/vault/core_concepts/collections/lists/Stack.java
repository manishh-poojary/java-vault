package com.toolkit.java.vault.core_concepts.collections.lists;

/**
 * Stack
 *
 * <p>
 * A stack is a linear data structure that follows the Last In First Out (LIFO) principle,
 * meaning that the last element added to the stack is the first one to be removed.
 * It can be visualized as a collection of elements stacked on top of each other, where you
 * can only add or remove elements from the top of the stack.
 *
 * <p>
 * Key points about stacks in Java:
 * 1. LIFO Principle: The last element added is the first one to be removed.
 * 2. Operations: Common operations on a stack include push (add an element),
 * pop (remove the top element), and peek (view the top element without removing it).
 * 3. Implementation: Stacks can be implemented using arrays or linked lists.
 * 4. Use Cases: Stacks are used in various applications such as expression evaluation,
 * backtracking algorithms, and undo mechanisms in software.
 * 5. Thread Safety: Stacks are not inherently thread-safe, and concurrent modifications
 * may require synchronization.
 *
 * <p>
 * Types of Stacks:
 * 1. Array-based Stack: A stack implemented using an array, which has a fixed size.
 * 2. Linked List-based Stack: A stack implemented using a linked list, which can grow and shrink dynamically.
 * 3. Built-in Stack Class: Java provides a built-in Stack class in the java.util package that can be used directly.
 */

public class Stack {
}

class ArrayBasedStack {
    private final int maxSize;
    private final int[] stackArray;
    private int top;

    public ArrayBasedStack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    public void push(int value) {
        if (top >= maxSize - 1) {
            System.out.println("Stack is full. Cannot push " + value);
            return;
        }
        stackArray[++top] = value;
        System.out.println("Pushed " + value + " to stack.");
    }

    public int pop() {
        if (top < 0) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1; // Indicating stack is empty
        }
        return stackArray[top--];
    }

    public int peek() {
        if (top < 0) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; // Indicating stack is empty
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top >= maxSize - 1;
    }
}

class LinkedListBasedStack {
    private Node top;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        System.out.println("Pushed " + value + " to stack.");
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1; // Indicating stack is empty
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; // Indicating stack is empty
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

class StackExample {
    public static void main(String[] args) {
        System.out.println("Array-based Stack Example:");
        ArrayBasedStack arrayStack = new ArrayBasedStack(5);
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        System.out.println("Top element is: " + arrayStack.peek());
        System.out.println("Popped element is: " + arrayStack.pop());
        System.out.println("Is stack empty? " + arrayStack.isEmpty());

        System.out.println("\nLinked List-based Stack Example:");
        LinkedListBasedStack linkedListStack = new LinkedListBasedStack();
        linkedListStack.push(100);
        linkedListStack.push(200);
        linkedListStack.push(300);
        System.out.println("Top element is: " + linkedListStack.peek());
        System.out.println("Popped element is: " + linkedListStack.pop());
        System.out.println("Is stack empty? " + linkedListStack.isEmpty());
    }
}
