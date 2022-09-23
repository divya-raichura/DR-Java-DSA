package com.company.dp.lecs_tuf.T4_strings;

import java.util.Arrays;

public class L32_DistinctSubseq {
    public static void main(String[] args) {
        String one = "babgbag";
        String two = "bag";
        System.out.println(rec(one, two));
        System.out.println(memo(one, two));
        System.out.println(tabulation(one, two));
        System.out.println(spaceOpt(one, two));
        System.out.println(spaceOpt1DArr(one, two));
    }

    public static int rec(String t, String s) {
        return rec(t, s, t.length(), s.length());
    }

    public static int rec(String s1, String s2, int i, int j) {
        if (j == 0) return 1;
        if (i == 0) return 0;

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return rec(s1, s2, i - 1, j - 1) + rec(s1, s2, i - 1, j);
        } else {
            return rec(s1, s2, i - 1, j);
        }
    }

    public static int memo(String t, String s) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return memo(t, s, t.length(), s.length(), dp);
    }

    public static int memo(String s1, String s2, int i, int j, int[][] dp) {
        if (j == 0) return 1;
        if (i == 0) return 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return dp[i][j] = memo(s1, s2, i - 1, j - 1, dp) + memo(s1, s2, i - 1, j, dp);
        } else {
            return dp[i][j] = memo(s1, s2, i - 1, j, dp);
        }
    }

    static int tabulation(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[i].length; j++) {
//                if (j == 0) {
//                    dp[i][j] = 1;
//                }
//            }
//        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    static int spaceOpt(String s1, String s2) {
        int[] prev = new int[s2.length() + 1];
        prev[0] = 1;

        for (int i = 1; i < s1.length() + 1; i++) {
            int[] curr = new int[s2.length() + 1];
            curr[0] = 1;
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + prev[j];
                } else {
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        System.out.println(Arrays.toString(prev));
        return prev[s2.length()];
    }

    static int spaceOpt1DArr(String s1, String s2) {
        int[] dp = new int[s2.length() + 1];
        dp[0] = 1;

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = s2.length(); j >= 1; j--) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = dp[j - 1] + dp[j];
                } else {
                    dp[j] = dp[j]; // not needed
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[s2.length()];
    }
}
