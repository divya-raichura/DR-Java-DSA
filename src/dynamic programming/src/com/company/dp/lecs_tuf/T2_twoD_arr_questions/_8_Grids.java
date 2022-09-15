package com.company.dp.lecs_tuf.T2_twoD_arr_questions;

import java.util.Arrays;

public class _8_Grids {
    public static void main(String[] args) {

        System.out.println(recursion(3 - 1, 2 - 1));
        System.out.println(memo(3 - 1, 3 - 1));
        System.out.println(tab(3 - 1, 3 - 1));
        System.out.println(spaceOpt2d(3 - 1, 3 - 1));
        System.out.println(spaceOpt1d(3 - 1, 3 - 1));
    }

    // recursion
    // tc : o(2^mn)
    // sc : o(col len + row len) ie : {n+m} because I am going only till last
    // of row/col
    static int recursion(int r, int c) {
        if (r == 0 || c == 0) {
            return 1;
        }

        int down = recursion(r - 1, c);
        int right = recursion(r, c - 1);

        return down + right;
    }

    // memo
    // tc : o(m * n) cause we can have these many calls at max
    // sc : o(col len + row len){n+m} + o(n * m) {for dp array}
    static int memo(int r, int c) {
        int[][] dp = new int[r + 1][c + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        int ans = path(r, c, dp);

        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
        return ans;
    }

    static int path(int r, int c, int[][] dp) {
        if (r == 0 || c == 0) {
            return 1;
        }

        if (dp[r][c] != -1) return dp[r][c];

        int down = path(r - 1, c, dp);
        int right = path(r, c - 1, dp);

        return dp[r][c] = down + right;
    }

    // tabulation
    // complexities same as above but stack space (row + col) gets removed
    static int tab(int r, int c) {
        int[][] dp = new int[r + 1][c + 1]; // note that r+1=m and c+1=n
        // cause args in tab are passed after doing r-1 and c+1

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                }
            }
        }

        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[row].length; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }

        return dp[r][c];
    }

    // space optimisation, much better can be achieved by using 1d arr
    static int spaceOpt2d(int r, int c) {
        int[] rowArr = new int[r + 1];
        int[] colArr = new int[c + 1];

        Arrays.fill(rowArr, 1);
        Arrays.fill(colArr, 1);

        for (int rows = 1; rows < rowArr.length; rows++) {
            for (int cols = 1; cols < colArr.length; cols++) {
                int ans = rowArr[rows] + colArr[cols];
                rowArr[rows] = ans;
                colArr[cols] = ans;
            }
        }

        return rowArr[rowArr.length - 1];
    }

    static int spaceOpt1d(int r, int c) {
        int[] dp = new int[c + 1];
        Arrays.fill(dp, 1);

        for (int rows = 1; rows < r + 1; rows++) {
            for (int cols = 0; cols < c + 1; cols++) {
                int left = 0;
                int up = dp[cols];
                if (cols > 0) left = dp[cols - 1];
                dp[cols] = left + up;
            }
        }

        return dp[c];
    }
}
