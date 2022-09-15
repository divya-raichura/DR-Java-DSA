package com.company.dp.lecs_tuf.T3_subseq;

import java.util.ArrayList;

public class _16_MinPartition {
    public static void main(String[] args) {
    }

    // my try using list
    public static int codeList(int[] arr) {
        // Write your code here.
        int total = 0;
        for(int i : arr) total += i;
        ArrayList<Integer> range = codeList(arr, total);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < range.size(); i++) {
            int s1 = range.get(i);
            int s2 = total - s1;
            min = Math.min(min, Math.abs(s1 - s2));
        }
        return min;
    }

    public static ArrayList<Integer> codeList(int[] arr, int total) {
        boolean[][] dp = new boolean[arr.length][total + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        // if(index == 0) return arr[0] == target;
        if (arr[0] <= total) dp[0][arr[0]] = true;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < total + 1; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if (j - arr[i]>= 0){ take = dp[i - 1][j - arr[i]];}
                dp[i][j] = take | notTake;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < total + 1; i++) {
            if (dp[arr.length - 1][i]) list.add(i);
        }
        return list;
    }

    // proper ans without list
    public static int code(int[] arr) {
        // Write your code here.
        int total = 0;
        for(int i : arr) total += i;
        return code(arr, total);
    }

    public static int code(int[] arr, int total) {
        boolean[][] dp = new boolean[arr.length][total + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        // if(index == 0) return arr[0] == target;
        if (arr[0] <= total) dp[0][arr[0]] = true;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < total + 1; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if (j - arr[i]>= 0){ take = dp[i - 1][j - arr[i]];}
                dp[i][j] = take | notTake;
            }
        }
        // dp[dp.len-1][0, 1, 2...total]
        int min = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= total / 2; s1++) {
            if (dp[dp.length - 1][s1]) {
                min = Math.min(min, Math.abs(s1 - (total - s1)));
            }
        }
        return min;
    }
}
