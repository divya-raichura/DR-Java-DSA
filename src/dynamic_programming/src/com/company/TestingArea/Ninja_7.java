package com.company.TestingArea;

import java.util.Arrays;

public class Ninja_7 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}
        };
        System.out.println(ninjaTraining(0, arr));

        System.out.println(recTopDown(-1, arr, arr.length - 1));

        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(recTopDownMemo(-1, arr, arr.length - 1, dp));
    }

    public static int ninjaTraining(int n, int[][] arr) {

        // Write your code here..
        return rec(-1, arr, 0);
    }

    public static int rec(int prevAct, int[][] outer, int day) {

        if (day == outer.length) return 0;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            if (i != prevAct) {
                int a = outer[day][i] + rec(i, outer, day + 1);
                max = Math.max(a, max);
            }
        }

        return max;
    }

    public static int recTopDown(int prevAct, int[][] outer, int day) {

        if (day < 0) return 0;


        int max = Integer.MIN_VALUE;

        for (int act = 0; act < 3; act++) {
            if (act != prevAct) {
                int a = outer[day][act] + recTopDown(act, outer, day - 1);
                max = Math.max(a, max);
            }
        }

        return max;
    }

    public static int recTopDownMemo(int prevAct, int[][] outer, int day, int[] dp) {

        if (day < 0) return 0;

        if(dp[day] != -1) return dp[day];

        int max = Integer.MIN_VALUE;

        for (int act = 0; act < 3; act++) {
            if (act != prevAct) {
                int a = outer[day][act] + recTopDownMemo(act, outer, day - 1, dp);
                max = Math.max(a, max);
            }
        }

        return dp[day] = max;
    }

}
