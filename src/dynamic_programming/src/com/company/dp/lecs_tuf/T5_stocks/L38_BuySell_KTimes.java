package com.company.dp.lecs_tuf.T5_stocks;

import java.util.Arrays;

public class L38_BuySell_KTimes {
    public static void main(String[] args) {

    }

    static int rec(int[] arr, int k) {
        return rec(arr, 0, 0, k);
    }

    static int rec(int[] arr, int i, int transaction, int k) {
        if (i == arr.length || transaction == 2 * k) return 0;
        if (transaction % 2 == 0) { // buy
            int buy = -arr[i] + rec(arr, i + 1, transaction + 1, k);
            int notBuy = rec(arr, i + 1, transaction, k);
            return Math.max(buy, notBuy);
        } else { // sell
            int sell = arr[i] + rec(arr, i + 1, transaction + 1, k);
            int notSell = rec(arr, i + 1, transaction, k);
            return Math.max(sell, notSell);
        }
    }

    static int memo(int[] arr, int k) {
        int[][] dp = new int[arr.length + 1][2 * k + 1];
        for (int[] arrays : dp) {
            Arrays.fill(arrays, -1);
        }
        return memo(arr, 0, 0, k, dp);
    }

    static int memo(int[] arr, int i, int transaction, int k, int[][] dp) {
        if (i == arr.length || transaction == 2 * k) return 0;
        if(dp[i][transaction] != -1) return dp[i][transaction];

        if (transaction % 2 == 0) { // buy
            int buy = -arr[i] + memo(arr, i + 1, transaction + 1, k, dp);
            int notBuy = memo(arr, i + 1, transaction, k, dp);
            return dp[i][transaction] = Math.max(buy, notBuy);
        } else { // sell
            int sell = arr[i] + memo(arr, i + 1, transaction + 1, k, dp);
            int notSell = memo(arr, i + 1, transaction, k, dp);
            return dp[i][transaction] = Math.max(sell, notSell);
        }
    }

    static int tabulation(int[] arr, int k) {
        int[][] dp = new int[arr.length + 1][2 * k + 1];

        for (int i = arr.length - 1; i  >= 0; i--) {
            for (int transaction = 2 * k - 1; transaction >= 0; transaction--) {
                if (transaction % 2 == 0) { // buy
                    int buy = -arr[i] + dp[i + 1][transaction + 1];
                    int notBuy = dp[i + 1][transaction];
                    dp[i][transaction] = Math.max(buy, notBuy);
                } else { // sell
                    int sell = arr[i] + dp[i + 1][transaction + 1];
                    int notSell = dp[i + 1][transaction];
                    dp[i][transaction] = Math.max(sell, notSell);
                }
            }
        }
        return dp[0][0];
    }

    static int spaceOpt(int[] arr, int k) {
        int[] after = new int[2 * k + 1];
        int[] curr = new int[2 * k + 1]; // works

        for (int i = arr.length - 1; i  >= 0; i--) {
            for (int transaction = 2 * k - 1; transaction >= 0; transaction--) {
                if (transaction % 2 == 0) { // buy
                    int buy = -arr[i] + after[transaction + 1];
                    int notBuy = after[transaction];
                    curr[transaction] = Math.max(buy, notBuy);
                } else { // sell
                    int sell = arr[i] + after[transaction + 1];
                    int notSell = after[transaction];
                    curr[transaction] = Math.max(sell, notSell);
                }
            }
            after = curr;
        }

        return after[0];
    }
}
