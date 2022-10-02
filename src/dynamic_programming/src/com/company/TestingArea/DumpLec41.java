package com.company.TestingArea;

public class DumpLec41 {
    /*
    public static int rec(int[] arr) {
        return rec(arr, arr.length, Integer.MAX_VALUE);
    }

    static int rec(int[] arr, int i, int prev) {
        if (i == 0) return 0;

        if (arr[i - 1] < prev) { // take // OR // not take //
            int take = 1 + rec(arr, i - 1, arr[i - 1]);
            int notTake = rec(arr, i - 1, prev);

            return Math.max(take, notTake);
        } else { // not take

            return rec(arr, i - 1, prev);
        }
    }

    public static int memo(int[] arr) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for (int[] arrays : dp) {
            Arrays.fill(arrays, -1);
        }
        return memo(arr, arr.length, arr.length, dp);
    }

    static int memo(int[] arr, int i, int prevIndex, int[][] dp) {
        if (i == 0) return 0;
        if (dp[i][prevIndex] != -1) return dp[i][prevIndex];

//        if ((i == arr.length && prevIndex == arr.length) || arr[i - 1] < arr[prevIndex - 1]) { // take // OR // not take //
//            int take = 1 + memo(arr, i - 1, i, dp);
//            int notTake = memo(arr, i - 1, prevIndex, dp);
//            return dp[i][prevIndex] = Math.max(take, notTake);
//        }
//        else { // not take
//            return dp[i][prevIndex] = memo(arr, i - 1, prevIndex, dp);
//        }
    }
     */
}
