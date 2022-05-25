package com.company.questions;

import java.util.Scanner;
import java.util.Stack;

public class Parentheses {
    // https://www.youtube.com/watch?v=QZOLb0xHB_Q&list=PL2_aWCzGMAwI3W_JlcBbtYTwiQSsOTa6P&index=18&ab_channel=mycodeschool
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(parenthesis(str));
    }

    // time complexity  = o(n)
    // space complexity = o(n)

    static boolean parenthesis(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
             if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                stack.push(str.charAt(i));
            }else if (str.charAt(i) == ']' || str.charAt(i) == '}' || str.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (str.charAt(i) == '}' && stack.peek() != '{') return false;
                if (str.charAt(i) == ']' && stack.peek() != '[') return false;
                if (str.charAt(i) == ')' && stack.peek() != '(') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
