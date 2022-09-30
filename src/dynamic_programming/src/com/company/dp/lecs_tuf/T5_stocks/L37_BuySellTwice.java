package com.company.dp.lecs_tuf.T5_stocks;

import java.util.Arrays;

public class L37_BuySellTwice {
    public static void main(String[] args) {

    }

    static int rec(int[] arr) {
        return rec(arr, 0, 1, 2);
    }

    // 1 : buy
    // tc: expo
    // sc: o(n)
    static int rec(int[] arr, int i, int buyOrSell, int cap) {
        if (i == arr.length || cap == 0) return 0;
        if (buyOrSell == 1) {
            int buy = -arr[i] + rec(arr, i + 1, 0, cap);
            int notBuy = rec(arr, i + 1, 1, cap);
            return Math.max(buy, notBuy);
        } else {
            int sell = arr[i] + rec(arr, i + 1, 1, cap - 1);
            int notSell = rec(arr, i + 1, 0, cap);
            return Math.max(sell, notSell);
        }
    }

    // tc : n * 2 * 3
    // sc : n * 2 * 3 + o(n) aux stack space
    static int memo(int[] arr) {
        int[][][] dp = new int[arr.length + 1][2][3];
        for (int[][] arrays : dp) {
            for (int[] array : arrays) {
                Arrays.fill(array, -1);
            }
        }
        return memo(arr, 0, 1, 2, dp);
    }

    static int memo(int[] arr, int i, int buyOrSell, int cap, int[][][] dp) {
        if (i == arr.length || cap == 0) return 0;
        if (buyOrSell == 1) {
            int buy = -arr[i] + memo(arr, i + 1, 0, cap, dp);
            int notBuy = memo(arr, i + 1, 1, cap, dp);
            return Math.max(buy, notBuy);
        } else {
            int sell = arr[i] + memo(arr, i + 1, 1, cap - 1, dp);
            int notSell = memo(arr, i + 1, 0, cap, dp);
            return Math.max(sell, notSell);
        }
    }

    static int tabulation(int[] arr) {
        int[][][] dp = new int[arr.length + 1][2][3];
        for (int i = arr.length -1; i >= 0; i--) {
            for (int buyOrSell = 0; buyOrSell <= 1; buyOrSell++) {
                for (int cap = 1; cap <=  2; cap++) {
                    if (buyOrSell == 1) {
                        int buy = -arr[i] + dp[i + 1][0][cap];
                        int notBuy = dp[i + 1][1][cap];
                        dp[i][buyOrSell][cap] = Math.max(buy, notBuy);
                    } else {
                        int sell = arr[i] +dp[i + 1][1][cap - 1];
                        int notSell = dp[i + 1][0][cap];
                        dp[i][buyOrSell][cap] = Math.max(sell, notSell);
                    }
                }
            }
        }
        return dp[0][1][2];
    }

    // tc : n * 2 * 3
    // sc : constant (6)
    static int spaceOpt(int[] arr) {
        int[][] after = new int[2][3];
        int[][] curr = new int[2][3]; // works without initializing after every iteration
        for (int i = arr.length -1; i >= 0; i--) {
            for (int buyOrSell = 0; buyOrSell <= 1; buyOrSell++) {
                for (int cap = 1; cap <=  2; cap++) {
                    if (buyOrSell == 1) {
                        int buy = -arr[i] + after[0][cap];
                        int notBuy = after[1][cap];
                        curr[buyOrSell][cap] = Math.max(buy, notBuy);
                    } else {
                        int sell = arr[i] + after[1][cap - 1];
                        int notSell = after[0][cap];
                        curr[buyOrSell][cap] = Math.max(sell, notSell);
                    }
                }
            }
            after = curr;
        }
        return curr[1][2];
    }


    // n * 4 tc when memoization is done
    static int anotherMethod(int[] arr, int i, int transaction) {
        if (i == arr.length || transaction == 4) return 0;
        if (transaction % 2 == 0) { // buy
            int buy = -arr[i] + anotherMethod(arr, i + 1, transaction + 1);
            int notBuy = anotherMethod(arr, i + 1, transaction);
            return Math.max(buy, notBuy);
        } else { // sell
            int sell = arr[i] + anotherMethod(arr, i + 1, transaction + 1);
            int notSell = anotherMethod(arr, i + 1, transaction);
            return Math.max(sell, notSell);
        }
    }
}
