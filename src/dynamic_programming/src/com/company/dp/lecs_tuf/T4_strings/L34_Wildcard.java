package com.company.dp.lecs_tuf.T4_strings;

import java.util.Arrays;

public class L34_Wildcard {
    public static void main(String[] args) {

    }

    // tc : expo
    // sc : n + m
    static boolean rec(String s, String p) {
        return rec(s, p, s.length(), p.length());
    }

    static boolean rec(String s, String p, int i, int j) {
        if (i == 0 && j == 0) return true;
        if (i == 0) {
            while (j != 0) {
                if (p.charAt(j - 1) != '*') return false;
                j--;
            }
            return true;
        }
        if (j == 0) return false;

        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
            return rec(s, p, i - 1, j - 1);
        } else if (p.charAt(j - 1) == '*') {
            return rec(s, p, i - 1, j) || rec(s, p, i, j - 1);
        } else {
            return false;
        }
    }

    // tc: n * m
    // sc: n*m + n+m stack space
    public static boolean memo(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return memo(s, p, s.length(), p.length(), dp);
    }

    static boolean memo(String s, String p, int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return true;
        if (i > 0 && j == 0) return false;
        if (i == 0 && j > 0) {
            while (j != 0) {
                if (p.charAt(j - 1) != '*') return false;
                j--;
            }
            return true;
        }

        if (dp[i][j] != -1) return dp[i][j] == 1; // dp[i][j] == 1? true : false

        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
            boolean ans = memo(s, p, i - 1, j - 1, dp);
            if (ans) dp[i][j] = 1;
            else dp[i][j] = 0;
            return ans;
        } else if (p.charAt(j - 1) == '*') {
            boolean ans = memo(s, p, i - 1, j, dp) || memo(s, p, i, j - 1, dp);
            if (ans) dp[i][j] = 1;
            else dp[i][j] = 0;
            return ans;
        } else {
            return false;
        }
    }

    public static boolean tabulation(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        for (int i = 0; i < dp[0].length; i++) {
            int j = i;
            boolean check = true;
            while (j > 0) {
                if (p.charAt(j - 1) != '*') {
                    check = false;
                    break;
                }
                j--;
            }
            if (check) dp[0][i] = true;
        }
        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static boolean spaceOpt(String s, String p) {
        boolean[] prev = new boolean[p.length() + 1];

        for (int i = 0; i < p.length() + 1; i++) {
            int j = i;
            boolean check = true;
            while (j > 0) {
                if (p.charAt(j - 1) != '*') {
                    check = false;
                    break;
                }
                j--;
            }
            if (check) prev[i] = true;
        }
        prev[0] = true;

        for (int i = 1; i < s.length() + 1; i++) {
            boolean[] curr = new boolean[p.length() + 1];
            for (int j = 1; j < p.length() + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    curr[j] = prev[j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    curr[j] = prev[j] ||curr[j - 1];
                } else {
                    curr[j] = false;
                }
            }
            prev = curr;
        }
        return prev[p.length()];
    }
}
