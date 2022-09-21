package com.company.dp.lecs_tuf.T2_twoD_arr_questions;

import java.util.Arrays;

public class L9_GridObstacle {
    public static void main(String[] args) {

    }

    // recursion
    public static int rec(int[][] arr) {
        int rl = arr.length;
        int cl = arr[0].length;

        return rec(arr, rl - 1, cl - 1);
    }

    private static int rec(int[][] arr, int r, int c) {
        if (r < 0 || c < 0) return 0;
        if (arr[r][c] == 1) return 0;
        if (r == 0 && c == 0) return 1;

        int right = rec(arr, r, c - 1);
        int down = rec(arr, r - 1, c);

        return right + down;
    }

    // memo
    public static int memo(int[][] arr) {
        int rl = arr.length;
        int cl = arr[0].length;

        int[][] dp = new int[rl][cl];
        for (int[] nums : dp) {
            Arrays.fill(nums, -1);
        }

        return memo(arr, rl - 1, cl - 1, dp);
    }

    private static int memo(int[][] arr, int r, int c, int[][] dp) {
        if (r < 0 || c < 0) return 0;
        if (arr[r][c] == 1) return 0;
        if (r == 0 && c == 0) return 1;

        if (dp[r][c] != -1) return dp[r][c];

        int right = memo(arr, r, c - 1, dp);
        int down = memo(arr, r - 1, c, dp);

        return dp[r][c] = right + down;
    }

    // tabulation
    private static int tabulation(int[][] arr) {
        int rl = arr.length;
        int cl = arr[0].length;
        int[][] dp = new int[rl][cl];

        for (int row = 0; row < rl; row++) {
            for (int col = 0; col < cl; col++) {
                if (arr[row][col] != 1) {
                    if (row == 0 && col ==0) {
                        dp[row][col] = 1;
                    }
                    else {
                        int right = 0;
                        int down = 0;
                        if (col > 0) {
                            right += dp[row][col - 1];
                        }
                        if (row > 0) {
                            down += dp[row - 1][col];
                        }
                        int ans = right + down;
                        dp[row][col] = ans;
                    }
                }
            }
        }
        return dp[rl - 1][cl - 1];
    }

    // space optimisation
    public int spaceOpt(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }
}
