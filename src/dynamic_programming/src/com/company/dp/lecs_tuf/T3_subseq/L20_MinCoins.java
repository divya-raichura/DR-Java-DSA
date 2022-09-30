package com.company.dp.lecs_tuf.T3_subseq;

import java.util.Arrays;

public class L20_MinCoins {
    public static void main(String[] args) {

    }

    // rec
    public int rec(int[] coins, int amount) {
        int ans = rec(coins, coins.length - 1, amount);
        if (ans == Integer.MAX_VALUE) return -1;
        else return ans;
    }

    public int rec(int[] arr, int i, int tar) {
//        if (tar == 0) return 0;
        if (i == 0) {
            if (tar % arr[0] == 0) return tar / arr[0];
            return Integer.MAX_VALUE;
        }

        int notTake = rec(arr, i - 1, tar);
        int take = Integer.MAX_VALUE;
        if (tar - arr[i] >= 0) {
            take = rec(arr, i, tar - arr[i]);
            if (take != Integer.MAX_VALUE) take += 1;
        }
        return Math.min(take, notTake);
    }

    // memo
    public int memo(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int ans = memo(coins, coins.length - 1, amount, dp);
        if (ans == Integer.MAX_VALUE) return -1;
        else return ans;
    }

    public int memo(int[] arr, int i, int tar, int[][] dp) {
//        if (tar == 0) return 0;
        if (i == 0) {
            if (tar % arr[0] == 0) return tar / arr[0];
            return Integer.MAX_VALUE;
        }

        if (dp[i][tar] != -1) return dp[i][tar];

        int notTake = memo(arr, i - 1, tar, dp);
        int take = Integer.MAX_VALUE;
        if (tar - arr[i] >= 0) {
            take = memo(arr, i, tar - arr[i], dp);
            if (take != Integer.MAX_VALUE) take += 1;
        }
        return dp[i][tar] = Math.min(take, notTake);
    }

    // tabulation
    static int tabulation(int[] arr, int tar) {
        int[][] dp = new int[arr.length][tar + 1];

        for (int i = 0; i < tar + 1; i++) {
            if (i % arr[0] == 0) {
                dp[0][i] = i / arr[0];
            } else {
                dp[0][i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < tar + 1; j++) {
                int notTake = dp[i - 1][j];
                int take = Integer.MAX_VALUE;
                if (j - arr[i] >= 0) {
                    take = dp[i][j - arr[i]];
                    if (take != Integer.MAX_VALUE) take += 1;
                }
                dp[i][j] = Math.min(take, notTake);
            }
        }
        int ans = dp[dp.length - 1][tar];
        if(ans == Integer.MAX_VALUE) return -1;
        else return ans;
    }

    static int spaceOpt(int[] arr, int tar) {
        int[] prev = new int[tar + 1];
        int[] curr = new int[tar + 1];

        for (int i = 0; i < tar + 1; i++) {
            if (i % arr[0] == 0) {
                prev[i] = i / arr[0];
            } else {
                prev[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < tar + 1; j++) {
                int notTake = prev[j];
                int take = Integer.MAX_VALUE;
                if (j - arr[i] >= 0) {
                    take = curr[j - arr[i]];
                    if (take != Integer.MAX_VALUE) take += 1;
                }
                curr[j] = Math.min(take, notTake);
            }
            prev = curr;
        }
        int ans = prev[tar];
        if(ans == Integer.MAX_VALUE) return -1;
        else return ans;
    }

    static int spaceOpt1DArray(int[] arr, int tar) {
        int[] prev = new int[tar + 1];

        for (int i = 0; i < tar + 1; i++) {
            if (i % arr[0] == 0) {
                prev[i] = i / arr[0];
            } else {
                prev[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < tar + 1; j++) {
                int notTake = prev[j];
                int take = Integer.MAX_VALUE;
                if (j - arr[i] >= 0) {
                    take = prev[j - arr[i]];
                    if (take != Integer.MAX_VALUE) take += 1;
                }
                prev[j] = Math.min(take, notTake);
            }
        }
        int ans = prev[tar];
        if(ans == Integer.MAX_VALUE) return -1;
        else return ans;
    }

}
