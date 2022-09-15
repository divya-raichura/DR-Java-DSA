package com.company.dp.lecs_tuf.T2_twoD_arr_questions;

import java.util.Arrays;

public class _12_MinFalling {
    //    https://leetcode.com/problems/minimum-falling-path-sum/
    public static void main(String[] args) {
        int[][] arr = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };

        System.out.println(rec(arr));
        System.out.println(memo(arr));
        System.out.println(tabulation(arr));
    }

    // recursion
    // for every cell, we are exploring 3 paths
    // tc : 3^n exponential in nature
    // sc : recursion stack space -> no of rows
    static int rec(int[][] arr) {
        int rl = arr.length;
        int cl = arr[0].length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < rl; i++) {
            min = Math.min(min, rec(arr, rl - 1, i));
        }
        return min;
    }

    static int rec(int[][] arr, int r, int c) {
        if (c < 0 || c >= arr.length) return Integer.MAX_VALUE;

        if (r == 0) return arr[r][c];


        int left = rec(arr, r - 1, c - 1);
        int mid = rec(arr, r - 1, c);
        int right = rec(arr, r - 1, c + 1);

        return arr[r][c] + Math.min(mid, Math.min(left, right));
    }

    // memo
    // tc : n * m
    // sc : no of rows for stack space + n * m for dp array
    static int memo(int[][] arr) {
        int rl = arr.length;
        int cl = arr[0].length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[rl][cl];
        for (int[] nums : dp) {
            Arrays.fill(nums, -1);
        }
        for (int i = 0; i < rl; i++) {
            min = Math.min(min, memo(arr, rl - 1, i, dp));
        }
        return min;
    }

    static int memo(int[][] arr, int r, int c, int[][] dp) {
        if (c < 0 || c >= arr.length) return Integer.MAX_VALUE;
        if (r == 0) {
            return arr[r][c];
        }

        if (dp[r][c] != -1) return dp[r][c];

        int left = memo(arr, r - 1, c - 1, dp);
        int mid = memo(arr, r - 1, c, dp);
        int right = memo(arr, r - 1, c + 1, dp);

        return dp[r][c] = arr[r][c] + Math.min(mid, Math.min(left, right));
    }

    // tabulation
    // tc : n*m
    // sc : n*m
    static int tabulation(int[][] arr) {
        int rl = arr.length;
        int cl = arr[0].length;
        int[][] dp = new int[rl][cl];
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (i == 0) {
                    dp[0][j] = arr[0][j];
                } else {
                    int left = Integer.MAX_VALUE;
                    int mid = arr[i][j] + dp[i - 1][j];
                    int right = Integer.MAX_VALUE;
                    if (j > 0) left = arr[i][j] + dp[i - 1][j - 1];
                    if (j < cl - 1) right = arr[i][j] + dp[i - 1][j + 1];
                    dp[i][j] = Math.min(mid, Math.min(left, right));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            min = Math.min(min, dp[dp.length - 1][i]);
        }
        return min;
    }

    // space optimization
    static int spaceOpt(int[][] arr) {
        int[] dp = new int[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == 0) {
                    dp[j] = arr[0][j];
                } else {
                    int left = Integer.MAX_VALUE;
                    int mid = arr[i][j] + dp[j];
                    int right = Integer.MAX_VALUE;
                    if (j > 0) left = arr[i][j] + dp[j - 1];
                    if (j < arr[0].length - 1) right = arr[i][j] + dp[j + 1];
                    dp[j] = Math.min(mid, Math.min(left, right));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j : dp) {
            min = Math.min(min, j);
        }
        return min;
    }
}
