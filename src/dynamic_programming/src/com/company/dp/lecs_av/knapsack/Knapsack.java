package com.company.dp.lecs_av.knapsack;

import java.util.Arrays;

public class Knapsack {

    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int w = 7;
//        int[] wt = {1, 3, 4, 5, 2,4,7,8,9};
//        int[] val = {1, 4, 5, 7,1,5,2,6,3};
//        int w = 20;
//        System.out.println(knapsack(wt, val, w, wt.length));

        // memo
        System.out.println(memoization(w, wt, val, wt.length));

        // tabulation or bottom up or iterative
//        System.out.println(tabulation(wt, val, wt.length, w));
    }

    // recursive
    static int knapsack(int[] wt, int[] val, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }

        if (wt[n - 1] <= w) {
            int includeItem = val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1);
            int doNotInclude = knapsack(wt, val, w, n - 1);

            return Math.max(includeItem, doNotInclude);
        } else {
            return knapsack(wt, val, w, n - 1);
        }

    }

    // memoization
    static int memoization(int w, int[] wt, int[] val, int n)
    {
        int[][] dp = new int[n+1][w+1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        int ans = memoization(w, wt, val, n, dp);
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
        return ans;
    }

    static int memoization(int w, int[] wt, int[] val, int n, int[][] dp) {

        if(n == 0 || w == 0) {
            return 0;
        }

        // memo
        if(dp[n][w] != -1) return dp[n][w];

        if(wt[n-1] <= w) {
            // pick or not pick
            return dp[n][w] = Math.max(val[n - 1] + memoization(w - wt[n - 1], wt, val, n - 1, dp), memoization(w, wt, val, n - 1, dp));
        } else {
            // not possible to put in sack
            //  (wt[n - 1] > w)
            return dp[n][w] = memoization(w, wt, val, n - 1, dp);
        }
    }

    // tabulation or bottom up or iterative
    static int tabulation(int[] wt, int[] val, int n, int w) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }
        }

        // i represents n and j represents w
        // note that i and j are one index more than index in og arrays
        // so index 0 in og arrays is index 1 in dp matrix
        for (int i = 1; i < dp.length; i++) { // i < n + 1
            for (int j = 1; j < dp[i].length; j++) { // j < w + 1
                if (wt[i - 1] <= j) {
                    // pick/not pick => depends which possibility gives max profit
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    // wt[i - 1] > j and item can't be put in sack
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }
}
