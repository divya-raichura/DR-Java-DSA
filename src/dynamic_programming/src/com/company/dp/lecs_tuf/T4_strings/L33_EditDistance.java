package com.company.dp.lecs_tuf.T4_strings;

import java.util.Arrays;

public class L33_EditDistance {
    public static void main(String[] args) {

    }

    public int rec(String word1, String word2) {
        return rec(word1, word2, word1.length(), word2.length());
    }

    public int rec(String word1, String word2, int i, int j) {
        if (i == 0) return j;
        if (j == 0) return i;

        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return rec(word1, word2, i - 1, j - 1);
        }
        int edit = rec(word1, word2, i - 1, j - 1);
        int delete = rec(word1, word2, i - 1, j);
        int insert = rec(word1, word2, i, j - 1);
        int min = Math.min(insert, Math.min(edit, delete));
        return 1 + min;
    }

    public int memo(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return memo(word1, word2, word1.length(), word2.length(), dp);
    }

    public int memo(String word1, String word2, int i, int j, int[][] dp) {
        if (i == 0) return j;
        if (j == 0) return i;
        if (dp[i][j] != -1) return dp[i][j];
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return dp[i][j] = memo(word1, word2, i - 1, j - 1, dp);
        }
        int edit = memo(word1, word2, i - 1, j - 1, dp);
        int delete = memo(word1, word2, i - 1, j, dp);
        int insert = memo(word1, word2, i, j - 1, dp);
        int min = Math.min(insert, Math.min(edit, delete));
        return dp[i][j] = 1 + min;
    }

    static int tabulation(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < dp.length; i++) dp[i][0] = i;
        for (int i = 0; i < dp[0].length; i++) dp[0][i] = i;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int edit = dp[i - 1][j - 1];
                    int delete = dp[i - 1][j];
                    int insert = dp[i][j - 1];
                    int min = Math.min(insert, Math.min(edit, delete));
                    dp[i][j] = 1 + min;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    static int spaceOpt(String word1, String word2) {
        int[] prev = new int[word2.length() + 1];

        for (int i = 0; i < prev.length; i++) prev[i] = i;

        for (int i = 1; i < word1.length() + 1; i++) {
            int[] curr = new int[word2.length() + 1];
            curr[0] = i;
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    int edit = prev[j - 1];
                    int delete = prev[j];
                    int insert = curr[j - 1];
                    int min = Math.min(insert, Math.min(edit, delete));
                    curr[j] = 1 + min;
                }
            }
            prev = curr;
        }
        return prev[word2.length()];
    }
    // can't optimise to 1d array because edit and delete depend on prev but insert is depending upon curr
    // so both arrays are required
}
