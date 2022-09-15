package com.company.dp.lecs_tuf.T2_twoD_arr_questions;

import java.util.Arrays;

public class _10_MinPathSum {
    // https://leetcode.com/problems/minimum-path-sum/

    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(arr));
        System.out.println(memo(arr));
    }

    // recursion
    public static int minPathSum(int[][] grid) {
        int rl = grid.length;
        int cl = grid[0].length;
        return path(rl - 1, cl - 1, grid);
    }

    // vvimp point:- question tells to go from 0,0 to m-1,n-1
    // But, we are going from m-1,n-1 so arr[r][c] does not start with arr[0][0]
    // keep this in mind while doing dry run
    private static int path(int r, int c, int[][] arr) {
        if (r == 0 && c == 0) {
            return arr[0][0];
        }

        if (r < 0 || c < 0) {
            return Integer.MAX_VALUE;
        }
/*
        int up = arr[r][c] + path(r - 1, c, arr);
        int left = arr[r][c] + path(r, c - 1, arr);
        can't do like this cause int.max gets added and makes them negative(overflow)
        giving wrong output
*/
        int up = path(r - 1, c, arr);
        int left = path(r, c - 1, arr);

        return arr[r][c] + Math.min(up, left);
    }

    // memo
    static int memo(int[][] arr) {
        int rl = arr.length;
        int cl = arr[0].length;
        int[][] dp = new int[rl][cl];
        for (int[] nums : dp) {
            Arrays.fill(nums, -1);
        }
        return memo(rl - 1, cl - 1, arr, dp);
    }

    private static int memo(int r, int c, int[][] arr, int[][] dp) {
        if (r == 0 && c == 0) {
            return arr[0][0];
        }

        if (r < 0 || c < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[r][c] != -1) return dp[r][c];

        int up = memo(r - 1, c, arr, dp);
        int left = memo(r, c - 1, arr, dp);

        return dp[r][c] = arr[r][c] + Math.min(up, left);
    }

    // tabulation
    static int tabulation(int[][] arr) {
        int rl = arr.length;
        int cl = arr[0].length;
        int[][] dp = new int[rl][cl];

        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = arr[0][0];
                } else {
                    // base cases of i < 0 and j < 0 in that memo and rec approaches
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if (i > 0) {
                        up = dp[i - 1][j];
                    }
                    if (j > 0) {
                        left = dp[i][j - 1];
                    }
                    dp[i][j] = arr[i][j] + Math.min(up, left);
                }
            }
        }
        return dp[rl - 1][cl - 1];
    }
}
