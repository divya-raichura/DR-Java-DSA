package com.company.dp.lecs_tuf.oneD_arr_questions;

import java.util.Arrays;

public class _7_Ninja {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 5},
                {3, 1, 1},
                {3, 4, 6}
        };
        System.out.println(rec(3, arr, arr.length - 1));

        int[][] dp = new int[arr.length][3+1];
        for (int[] nums : dp) {
            Arrays.fill(nums, -1);
        }
        System.out.println(memo(3, arr, arr.length-1, dp));
//        for (int[] nums : dp) {
//            System.out.println(Arrays.toString(nums));
//        }

        System.out.println(tabulation(arr));

        System.out.println(spaceOpt(arr));
    }

    // my try also correct, it's in the practice package...

    // recursion
    public static int rec(int prevAct, int[][] outer, int day) {
        if (day == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                if (i == prevAct) continue;
                max = Math.max(outer[0][i], max);
            }
            return max;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i == prevAct) continue;
            int act = outer[day][i] + rec(i, outer, day - 1);
            max = Math.max(max, act);
        }

        return max;
    }

    // memo
    public static int memo(int prevAct, int[][] outer, int day, int[][] dp) {

        if(dp[day][prevAct] != -1) return dp[day][prevAct];

        if (day == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                if (i == prevAct) continue;
                max = Math.max(outer[0][i], max);
            }
            return dp[day][prevAct] = max;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i == prevAct) continue;
            int act = outer[day][i] + memo(i, outer, day - 1, dp);
            max = Math.max(max, act);
        }

        return dp[day][prevAct] = max;
    }

    // tabulation
    public static int tabulation(int[][] arr) {
        int[][] dp = new int[arr.length][4];
        for (int i = 0; i < 4; i++) {
            int max = 0;
            for (int j = 0; j < 3; j++) {
                if (j == i) continue;
                max = Math.max(arr[0][j], max);
            }
            dp[0][i] = max;
        }

        for (int day = 1; day < dp.length; day++) {
            for (int prevAct = 0; prevAct < 4; prevAct++) {
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < 3; i++) {
                    if (i == prevAct) continue;
                    int a = arr[day][i] + dp[day - 1][i];
                    max = Math.max(a, max);
                }
                dp[day][prevAct] = max;
            }
        }
        return dp[dp.length - 1][3];
    }


    /* space optimisation
    * tc : o(n*4*3)
    * sc : o(4)
    * */
    public static int spaceOpt(int[][] arr) {
        int[] dp = new int[4];
        for (int i = 0; i < 4; i++) {
            int max = 0;
            for (int j = 0; j < 3; j++) {
                if (j == i) continue;
                max = Math.max(arr[0][j], max);
            }
            dp[i] = max;
        }

        for (int day = 1; day < arr.length; day++) {
            int[] store = new int[4];
            for (int prevAct = 0; prevAct < 4; prevAct++) {
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < 3; i++) {
                    if (i == prevAct) continue;
                    int a = arr[day][i] + dp[i];
                    max = Math.max(a, max);
                }
                store[prevAct] = max;
            }
            dp = store;
        }
        return dp[3];
    }

}
