package com.company.dp.lecs_tuf.T4_strings;

public class L31_ShortestSuperSeq {
    public static void main(String[] args) {
//        print("groot", "brute");
    }

    static int lcs(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int lcs = dp[s1.length()][s2.length()];
        return s1.length() + s2.length() - lcs;
    }

    static void print(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        String res = "";
        int i = s1.length();
        int j = s2.length();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                char ch = s1.charAt(i - 1);
                res = ch + res;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                char ch = s1.charAt(i - 1);
                res = ch + res;
                i--;
            } else {
                char ch = s2.charAt(j - 1);
                res = ch + res;
                j--;
            }
        }
        while (i > 0) {
            char ch = s1.charAt(i - 1);
            res = ch + res;
            i--;
        }
        while (j > 0) {
            char ch = s2.charAt(j - 1);
            res = ch + res;
            j--;
        }
        System.out.println(res);
    }
}
