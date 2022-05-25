package com.company;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class ReverseUsingStack {

    Node head;
    int size;

    public ReverseUsingStack() {
        this.size = 0;
    }

    public void add(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void reverse() {
        Stack<Node> stack = new Stack<>();
        Node temp = head;
        while (temp.next != null) {
            stack.push(temp);
            temp = temp.next;
        }
        head = temp;
        while (!stack.isEmpty()) {
            temp.next = stack.peek();
            temp = temp.next;
            stack.pop();
        }
        temp.next = null;
    }

    class Node {
        Node next;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        // reversing string
//        Stack<Character> stack = new Stack<>();
//        Scanner in = new Scanner(System.in);
//        String str = in.next();
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < str.length(); i++) {
//            stack.push(str.charAt(i));
//        }for (int i = 0; i < str.length(); i++) {
//            builder.append(stack.pop());
//        }
//        System.out.println(builder);

        // reversing linked list -> https://www.geeksforgeeks.org/program-to-reverse-a-linked-list-using-stack/
        ReverseUsingStack list = new ReverseUsingStack();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.display();
        list.reverse();
        list.display();
    }
}
