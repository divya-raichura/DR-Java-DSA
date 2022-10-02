package com.company.dp.lecs_tuf.T6_subseq_2;

import java.util.Arrays;

public class L46_Bitonic {
    public static void main(String[] args) {

    }

    static int bitonic(int[] arr) {
        int[] dp1 = new int[arr.length];
        int[] dp2 = new int[arr.length];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && 1 + dp1[j] > dp1[i]) {
                    dp1[i] = 1 + dp1[j];
                }
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i] > arr[j] && 1 + dp2[j] > dp2[i]) {
                    dp2[i] = 1 + dp2[j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(dp1[i] + dp2[i] - 1, max);
        }
        return max;
    }
}
