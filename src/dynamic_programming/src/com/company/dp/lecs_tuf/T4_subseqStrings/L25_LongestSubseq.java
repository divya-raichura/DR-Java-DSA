package com.company.dp.lecs_tuf.T4_subseqStrings;

import java.util.Arrays;

// https://leetcode.com/problems/longest-common-subsequence/submissions/
public class L25_LongestSubseq {
    public static void main(String[] args) {

    }

    static int rec(String s1, String s2) {
        return rec(s1, s2, s1.length(), s2.length());
    }

    static int rec(String s1, String s2, int i, int j) {
        if (i == 0 || j == 0) {
            return 0;
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return 1 + rec(s1, s2, i - 1, j - 1);
        } else {
            return Math.max(rec(s1, s2, i, j - 1), rec(s1, s2, i - 1, j));
        }
    }

    // tc: n*m
    // sc: n*m + aux_space(n + m)
    static int memo(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] arr : dp) { // don't forget this
            // else /* if(dp[i][j] != -1) return dp[i][j]; */ will return 0
            // without even running recursion
            Arrays.fill(arr, -1);
        }
        return memo(s1, s2, s1.length(), s2.length(), dp);
    }

    static int memo(String s1, String s2, int i, int j, int[][] dp) {
        if (i == 0 || j == 0) {
            return 0;
        }

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return dp[i][j] = 1 + memo(s1, s2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(memo(s1, s2, i, j - 1, dp), memo(s1, s2, i - 1, j, dp));
        }
    }

    static int tabulation(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    static int spaceOpt(String s1, String s2) {
        int[] prev = new int[s2.length() + 1];
        for (int i = 1; i < s1.length() + 1; i++) {
            int[] curr = new int[s2.length() + 1];
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(curr[j - 1], prev[j]);
                }
            }
            prev = curr;
        }
        return prev[s2.length()];
    }
}
