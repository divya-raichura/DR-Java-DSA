package com.company.dp.lecs_tuf.T5_stocks;

import java.util.Arrays;

public class L36_BuySellUnlimited {
    public static void main(String[] args) {
    }

    public static int rec(int[] arr) {
        return rec(arr, 0, 1);
    }

    // my try
    // 0 for yes you can buy
//    public int rec(int[] arr) {
//        return rec(arr, 0, 0, 0);
//    }
//
//    public int rec(int[] arr, int holdings, int i, int buyOrSell) {
//        if (i == arr.length) return 0;
//        if (holdings == 0 && buyOrSell == 0) {
//            int buy = rec(arr, arr[i], i + 1, 1);
//            int doNotBuy = rec(arr, 0, i + 1, 0);
//            return Math.max(buy, doNotBuy);
//        } else {
//            int profit = arr[i] - holdings;
//            int sell = profit + rec(arr, 0, i + 1, 0);
//            int doNotSell = rec(arr, holdings, i + 1, 1);
//            return Math.max(sell, doNotSell);
//        }
//    }

    // 1: you can buy
    // 0: you cannot buy
    public static int rec(int[] arr, int i, int buyOrSell) {
        if (arr.length == i) return 0;
        if (buyOrSell == 1) {
            int buy = -arr[i] + rec(arr, i + 1, 0);
            int doNotBuy = rec(arr, i + 1, 1);
            return Math.max(buy, doNotBuy);
        } else {
            int sell = arr[i] + rec(arr, i + 1, 1);
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
        if (arr.length == i) return 0;
        if (dp[i][buyOrSell] != -1) return dp[i][buyOrSell];
        if (buyOrSell == 1) {
            int buy = -arr[i] + memo(arr, i + 1, 0, dp);
            int doNotBuy = memo(arr, i + 1, 1, dp);
            return dp[i][buyOrSell] = Math.max(buy, doNotBuy);
        } else {
            int sell = arr[i] + memo(arr, i + 1, 1, dp);
            int doNotSell = memo(arr, i + 1, 0, dp);
            return dp[i][buyOrSell] = Math.max(sell, doNotSell);
        }
    }

    static int tabulation(int[] arr) {
        int[][] dp = new int[arr.length + 1][2];
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int buyOrSell = 1; buyOrSell >= 0; buyOrSell--) {
                if (buyOrSell == 1) {
                    int buy = -arr[i] + dp[i + 1][0];
                    int doNotBuy = dp[i + 1][1];
                    dp[i][buyOrSell] = Math.max(buy, doNotBuy);
                } else {
                    int sell = arr[i] + dp[i + 1][1];
                    int doNotSell = dp[i + 1][0];
                    dp[i][buyOrSell] = Math.max(sell, doNotSell);
                }
            }
        }
        return dp[0][1];
    }

    static int spaceOpt(int[] arr) {
        int[] prev = new int[2];
        for (int i = arr.length - 1; i >= 0; i--) {
            int[] curr = new int[2]; // it will also work if we don't initialize curr after every iteration
            for (int buyOrSell = 0; buyOrSell < 2; buyOrSell++) {
                if (buyOrSell == 1) { // buy
                    int buy = -arr[i] + prev[0];
                    int doNotBuy = prev[1];
                    curr[buyOrSell] = Math.max(buy, doNotBuy);
                } else { // sell
                    int sell = arr[i] + prev[1];
                    int doNotSell = prev[0];
                    curr[buyOrSell] = Math.max(sell, doNotSell);
                }
            }
            prev = curr;
        }
        return prev[1];
    }

    // best solution
    static int spaceOptToVars(int[] arr) {
        int prevBuy = 0, prevNotBuy = 0, currBuy = 0, currSell = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            currBuy = Math.max(-arr[i] + prevNotBuy, prevBuy);
            currSell = Math.max(arr[i] + prevBuy, prevNotBuy);
            prevBuy = currBuy;
            prevNotBuy = currSell;
        }
        return prevBuy;
    }

    public int leetcodeSolution(int[] prices) {
        int i = 0, buy, sell, profit = 0, N = prices.length - 1;
        while (i < N) {
            while (i < N && prices[i + 1] <= prices[i]) i++;
            buy = prices[i];

            while (i < N && prices[i + 1] > prices[i]) i++;
            sell = prices[i];

            profit += sell - buy;
        }
        return profit;
    }
}
