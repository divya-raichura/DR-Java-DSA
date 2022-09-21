package com.company.dp.lecs_tuf.T3_subseq;

import java.util.Arrays;

public class L22_Coin2 {
    public static void main(String[] args) {

    }

    static int tabulation(int[] arr, int tar) {
        int[][] dp = new int[arr.length][tar + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (j == 0) dp[i][j] = 1;
                if (i == 0 && j % arr[0] == 0) {
                    dp[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;
                if (j - arr[i] >= 0) {
                    take = dp[i][j - arr[i]];
                }
                dp[i][j] = take + notTake;
            }
        }
        return dp[dp.length - 1][tar];
    }

    static int spaceOpt(int[] arr, int tar) {

        int[] prev = new int[tar + 1];

        for (int j = 0; j < tar + 1; j++) {
            if (j % arr[0] == 0) {
                prev[j] = 1;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            int[] curr = new int[tar + 1];
            curr[0] = 1;
            for (int j = 1; j < tar + 1; j++) {
                int notTake = prev[j];
                int take = 0;
                if (j - arr[i] >= 0) {
                    take = curr[j - arr[i]];
                }
                curr[j] = take + notTake;
            }
            prev = curr;
        }
        return prev[tar];
    }

    public int memo(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] nums : dp) {
            Arrays.fill(nums, -1);
        }
        return memo(coins, coins.length - 1, amount, dp);
    }

    public int memo(int[] arr, int i, int tar, int[][] dp) {
        if (tar == 0) return 1;
        if (i == 0) {
            if (tar % arr[0] == 0) return 1;
            return 0;
        }
        if (dp[i][tar] != -1) return dp[i][tar];
        int notTake = memo(arr, i - 1, tar, dp);
        int take = 0;
        if (tar - arr[i] >= 0) {
            take = memo(arr, i, tar - arr[i], dp);
        }
        return dp[i][tar] = take + notTake;
    }
}
