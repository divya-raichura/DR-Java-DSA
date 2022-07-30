package com.company.questions;

import java.util.Scanner;
import java.util.Stack;


public class PostPrefix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine(); // 2*3+5*4-9 = 6+20-9
        // >>>12 * 3 + 4 * 2 - 9<<<
        System.out.println(postfix(str)); // to solve postfix

        // convert to postfix
        // https://www.youtube.com/watch?v=vq-nUF0G4fI&list=PL2_aWCzGMAwI3W_JlcBbtYTwiQSsOTa6P&index=21&ab_channel=mycodeschool
    }

    static int postfix(String str) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                continue;
            } else if (isNum(str.charAt(i))) {
                int operand = 0;
                while (i < str.length() && isNum(str.charAt(i))){
                    operand =  operand * 10 + str.charAt(i) - '0';
                    i++;
                }
                i--;
                stack.push(operand);
            } else if (isOp(str.charAt(i))) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                int result = operation(str.charAt(i), op1, op2);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private static int operation(char charAt, int a, int b) {
        return switch (charAt) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> -1;
        };
        /*
        switch (charAt) {
            case '+' : return a + b;
            case '-' : return a - b;
            case '*' : return a * b;
            case '/' : return a / b;
        }
        return -1;
         */
    }

    private static boolean isOp(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    static boolean isNum(char ch) {
        return ch <= '9' && ch >= '0';
    }
}
