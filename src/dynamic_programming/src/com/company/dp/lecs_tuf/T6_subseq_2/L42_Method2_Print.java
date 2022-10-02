package com.company.dp.lecs_tuf.T6_subseq_2;

import java.util.Arrays;

public class L42_Method2_Print {
    public static void main(String[] args) {
        int[] arr = {5, 4, 11, 1, 16, 8};
        printLIS(arr);
    }

    // tc: n * n
    // sc: n
    static int tabulation(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    static void printLIS(int[] arr) {
        int[] dp = new int[arr.length];
        int[] hash = new int[arr.length];
        for (int i = 0; i < hash.length; i++) hash[i] = i;
        Arrays.fill(dp, 1);
        int maxLenIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && (1 + dp[j] > dp[i])) {
                    hash[i] = j;
                    dp[i] = 1 + dp[j];
                }
            }
            if (dp[maxLenIndex] < dp[i]) {
                maxLenIndex = i;
            }
        }

        int len = dp[maxLenIndex];
        int[] ans = new int[len];
        while (len > 0) {
            ans[len - 1] = arr[maxLenIndex];
            maxLenIndex = hash[maxLenIndex];
            len--;
        }
        System.out.println(Arrays.toString(ans));
    }
}
