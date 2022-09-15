package com.company.dp.lecs_tuf.T1__oneD_arr_questions;

import java.util.ArrayList;
import java.util.Arrays;

public class _5_NonAdjSum {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(9);

        // recursion
        System.out.println(rec(list, list.size() - 1));

        // memo
        System.out.println(memo(list, list.size() - 1));

        // bottom up or tabulation
        System.out.println(tabulation(list));

        // space optimisation
        System.out.println(spaceOpt(list));
    }

    // recursion
    // tc : o(2^n)
    static int rec(ArrayList<Integer> list, int index) {

        if(index == 0) return list.get(index);
        if (index < 0) return 0;

        int take = list.get(index) + rec(list, index - 2);
        int notTake = rec(list, index - 1);

        return Math.max(take, notTake);
    }

    // memo
    // tc : o(n)
    // sc : o(n) + o(n)
    static int memo(ArrayList<Integer> list, int index) {
        int[] dp = new int[list.size()];
        Arrays.fill(dp, -1);
        return memo(list, index, dp);
    }

    static int memo(ArrayList<Integer> list, int index, int[] dp) {

        if(index == 0) return list.get(index);
        if (index < 0) return 0;

        if(dp[index] != -1) return dp[index];

        int take = list.get(index) + memo(list, index - 2, dp);
        int notTake = memo(list, index - 1, dp);

        return dp[index] = Math.max(take, notTake);
    }

    // tabulation
    // tc : o(n)
    // sc : o(n)
    static int tabulation(ArrayList<Integer> list) {
        int[] dp = new int[list.size()];
        Arrays.fill(dp, -1);

        // base cases
        dp[0] = list.get(0);
        int negativeIndex = 0;

        for (int i = 1; i < list.size(); i++) {
//            int take = Integer.MIN_VALUE; // not this because we are just casually skipping first element for no good reason, gives wrong ans!!!
            int take = list.get(i);
            if (i > 1) {
                take = list.get(i) + dp[i - 2];
            }
            int notTake = dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[list.size() - 1];
    }

    // space optimisation
    // tc : o(n)
    // sc : o(1)
    static int spaceOpt(ArrayList<Integer> list) {

        int prev = list.get(0);
        int prev2 = 0;

        for (int i = 1; i < list.size(); i++) {
            int take = list.get(i) + prev2;
            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
