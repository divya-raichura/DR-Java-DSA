package com.company.dp.lecs_tuf.T1__oneD_arr_questions;

import java.util.Arrays;

public class _4_FrogJump {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 10};
        int[] arr2 = {30, 10, 60, 10, 60, 50};
        int n = arr.length;
        int k = 1;

        // recursion
        System.out.println(jump(arr, n - 1, k));

        // memo
        int[] dp = new int[n + 1]; // n or arr.length
        Arrays.fill(dp, -1);
        System.out.println(jumpMemo(arr, dp, n - 1, k));
        System.out.println(Arrays.toString(dp));

        // tabulation
        System.out.println(tabulation(arr, k));
    }

    static int tabulation(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i >= j) { // i - j >= 0
                    int ans = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    min = Math.min(ans, min);
                } else {
                    break;
                }
            }
            dp[i] = min;
        }

        return dp[arr.length - 1];
    }

    static int jumpMemo(int[] arr, int[] dp, int i, int k) {
        if(i == 0) return 0;

        if(dp[i] != -1) return dp[i];

        int min = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {
            if(i >= j) {
                int ans = jumpMemo(arr, dp, i - j, k) + Math.abs(arr[i] - arr[i - j]);
                min = Math.min(min, ans);
            } else {
                break;
            }
        }

        return dp[i] = min;
    }

    static int jump(int[] arr, int i, int k) {
        if(i == 0) return 0;

        int min = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {
            if(i >= j) {
                int ans = jump(arr, i - j, k) + Math.abs(arr[i] - arr[i - j]);
                min = Math.min(min, ans);
            } else {
                break;
            }
        }

        return min;
    }
}
