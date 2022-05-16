package com.company.revision;


public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) {
            this.value = value;
        }
    }

    public MyLinkedList() {
        this.size = 0;
    }

    // addFirst
    public void addFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        if (tail == null) {
            tail = node;
        }
        head = node;
        size++;
    }

    public void addLast(int val) {
        if (size == 0) {
            addFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void add(int index, int val) {
        if (index == 0) {
            addFirst(val);
            return;
        }
        if (index == size) {
            addLast(val);
            return;
        }
        Node temp = head;
        Node node = new Node(val);
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public void removeFirst() {
        if (size == 0) {
            System.out.println("It is already empty");
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        display();
    }

    public void removeLast() {
        if (size <= 1) {
            removeFirst();
            return;
        }
        Node temp = find(size - 2);
        tail = temp;
        tail.next = null;
        size--;
        display();
    }

    public void remove(int index) {
        if (size <= 1) {
            removeFirst();
            return;
        }
        if (size == index) throw new IndexOutOfBoundsException("Index: " + index + "Size: " + size);
        if (index == size - 1) {
            removeLast();
            return;
        }
        Node temp = find(index - 1);
        temp.next = temp.next.next;
        size--;
        display();
    }

    public Node find(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void display() {
        Node temp = head;
        if (size == 0) {
            System.out.println("Empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }


}
