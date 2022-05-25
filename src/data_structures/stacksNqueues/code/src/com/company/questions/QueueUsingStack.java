package com.company.questions;

import java.util.*;

public class QueueUsingStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    void add(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    int remove() {
        return stack1.pop();
    }

    void display() {
        System.out.println(stack1);
    }

    public static void main(String[] args) {
//        QueueUsingStack q = new QueueUsingStack();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(41);
//        q.add(5);
//        q.display();
//        q.remove();
//        q.remove();
//        q.display();

        QueueUsingOneStack q = new QueueUsingOneStack();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(41);
        q.add(5);
        q.display();
        System.out.println(q.remove());;
        System.out.println(q.remove());
        q.display();

    }
}


class QueueUsingOneStack {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    List<Integer> l = new ArrayList<>();

    void add(int x) {
        in.push(x);
        l.add(x);
    }

    int remove() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        l.remove(0);
        return out.pop();
    }

    int peek() {
        if (out.isEmpty()) {
            for (int i = 0; i < in.size(); i++) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }



    void display() {
        System.out.println("in : "  + in);
        System.out.println("out : "  + out);
        System.out.println("list : " + l);
    }
}