package com.company.dp.lecs_tuf.T6_subseq_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class L45_StringChain {
    public static void main(String[] args) {
        String[] arr = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        System.out.println(ans(arr));
    }

    public static int ans(String[] arr) {
        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (compare(arr[j], arr[i]) && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                }
            }
            if (max < dp[i]) max = dp[i];
        }
        return max;
    }

    static boolean compare(String one, String two) {
        if (one.length() != two.length() - 1) return false;
        int i = 0, j = 0;
        while (j  < two.length()) {
            if (i < one.length() && one.charAt(i) == two.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == one.length() && j == two.length();
    }
}
