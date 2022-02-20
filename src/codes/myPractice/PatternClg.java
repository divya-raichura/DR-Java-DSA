package myPractice;

import java.util.Scanner;

public class PatternClg {
    public static void main(String[] args) {

    }

// kunal kushwaha op
    static void printFun(int n) {
        if (n <= 0) {
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        printFun(n-5);
        System.out.print(n + " ");
    }

    // my try
    static int ans(int target, int n, int prev){

        if (n <= 0) {
            System.out.print(n + " ");
            return ans(target, n + 5, n);
        }

        if (prev > n) {
            System.out.print(n + " ");
            return ans(target, n - 5, n);
        } else {
            if (n == target) {
                return n;
            }
            System.out.print(n + " ");
            return ans(target, n+5, n);
        }


    }

}
