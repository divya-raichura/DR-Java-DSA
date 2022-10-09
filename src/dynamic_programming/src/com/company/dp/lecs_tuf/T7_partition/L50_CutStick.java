package com.company.dp.lecs_tuf.T7_partition;

import java.util.Arrays;

public class L50_CutStick {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5};
        int[] arr2 = {5,6,1,4,2};
        System.out.println(rec(9, arr2));
    }

    public static int rec(int n, int[] cuts) {
        int[] newCuts = new int[cuts.length + 2];
        for (int i = 1; i <= newCuts.length - 2; i++) {
            newCuts[i] = cuts[i - 1];
        }
        newCuts[0] = 0;
        newCuts[newCuts.length - 1] = n;
        Arrays.sort(newCuts);
        return rec(newCuts, 1, newCuts.length - 2);
    }

    public static int rec(int[] cuts, int i, int j) {
        if (i > j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = cuts[j + 1] - cuts[i - 1]
                    + rec(cuts, i, k - 1)
                    + rec(cuts, k + 1, j);

            min = Math.min(min, cost);
        }
        return min;
    }

    public static int memo(int n, int[] cuts) {
        int[] newCuts = new int[cuts.length + 2];
        for (int i = 1; i <= newCuts.length - 2; i++) {
            newCuts[i] = cuts[i - 1];
        }
        newCuts[0] = 0;
        newCuts[newCuts.length - 1] = n;
        Arrays.sort(newCuts);

        int[][] dp = new int[newCuts.length][newCuts.length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return memo(newCuts, 1, newCuts.length - 2, dp);
    }

    public static int memo(int[] cuts, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = cuts[j + 1] - cuts[i - 1]
                    + memo(cuts, i, k - 1, dp)
                    + memo(cuts, k + 1, j, dp);

            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }
}
