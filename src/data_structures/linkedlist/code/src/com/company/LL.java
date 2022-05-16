package com.company;

import java.util.NoSuchElementException;

class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    public void insertFirst(int val) { // o(1)
        Node node = new Node(val); // create new node having asked value

        node.next = head; // this new node points to node where head is pointing to
        // initially, head is pointing to null so new node will also point to null,
        // but when there are already elements, new node will point to that first
        // node but head needs to be changed now in any case this or initial...

        head = node; // make that head point to this new node as this new node became
        // first element and head always points to first element

        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void insertLast(int val) { // o(1)
        // if this tail(extra var) was not there, we would have to
        // traverse through arr like display which would take o(n)
        // so this is the benefit of taking tail

        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    // my method
    public void insertMid(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }
        Node node = new Node(val);
        Node temp1 = head;
        Node temp2 = head.next;

        int count = 1;
        while (count != index) {
            temp1 = temp1.next;
            temp2 = temp2.next;
            count++;
        }

        temp1.next = node;
        node.next = temp2;
        size++;
    }

    // after clicking by watching lec
    public void insertMid2(int val, int index) {
        if (index > size) throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;

        int count = 1;
        while (count != index) {
            temp = temp.next;
            count++;
        }

        Node node = new Node(val, temp.next);
        //        node.next = temp.next; // this can be done by directly passing next in the constructor
        // like this Node node = new Node(val, temp.next);

        temp.next = node;

        // more optimisation temp.next = new Node(val, temp.next);
        size++;
    }

    public Node find(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void removeFirst() {
        if (head == null)
            throw new NoSuchElementException();
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        display();
    }

    public void remove(int index) {
        if (index <= 0) {
            removeFirst();
        }
        if (index == size - 1) {
            removeLast();
        }

//   to remove an element, we need element before it, hence index-1
        Node temp = getNode(index - 1);
        temp.next = temp.next.next;
        size--;
        display();
    }

    public void removeLast() { // o(n)
        if (head == null)
            throw new NoSuchElementException();
        if (size <= 1) {
            removeFirst();
        }

        // to remove last element, we need element before it, hence size-2
        Node secondLast = getNode(size -2); // size-1 is the last node
        tail = secondLast;
        tail.next = null;
        size--;
        display();
    }

    public Node getNode(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int getSize() {
        return size;
    }

    public void display() {  // o(n)
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next; // not head.next
        }
        System.out.println("END");
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) { // when no value is provided for Node, this means
            // by default it will have 'null' as it is object type, not primitive
            this.value = value;
        }
    }
}
