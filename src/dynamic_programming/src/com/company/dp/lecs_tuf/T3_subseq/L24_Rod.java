package com.company.dp.lecs_tuf.T3_subseq;

public class L24_Rod {
    public static void main(String[] args) {

    }

    static int rec(int[] arr, int l, int i) {
        if (i == 0) {
            // at i == 0 and l > 0 means the rod needs to be cut
            // in pieces of length = 1 till l == 0
            // so the price will be price of rod of length 1 * l remaining
            return l * arr[0];
        }
        int notTake = rec(arr, l, i - 1);
        int take = Integer.MIN_VALUE;
        int len = i + 1;
        if (len <= l) {
            take = rec(arr, l - len, i) + arr[i];
        }
        return Math.max(notTake, take);
    }

    static int tabulation(int[] arr, int tar) {
        int[][] dp = new int[arr.length][tar + 1];
        for (int j = 0; j < tar + 1; j++) {
            dp[0][j] = j * arr[0];
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < tar + 1; j++) {
                int notTake = dp[i - 1][j];
                int take = Integer.MIN_VALUE;
                int len = i + 1;
                if (len <= j) {
                    take = dp[i][j - len] + arr[i];
                }
                dp[i][j] = Math.max(notTake, take);
            }
        }
        return dp[dp.length - 1][tar];
    }

    static int spaceOpt(int[] arr, int tar) {
        int[] prev = new int[tar + 1];
        for (int j = 0; j < tar + 1; j++) {
            prev[j] = j * arr[0];
        }
        for (int i = 1; i < arr.length; i++) {
            int[] curr = new int[tar + 1];
            for (int j = 0; j < tar + 1; j++) {
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;
                int len = i + 1;
                if (len <= j) {
                    take = curr[j - len] + arr[i];
                }
                curr[j] = Math.max(notTake, take);
            }
        }
        return prev[tar];
    }

    static int spaceOpt1DArr(int[] arr, int tar) {
        int[] dp = new int[tar + 1];
        for (int j = 0; j < tar + 1; j++) {
            dp[j] = j * arr[0];
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < tar + 1; j++) {
                int notTake = dp[j];
                int take = Integer.MIN_VALUE;
                int len = i + 1;
                if (len <= j) {
                    take = dp[j - len] + arr[i];
                }
                dp[j] = Math.max(notTake, take);
            }
        }
        return dp[tar];
    }
}
