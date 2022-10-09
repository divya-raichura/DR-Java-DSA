package com.company.dp.lecs_tuf.T7_partition;

import java.util.Arrays;

public class L51_Balloons {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 8};
        System.out.println(rec(arr));
        System.out.println(memo(arr));
    }

    public static int rec(int[] arr) {
        int[] temp = new int[arr.length + 2];
        for (int i = 1; i <= temp.length - 2; i++) {
            temp[i] = arr[i - 1];
        }
        arr = temp;
        arr[0] = 1;
        arr[arr.length - 1] = 1;
        return rec(arr, 1, arr.length - 2);
    }

    public static int rec(int[] arr, int i, int j) {
        if (i > j) return 0;

        int max = Integer.MIN_VALUE;

        for (int k = i; k <= j; k++) {
            int points = (arr[i - 1] * arr[k] * arr[j + 1])
                        + rec(arr, i, k - 1)
                        + rec(arr, k + 1, j);

            max = Math.max(max, points);
        }
        return max;
    }

    public static int memo(int[] arr) {
        int n = arr.length;
        int[] temp = new int[arr.length + 2];
        for (int i = 1; i <= temp.length - 2; i++) {
            temp[i] = arr[i - 1];
        }
        arr = temp;
        arr[0] = 1;
        arr[arr.length - 1] = 1;

        int[][] dp = new int[n + 1][n + 1];
        for(int[] array : dp) Arrays.fill(array, -1);
        return memo(arr, 1, arr.length - 2, dp);
    }

    public static int memo(int[] arr, int i, int j, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int max = Integer.MIN_VALUE;

        for (int k = i; k <= j; k++) {
            int points = (arr[i - 1] * arr[k] * arr[j + 1])
                        + memo(arr, i, k - 1, dp)
                        + memo(arr, k + 1, j, dp);

            max = Math.max(max, points);
        }
        return dp[i][j] = max;
    }
}
