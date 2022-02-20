package com.myPractice;

public class Ackerman {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            System.out.printf("for m = %d and n from 1 to 6: ", i);
            for (int j = 1; j <= 6; j++) {
                System.out.print(ans(i, j) + " ");
            }
            System.out.println();
        }
    }

    static int ans(int m, int n) {
        if (m == 0 && n > 0) {
            return n + 1;
        }
        if (n == 0 && m > 0) {
            return ans(m - 1, 1);
        }
        return ans(m - 1, ans(m, n - 1));
    }

}
