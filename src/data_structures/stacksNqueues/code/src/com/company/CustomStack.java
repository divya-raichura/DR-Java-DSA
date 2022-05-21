package com.company;

import java.util.Arrays;

public class CustomStack {
    protected int[] arr;
    private static final int Default_Size = 10;
    int ptr = -1;

    public CustomStack(int size) {
        this.arr = new int[size];
    }

    public CustomStack() {
        this(Default_Size);
    }

    @Override
    public String toString() {
        return "CustomStack{" +
                "arr=" + Arrays.toString(arr) +
                ", ptr=" + ptr +
                '}';
    }

    public void push(int n) throws StackException {
        if (isFull()) {
            throw new StackException("Stack full");

        }
        ptr++;
        arr[ptr] = n;
    }

    protected boolean isFull() {
        return ptr == arr.length - 1;
    }

    public int pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Empty Stack");
        }
        return arr[ptr--];
    }

    public int peek() throws StackException {
        if (isEmpty()) {
            throw new StackException("Empty Stack");
        }
        return arr[ptr];
    }

    protected boolean isEmpty() {
        return ptr == -1;
    }


}
