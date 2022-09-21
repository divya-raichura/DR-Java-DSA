package com.company.dp.lecs_tuf.T1__oneD_arr_questions;

import java.util.Arrays;

public class L1_Fibo {
    public static void main(String[] args) {
        int n = 7;

        // recursion
        System.out.println(fibo(n));

        // memo
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(memo(n, dp));

        // tabulation
        System.out.println(tabulation(n));

        // space optimised tabulation
        System.out.println(spaceOptimised(n));
    }

    public static int fibo(int n) {

        if (n < 2) return n;

        return fibo(n - 1) + fibo(n - 2);
    }

    public static int memo(int n, int[] dp) {
        if(n <= 1) return n;

        if(dp[n] != -1) return dp[n];

        int ans = memo(n - 1, dp) + memo(n - 2, dp);

        dp[n] = ans;

        return ans;
    }

    public static int tabulation(int n) {
        if(n <= 1) return n;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static int spaceOptimised(int n) {
        int minus2 = 0;
        int minus1 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = minus2 + minus1;
            minus2 = minus1;
            minus1 = curr;
        }

        return minus1;
    }
}
