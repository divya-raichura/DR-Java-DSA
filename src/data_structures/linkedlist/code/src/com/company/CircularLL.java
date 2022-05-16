package com.company;

public class CircularLL {

    private Node head;
    private Node tail;
    private int size;

    public CircularLL() {
        this.size = 0;
    }

    public void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            node.next = node;
            return;
        }
        node.next = head;
        tail.next = node;
        tail = node;
    }

    public Node nextNode(int val) {
        if (head == null) {
            System.out.println("empty");
            return null;
        }
        Node temp = head;
        do {
            if (temp.next.val == val) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);
        return null;
    }

    public void delete(int val) {
        if (head == null) {
            System.out.println("empty");
            return;
        }
        if (head.next == head) {
            head = null;
            tail = null;
            return;
        }
        if (head.val == val) {
            tail.next = head.next;
            head = head.next;
            return;
        }
        Node temp = nextNode(val);
        if (temp == null) {
            System.out.println("value " + val + " doesn't exist");
            return;
        }
        temp.next = temp.next.next;
        display();
    }

    public void display() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            } while (temp != head);
        } else return;
        System.out.println("Head: " + temp.val);
    }

    private class Node {
        private int val;
        private Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }
    }
}
