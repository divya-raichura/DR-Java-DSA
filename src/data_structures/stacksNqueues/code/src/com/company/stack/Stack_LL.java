package com.company.stack;


public class Stack_LL {

    Node head;
    int size;

    public Stack_LL() {
        this.size = 0;
    }

    public void push(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    public int pop() throws Exception {
        if (head == null) {
            throw new Exception("empty stack");
        }

        int popAns = head.val;
        head = head.next;
        return popAns;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " <- ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private boolean isEmpty() {
        return size == 0;
    }


    static class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) throws Exception {
        Stack_LL stack = new Stack_LL();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.display();
        stack.pop();
        stack.display();
    }
}
