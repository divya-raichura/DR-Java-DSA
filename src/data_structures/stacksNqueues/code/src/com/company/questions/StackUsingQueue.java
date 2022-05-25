package com.company.questions;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

    int pop() {
        if (q1.isEmpty()) {
            return -1;
        }
        return q1.remove();
    }

    void display() {
        System.out.println(q1);
    }


    public static void main(String[] args) {
//        StackUsingQueue s = new StackUsingQueue();
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        s.push(4);
//        s.display();
//        s.pop();
//        s.pop();
//        s.pop();
//        s.display();

        StackUsingOneQueue sq = new StackUsingOneQueue();
        sq.push(1);
        sq.push(2);
        sq.push(3);
        sq.push(4);
        sq.push(15);
        sq.display();
        sq.pop();
        sq.pop();
        sq.display();
    }
}


class StackUsingOneQueue {
    Queue<Integer> q = new LinkedList<>();

    void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }
    }

    int pop() {
        return q.remove();
    }

    void display() {
        System.out.println(q);
    }
}