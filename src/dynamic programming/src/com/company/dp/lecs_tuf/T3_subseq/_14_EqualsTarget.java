package com.company.dp.lecs_tuf.T3_subseq;

import java.util.Arrays;

public class _14_EqualsTarget {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1};
        System.out.println(tabulation(1, arr));
    }

    // rec
    // tc : 2^n (n = arr len)
    // sc : n
    public static boolean rec(int k, int[] arr) {
        return rec(k, arr, arr.length - 1);
    }

    public static boolean rec(int target, int[] arr, int index) {
        if (target == 0) return true;
        if (index == 0) return arr[0] == target;

        boolean notTake = rec(target, arr, index - 1);
        boolean take = false;
        if (target - arr[index] >= 0) {
            take = rec(target - arr[index], arr, index - 1);
        }
        return take | notTake;
    }

    // memo
    // tc : n * target
    // sc : n * target  +  n
    public static boolean memo(int k, int[] arr) {
        int[][] dp = new int[arr.length][k + 1];
        for (int[] nums : dp) {
            Arrays.fill(nums, -1);
        }
        return memo(k, arr, arr.length - 1, dp);
    }

    public static boolean memo(int target, int[] arr, int index, int[][] dp) {
        if (target == 0) return true;
        if (index == 0) return arr[0] == target;

        if (dp[index][target] != -1) return dp[index][target] == 1;

        boolean notTake = memo(target, arr, index - 1, dp);
        boolean take = false;
        if (target - arr[index] >= 0) {
            take = memo(target - arr[index], arr, index - 1, dp);
        }
        dp[index][target] = take | notTake ? 1 : 0;
        return take | notTake;
    }

    // tabulation
    // tc : n * target
    // sc : n * target
    static boolean tabulation(int k, int[] arr) {
        // NOTE : dp array is of index (rows) and k (cols)
        boolean[][] dp = new boolean[arr.length][k + 1];
        // if target == 0 then true
        // ie konsa bhi index ho, agar target = 0 then null set banega and [i][0] is always true therefore!
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }
        // if index == 0 return arr[0] == target
        if (arr[0] <= k) dp[0][arr[0]] = true;

        for (int ind = 1; ind < dp.length; ind++) {
            for (int target = 1; target < dp[ind].length; target++) {
                boolean notTake = dp[ind - 1][target];
                boolean take = false;
                if (target - arr[ind] >= 0) {
                    take = dp[ind - 1][target - arr[ind]];
                }
                dp[ind][target] = take | notTake;
            }
        }
        for (boolean[] booleans : dp) {
            System.out.println(Arrays.toString(booleans));
        }
        return dp[arr.length - 1][k];
    }

    // spaceOpt
    // tc : n * target
    // sc : target
    static boolean spaceOpt(int k, int[] arr) {
        boolean[] dp = new boolean[k + 1];
        // if target == 0 then true
            dp[0] = true;

        // if index == 0 return arr[0] == target
        if (arr[0] <= k) dp[arr[0]] = true;

        for (int ind = 1; ind < arr.length; ind++) {
            boolean[] temp = new boolean[k + 1];
            temp[0] = true;
            for (int target = 1; target < dp.length; target++) {

                boolean notTake = dp[target];
                boolean take = false;
                if (target - arr[ind] >= 0) {
                    take = dp[target - arr[ind]];
                }
                temp[target] = take | notTake;
            }
            dp = temp;
        }
        return dp[k];
    }
}
