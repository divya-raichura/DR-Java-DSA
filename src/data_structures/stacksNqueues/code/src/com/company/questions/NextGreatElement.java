package com.company.questions;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatElement {
    public static void main(String[] args) {
        int[] arr = {4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6};
        System.out.println(Arrays.toString(nextGreaterElement1(arr)));
    }

    // I
    static int[] nextGreaterElement1(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() > arr[i]) {
                nge[i] = stack.peek();
            }
            if (stack.isEmpty()){
                nge[i] = -1;
            }
            stack.push(arr[i]);
        }
        return nge;
    }

    // II
    static int[] nextGreaterElement2(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[arr.length];
        for (int i = (2 * arr.length) - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i % arr.length]) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() > arr[i % arr.length]) {
                nge[i % arr.length] = stack.peek();
            }
            if (stack.isEmpty()){
                nge[i % arr.length] = -1;
            }
            stack.push(arr[i % arr.length]);
        }
        return nge;
    }
}
