package com.company.dp.lecs_tuf.T7_partition;

import java.util.Arrays;

public class L48_mcm {
    public static void main(String[] args) {

    }

    static int mcmRec(int[] arr) {
        return mcmRec(arr, 1, arr.length - 1);
    }

    static int mcmRec(int[] arr, int i, int j) {
        if (i == j) return 0; // i == j means only one matrix, so no ops

        int minimumOps = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int steps = mcmRec(arr, i, k)
                    + mcmRec(arr, k + 1, j)
                    + arr[i - 1] * arr[k] * arr[j];

            minimumOps = Math.min(minimumOps, steps);
        }

        return minimumOps;
    }

    // tc: (n * n) * n for the 'for' loop
    // sc: n * n + o(n) stack space
    static int mcmMemo(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];

        for (int[] array : dp) Arrays.fill(array, -1);

        return mcmMemo(arr, 1, arr.length - 1, dp);
    }

    static int mcmMemo(int[] arr, int i, int j, int[][] dp) {
        if (i == j) return 0; // i == j means only one matrix, so no ops

        if (dp[i][j] != -1) return dp[i][j];

        int minimumOps = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int steps = mcmMemo(arr, i, k, dp)
                    + mcmMemo(arr, k + 1, j, dp)
                    + (arr[i - 1] * arr[k] * arr[j]);

            minimumOps = Math.min(minimumOps, steps);
        }

        return dp[i][j] = minimumOps;
    }

    static int mcmTabulation(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];

        for (int i = arr.length - 1; i >= 1; i--) {
//            for (int j = 0; j < arr.length; j++) { // j = 0 does not make sense
            // cause inside we run k from i to j so j needs to be greater than i
            for (int j = i + 1; j < arr.length; j++) {// tho, both give correct ans
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    int minimumOps = Integer.MAX_VALUE;

                    for (int k = i; k < j; k++) {
                        int steps = dp[i][k]
                                + dp[k + 1][j]
                                + (arr[i - 1] * arr[k] * arr[j]);

                        minimumOps = Math.min(minimumOps, steps);
                    }
                    dp[i][j] = minimumOps;
                }
            }
        }
        return dp[1][arr.length - 1];
    }

}
