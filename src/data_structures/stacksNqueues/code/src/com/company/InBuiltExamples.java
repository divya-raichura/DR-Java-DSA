package com.company;

import java.util.*;

public class InBuiltExamples {

    public static void main(String[] args) {


        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop()); // this removes the item
        System.out.println(stack);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.peek()); // it doesn't remove item, it gets the item
        System.out.println(queue.remove()); // this removes the elements
        System.out.println(queue.remove()); // this removes the elements
        System.out.println(queue);

        Deque<Integer> deque = new ArrayDeque<>();

    }
}
