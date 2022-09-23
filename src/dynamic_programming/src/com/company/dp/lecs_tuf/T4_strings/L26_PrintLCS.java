package com.company.dp.lecs_tuf.T4_strings;

import java.util.Arrays;

public class L26_PrintLCS {
    public static void main(String[] args) {
        String one = "horse";
        String two = "ros";
        System.out.println(rec(one, two , one.length(), two.length()));
        System.out.println(tabulation(one, two));
        System.out.println(tabulationAnotherApproach(one, two));
    }
    // my method
    static String rec(String s1, String s2, int i, int j) {
        if (i == 0 || j == 0) {
            return "";
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return rec(s1, s2, i - 1, j - 1) + s1.charAt(i - 1);
        } else {
            String one = rec(s1, s2, i, j - 1);
            String two = rec(s1, s2, i - 1, j);
            return one.length() > two.length() ? one : two;
        }
    }

    static String tabulation(String s1, String s2) {
        String[][] dp = new String[s1.length() + 1][s2.length() + 1];
        for (String[] strings : dp) {
            Arrays.fill(strings, "");
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    String one = dp[i][j - 1];
                    String two = dp[i - 1][j];
                    dp[i][j] = one.length() > two.length() ? one : two;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    // another approach
    static String tabulationAnotherApproach(String s1, String s2) {
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
        int lengthOfSubsequence = dp[s1.length()][s2.length()];
        String ans = "";
        int index = lengthOfSubsequence - 1;
        int i = s1.length();
        int j = s2.length();
        while (index != -1) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                char c = s1.charAt(i - 1);
                ans = c + ans;
                index--;
                i--;
                j--;
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                j--;
            } else {
                i--;
            }
        }
        return ans;
    }

}
