package com.company.dp.lecs_tuf.T6_subseq_2;

import java.util.Arrays;

public class L41_LongestIncreasingSubseq {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3};
        int[] nums = {0, 1, 0, 3, 2, 3};
        int[] array = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        int[] test = {10,9,2,5,3,7,101,18};
        System.out.println(rec(nums));
    }

    // length of the longest increasing subsequence
    // tc: 2^n
    // sc: o(n)
    public static int rec(int[] arr) {
        return rec(arr, arr.length, arr.length + 1);
    }

    public static int rec(int[] arr, int i, int prevI) {
        if (i == 0) return 0;

        int take = 0;
        if (prevI == arr.length + 1 || arr[i - 1] < arr[prevI - 1]) {
            take = 1 + rec(arr, i - 1, i);
        }
        int notTake = rec(arr, i - 1, prevI);
        return Math.max(take, notTake);
    }


    // tc: n * n
    // sc: n * n + o(n) stack space
    public static int memo(int[] arr) {
        int[][] dp = new int[arr.length + 1][arr.length + 2];
        for (int[] arrays : dp) {
            Arrays.fill(arrays, -1);
        }
        return memo(arr, arr.length, arr.length + 1, dp);
    }

    public static int memo(int[] arr, int i, int prevI, int[][] dp) {
        if (i == 0) return 0;
        if (dp[i][prevI] != -1) return dp[i][prevI];

        int take = 0;
        if (prevI == arr.length + 1 || arr[i - 1] < arr[prevI - 1]) {
            take = 1 + memo(arr, i - 1, i, dp);
        }
        int notTake = memo(arr, i - 1, prevI, dp);
        return dp[i][prevI] = Math.max(take, notTake);
    }


    // my method rec
    static int myMethodRec(int[] arr) {
        return myMethodRec(arr, arr.length, arr.length + 1);
    }

    static int myMethodRec(int[] arr, int i, int prevI) {
        if (i == 0) return 0;
        if (prevI == arr.length + 1 || arr[i - 1] < arr[prevI - 1]) {
            // take or not take
            int take = 1 + myMethodRec(arr, i + 1, i);
            int notTake = myMethodRec(arr, i + 1, prevI);
            return Math.max(take, notTake);
        } else {
            return myMethodRec(arr, i + 1, prevI);
        }
    }

    // my method memo
    public static int myMethodMemo(int[] arr) {
        int[][] dp = new int[arr.length + 1][arr.length + 2];
        for (int[] arrays : dp) {
            Arrays.fill(arrays, -1);
        }
        return myMethodMemo(arr, arr.length, arr.length + 1, dp);
    }

    static int myMethodMemo(int[] arr, int i, int prevIndex, int[][] dp) {
        if (i == 0) return 0;
        if (dp[i][prevIndex] != -1) return dp[i][prevIndex];

        if (prevIndex == arr.length + 1 || arr[i - 1] < arr[prevIndex - 1]) { // take // OR // not take //
            int take = 1 + myMethodMemo(arr, i - 1, i, dp);
            int notTake = myMethodMemo(arr, i - 1, prevIndex, dp);
            return dp[i][prevIndex] = Math.max(take, notTake);
        }
        else { // not take
            return dp[i][prevIndex] = myMethodMemo(arr, i - 1, prevIndex, dp);
        }
    }


    // tc: n * n
    // sc: n * n
    static int tabulation(int[] arr) {
        int[][] dp = new int[arr.length + 1][arr.length + 2];
        for (int i = 1; i <= arr.length; i++) {
            for (int prevIndex = 1; prevIndex <= arr.length + 1; prevIndex++) {
                if (prevIndex == arr.length + 1 || arr[i - 1] < arr[prevIndex - 1]) { // take // OR // not take //
                    int take = 1 + dp[i - 1][i];
                    int notTake = dp[i - 1][prevIndex];
                    dp[i][prevIndex] = Math.max(take, notTake);
                }
                else { // not take
                    dp[i][prevIndex] = dp[i - 1][prevIndex];
                }
            }
        }
        return dp[arr.length][arr.length + 1];
    }

    // tc: n * n
    // sc: n * 2
    static int spaceOpt(int[] arr) {
        int[] prev = new int[arr.length + 2];
        int[] cur = new int[arr.length + 2];
        for (int i = 1; i <= arr.length; i++) {
            for (int prevIndex = 1; prevIndex <= arr.length + 1; prevIndex++) {
                if (prevIndex == arr.length + 1 || arr[i - 1] < arr[prevIndex - 1]) { // take // OR // not take //
                    int take = 1 + prev[i];
                    int notTake = prev[prevIndex];
                    cur[prevIndex] = Math.max(take, notTake);
                }
                else { // not take
                    cur[prevIndex] = prev[prevIndex];
                }
            }
            prev = cur;
        }
        return prev[arr.length + 1];
    }
}


//    public static int wrongRec(int[] arr, int i, int prevI) {
//        if (i == 0) return 0;
//
//        if (prevI == arr.length || arr[i - 1] > arr[prevI - 1]) {
//            // take or not take
//            int take = 1 + wrongRec(arr, i - 1, i);
//            int notTake = wrongRec(arr, i - 1, prevI);
//            return Math.max(take, notTake);
//        } else {
//            // not take
//            return wrongRec(arr, i - 1, prevI);
//        }
//    }