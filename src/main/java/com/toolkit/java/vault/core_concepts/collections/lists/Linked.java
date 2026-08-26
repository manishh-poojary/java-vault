package com.toolkit.java.vault.core_concepts.collections.lists;

/**
 * Linked List
 *
 * <p>
 * A linked list is a linear data structure that consists of a sequence of elements, where each element (node) contains
 * a reference (link) to the next node in the sequence. Unlike arrays, linked lists do not have a fixed size and can
 * grow or shrink dynamically as elements are added or removed.
 *
 * <p>
 * Key points about linked lists in Java:
 * 1. Dynamic Size: The size of a linked list can change during runtime, allowing for efficient memory usage.
 * 2. Non-Contiguous Memory: Elements in a linked list are stored in non-contiguous memory locations, with each node
 * containing a reference to the next node.
 * 3. Types of Linked Lists: There are several types of linked lists, including singly linked lists, doubly linked
 * lists, and circular linked lists.
 * 4. Operations: Common operations on linked lists include insertion, deletion, traversal, and searching for elements.
 * 5. Performance: Linked lists provide efficient insertion and deletion operations, especially when compared to arrays,
 * but have slower access times compared to arrays.
 * 6. Thread Safety: Linked lists are not inherently thread-safe, and concurrent modifications may require synchronization.
 *
 * <p>
 * Types of Linked Lists:
 * 1. Singly Linked List: Each node contains a reference to the next node, allowing for traversal in one direction.
 * 2. Doubly Linked List: Each node contains references to both the next and previous nodes, allowing for traversal
 * in both directions.
 * 3. Circular Linked List: The last node in the list points back to the first node, creating a circular structure.
 */
public class Linked {
}

class SinglyLinkedListExample {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        Node head;

        // Insert a new node at the end of the list
        public void insert(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        // Display the linked list
        public void display() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.display(); // Output: 1 -> 2 -> 3 -> 4 -> null
    }
}

class DoublyLinkedListExample {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        Node head;

        // Insert a new node at the end of the list
        public void insert(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }

        // Display the linked list
        public void display() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " <-> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.display(); // Output: 1 <-> 2 <-> 3 <-> 4 <-> null
    }
}

class CircularLinkedListExample {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class CircularLinkedList {
        Node head;

        // Insert a new node at the end of the list
        public void insert(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                newNode.next = head; // Point to itself
                return;
            }
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head; // Point back to head
        }

        // Display the circular linked list
        public void display() {
            if (head == null) return;
            Node current = head;
            do {
                System.out.print(current.data + " -> ");
                current = current.next;
            } while (current != head);
            System.out.println("(back to head)");
        }
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.display(); // Output: 1 -> 2 -> 3 -> 4 -> (back to head)
    }
}
