package com.company;

public class DoublyLL {
    private Node head;
//    private Node tail;
    private int size;

    public DoublyLL() {
        this.size = 0;
    }

    public void addFirst(int val) {
        Node node = new Node(val);
//        if (tail == null) {
//            tail = node;
//        }
        node.next = head;
        if (head != null){
            head.prev = node; // what if head is null, then null.prev gives null pointer
        }
        head = node;
        size++;
    }

    public Node getNodeOfValue(int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == val) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void addAfter(int after, int val) {
        Node temp = getNodeOfValue(after);
        if (temp == null) {
            System.out.println("value not found");
            return;
        }
        Node node = new Node(val, temp.next, temp);
        temp.next = node;
        if (node.next != null) {
            node.next.prev = node;
        }
    }

    public void addLast(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
        size++;
    }

    public void display() {

        Node node = head;
        Node last = null;
        while (node != null) {
            System.out.print(node.value + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        while (last != null) {
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Node(int value) {
            this.value = value;
        }
    }
}
