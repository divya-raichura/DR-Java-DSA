package com.company.dp.lecs_tuf.oneD_arr_questions;

import java.util.Arrays;

public class _13_CherryPick {
    public static void main(String[] args) {
        int[][] arr = {
                {2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}
        };

        System.out.println(rec(arr));
    }

    // can't do individually because we want to omit common cells

    // tc : o(3^n * 3^n) cause both have 3 options for each cell and there are n rows
    // sc : no of rows (aux stack space)
    static int rec(int[][] arr) {
        int rl = arr.length;
        int cl = arr[0].length;
        return rec(arr, 0, 0, cl - 1);
    }

    static int rec(int[][] arr, int r, int c1, int c2) {
        if (c1 < 0 || c1 >= arr[0].length || c2 < 0 || c2 >= arr[0].length) { // note : don't forget that
            // column length = arr[0].length not arr.length
            return Integer.MIN_VALUE;
        }

        if (r == arr.length - 1) {
            if (c1 == c2) {
                return arr[r][c1];
            }
            return arr[r][c1] + arr[r][c2];
        }

        int max = Integer.MIN_VALUE;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int ans = rec(arr, r + 1, c1 + i, c2 + j);
                max = Math.max(ans, max);
            }
        }

        if (c1 == c2) return arr[r][c1] + max;
        else return arr[r][c1] + arr[r][c2] + max;
    }

    // tc : o(n * m * m) * 9 (9 cause for every state we have 9 combos -> nested for loops)
    // sc : o(n * m * m) + o(n) -> (dp + stack space)
    static int memo(int[][] arr) {
        int rl = arr.length;
        int cl = arr[0].length;
        int[][][] dp = new int[rl][cl][cl];
        for(int[][] nums1 : dp) {
            for (int[] nums2 : nums1) {
                Arrays.fill(nums2, -1);
            }
        }
        return memo(arr, 0, 0, cl - 1, dp);
    }

    static int memo(int[][] arr, int r, int c1, int c2, int[][][] dp) {
        if (c1 < 0 || c1 >= arr[0].length || c2 < 0 || c2 >= arr[0].length) {
            return Integer.MIN_VALUE;
        }

        if (r == arr.length - 1) {
            if (c1 == c2) {
                return arr[r][c1];
            }
            return arr[r][c1] + arr[r][c2];
        }

        if (dp[r][c1][c2] != -1) return dp[r][c1][c2];

        int max = Integer.MIN_VALUE;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int ans = memo(arr, r + 1, c1 + i, c2 + j, dp);
                max = Math.max(ans, max);
            }
        }

        if (c1 == c2) return dp[r][c1][c2] = arr[r][c1] + max;
        else return dp[r][c1][c2] = arr[r][c1] + arr[r][c2] + max;
    }
}
