package com.company.dp.lecs_tuf.T1__oneD_arr_questions;

import java.util.Arrays;

public class L3_FrogJump {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 10};
        int[] arr2 = {30, 10, 60, 10, 60, 50};
        int n = arr.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        // recursion
        System.out.println(jump(0, arr));

        // memo
        System.out.println(jumpMemo(0, arr, dp));

        // lecture solution
        // recursion
        System.out.println(jumpSolution(n - 1, arr));

        // memo
        int[] dpArr = new int[n + 1];
        Arrays.fill(dpArr, -1);
        System.out.println(jumpSolutionMemo(n - 1, arr, dpArr));

        // tabulation
        System.out.println(jumpSolTab(arr, n));

        // space optimised
        System.out.println(jumpSolTabSpaceOptimization(arr, n));
    }

    // solution (note : there are many approaches)
    static int jumpSolution(int i, int[] arr) {

        if(i == 0) return 0;

        int lhs = jumpSolution(i - 1, arr) + Math.abs(arr[i] - arr[i - 1]);

        int rhs = Integer.MAX_VALUE;
        if(i > 1) rhs = jumpSolution(i - 2, arr) + Math.abs(arr[i] - arr[i - 2]);

        return Math.min(lhs, rhs);
    }

    // solution (note : there are many approaches)
    static int jumpSolutionMemo(int i, int[] arr, int[] dp) {

        if(i == 0) return 0;

        if(dp[i] != -1) return dp[i];

        int lhs = jumpSolutionMemo(i - 1, arr, dp) + Math.abs(arr[i] - arr[i - 1]);

        int rhs = Integer.MAX_VALUE;
        if(i > 1) rhs = jumpSolutionMemo(i - 2, arr, dp) + Math.abs(arr[i] - arr[i - 2]);

        return dp[i] = Math.min(lhs, rhs);
    }

    static int jumpSolTab(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int l = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            int r = Integer.MAX_VALUE;
            if(i > 1) {
                r = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            }
            dp[i] = Math.min(l, r);
        }
        return dp[dp.length - 1];
        // or
//        return dp[n - 1];
    }

    // space optimised correct solution
    static int jumpSolTabSpaceOptimization(int[] arr, int n) {
        int prev2 = Integer.MAX_VALUE;
        int prev = 0;
        for (int i = 1; i < n; i++) {
            int l = prev + Math.abs(arr[i] - arr[i - 1]);
            int r = Integer.MAX_VALUE;
            if(i > 1) {
                r = prev2 + Math.abs(arr[i] - arr[i - 2]);
            }

            int ans = Math.min(l, r);
            prev2 = prev;
            prev = ans;
        }
        return prev;
    }


    // my try
    static int jumpMemo(int index, int[] arr, int[] dp) {

        if (index >= arr.length) {
            return Integer.MAX_VALUE;
        }

        int jump1 = Integer.MAX_VALUE;
        int jump2 = Integer.MAX_VALUE;
        int lhs = Integer.MAX_VALUE;
        int rhs = Integer.MAX_VALUE;

        if (index + 1 < arr.length) {
            jump1 = Math.abs(arr[index] - arr[index + 1]);

            if(dp[index + 1] != -1) {
                lhs = dp[index + 1];
            } else {
                lhs = jumpMemo(index + 1, arr, dp);
            }
        }

        if (index + 2 < arr.length) {
            jump2 = Math.abs(arr[index] - arr[index + 2]);

            if(dp[index + 2] != -1) {
                rhs = dp[index + 2];
            } else {
                rhs = jumpMemo(index + 2, arr, dp);
            }
        }

        if (lhs != Integer.MAX_VALUE) {
            jump1 += lhs;
            dp[index + 1] = lhs;
        }
        if (rhs != Integer.MAX_VALUE) {
            jump2 += rhs;
            dp[index + 2] = rhs;
        }

        return Math.min(jump1, jump2);
    }

    // my try
    static int jump(int index, int[] arr) {

        if (index >= arr.length) {
            return Integer.MAX_VALUE;
        }

        int jump1 = Integer.MAX_VALUE;
        int jump2 = Integer.MAX_VALUE;
        if (index + 1 < arr.length) {
            jump1 = Math.abs(arr[index] - arr[index + 1]);
        }

        if (index + 2 < arr.length) {
            jump2 = Math.abs(arr[index] - arr[index + 2]);
        }

        int lhs = jump(index + 1, arr);
        int rhs = jump(index + 2, arr);

        if (lhs != Integer.MAX_VALUE) jump1 += lhs;
        if (rhs != Integer.MAX_VALUE) jump2 += rhs;

        return Math.min(jump1, jump2);
    }

}
