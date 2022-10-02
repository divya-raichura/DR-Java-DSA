package com.company.dp.lecs_tuf.T6_subseq_2;

import java.util.Arrays;

public class L47_NoOfLIS {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 2};

    }
    // https://leetcode.com/problems/number-of-longest-increasing-subsequence/https://leetcode.com/problems/number-of-longest-increasing-subsequence/

    static int finalAns(int[] arr) {
        int[] dp = new int[arr.length];
        int[] count = new int[arr.length];
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[i] < 1 + dp[j]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i]+=count[j];
                    }
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dp[i] == max) {
                res += count[i];
            }
        }
        return res;
    }

    // my try but wrong :(
    // testcases for which it is wrong : {1,1,1,2,2,2,3,3,3}
    static int ans(int[] arr) {
        int[] dp = new int[arr.length];
        int[] count = new int[arr.length];
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[i] < 1 + dp[j]) {
                        dp[i] = dp[j] + 1;
                    } else if (dp[i] == dp[j] + 1) {
                        count[i]++;
                    }
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dp[i] == max) {
                res += count[i];
            }
        }
        return res;
    }
}
