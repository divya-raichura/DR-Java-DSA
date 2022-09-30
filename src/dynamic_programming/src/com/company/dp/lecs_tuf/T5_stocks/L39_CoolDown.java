package com.company.dp.lecs_tuf.T5_stocks;

import java.util.Arrays;

public class L39_CoolDown {
    public static void main(String[] args) {

    }

    public static int rec(int[] arr, int i, int buyOrSell) {
        if (arr.length <= i) return 0;
        if (buyOrSell == 1) {
            int buy = -arr[i] + rec(arr, i + 1, 0);
            int doNotBuy = rec(arr, i + 1, 1);
            return Math.max(buy, doNotBuy);
        } else {
            int sell = arr[i] + rec(arr, i + 2, 1);
            int doNotSell = rec(arr, i + 1, 0);
            return Math.max(sell, doNotSell);
        }
    }

    public static int memo(int[] arr) {
        int[][] dp = new int[arr.length + 1][2];
        for (int[] arrays : dp) {
            Arrays.fill(arrays, -1);
        }
        return memo(arr, 0, 1, dp);
    }

    // 1: you can buy
    // 0: you cannot buy
    public static int memo(int[] arr, int i, int buyOrSell, int[][] dp) {
        if (arr.length <= i) return 0;
        if (dp[i][buyOrSell] != -1) return dp[i][buyOrSell];
        if (buyOrSell == 1) {
            int buy = -arr[i] + memo(arr, i + 1, 0, dp);
            int doNotBuy = memo(arr, i + 1, 1, dp);
            return dp[i][buyOrSell] = Math.max(buy, doNotBuy);
        } else {
            int sell = arr[i] + memo(arr, i + 2, 1, dp);
            int doNotSell = memo(arr, i + 1, 0, dp);
            return dp[i][buyOrSell] = Math.max(sell, doNotSell);
        }
    }

    static int tabulation(int[] arr) {
        int[][] dp = new int[arr.length + 2][2];
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int buyOrSell = 1; buyOrSell >= 0; buyOrSell--) {
                if (buyOrSell == 1) {
                    int buy = -arr[i] + dp[i + 1][0];
                    int doNotBuy = dp[i + 1][1];
                    dp[i][buyOrSell] = Math.max(buy, doNotBuy);
                } else {
                    int sell = arr[i] + dp[i + 2][1];
                    int doNotSell = dp[i + 1][0];
                    dp[i][buyOrSell] = Math.max(sell, doNotSell);
                }
            }
        }
        return dp[0][1];
    }

    static int spaceOpt(int[] arr) {
        int[][] dp = new int[arr.length + 2][2];
        for (int i = arr.length - 1; i >= 0; i--) {

            dp[i][1] = Math.max(-arr[i] + dp[i + 1][0], dp[i + 1][1]);

            dp[i][0] = Math.max(arr[i] + dp[i + 2][1], dp[i + 1][0]);

        }
        return dp[0][1];
    }

    static int spaceOpt2(int[] arr) {
        int[] after2 = new int[2];
        int[] after1 = new int[2];
        int[] curr = new int[2];
        for (int i = arr.length - 1; i >= 0; i--) {
            curr[1] = Math.max(-arr[i] + after1[0], after1[1]);

            curr[0] = Math.max(arr[i] + after2[1], after1[0]);

            /*HERE, WE MUST INITIALIZE NEW ARRAY AFTER EVERY ITERATION */
//            after2 = after1;
//            after1 = curr; // gives error

//            DO THIS
//            after2 = after1.clone();
//            after1 = curr.clone();

//            OR
            after2 = after1;
            after1 = curr;
            curr = new int[2];
        }
        return after1[1];
    }

    public int rec(int[] arr) {
        return rec(arr, 0, 1);
    }
}
