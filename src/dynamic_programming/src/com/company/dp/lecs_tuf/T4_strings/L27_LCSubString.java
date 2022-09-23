package com.company.dp.lecs_tuf.T4_strings;

import java.util.Arrays;

public class L27_LCSubString {
    public static void main(String[] args) {
        String one = "ab";
        String two = "a";
        System.out.println(tabulation(one, two));
    }

    static int tabulation(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(dp[i][j], max);
                }
/*               else {
                  dp[i][j] = 0;
                }
                no need cause in java integer arr has default value of elements as zero
*/
            }
        }
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
        return max;
    }
}
