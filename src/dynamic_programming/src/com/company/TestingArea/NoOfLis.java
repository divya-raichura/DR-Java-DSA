package com.company.TestingArea;

import java.util.Arrays;

public class NoOfLis {
    public static int ans(int[] arr) {
        int[] dp = new int[arr.length];
        int[] dp2 = new int[arr.length];
        Arrays.fill(dp, 1);
        Arrays.fill(dp2, 1);
        int max = 1;
        int max2 = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && 1 + dp2[j] > dp2[i]) {
                    dp2[i] = 1 + dp2[j];
                } else if (arr[i] > arr[j] && 1 + dp2[j] == dp2[i] && dp2[i] == max) {
                    count++;
                }
            }
            if (max2 <= dp2[i]) {
                max2 = dp2[i];
                if (max == max2) count++;
            }
        }
        System.out.println("dp1 : " + Arrays.toString(dp));
        System.out.println("dp2 : " + Arrays.toString(dp2));
        return count;
    }
}
