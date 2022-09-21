package com.company.dp.lecs_tuf.T3_subseq;

public class L23_UnboundedKnap {
    // like knapsack, but here, we can select a single item more than one time
    static int rec(int[] wt, int[] val, int i, int w) {
        if (i == 0) {

//                int bag_wt = w;
//                int item_wt = wt[0];
//                int item_val = val[0];
//                int no_of_time_he_can_steal = w / wt[0];
//                int value_he_can_gain = no_of_time_he_can_steal * item_val;
//                return value_he_can_gain;
            return w / wt[0] * val[0];

            // below base case is for og knapsack
            // but here, there is infinite supply of items
            // so the last item can be selected multiple no of times, hence
            // the below base case is wrong
//            if (wt[0] <= w) return val[0];
//            return 0;
        }

        int notTake = rec(wt, val, i - 1, w);
        int take = Integer.MIN_VALUE;
        if (wt[i] <= w) {
            take = val[i] + rec(wt, val, i, w - wt[i]);
        }
        return Math.max(notTake, take);
    }

    static int tabulation(int[] wt, int[] val, int w) {
        // base
        int[][] dp = new int[wt.length][w + 1];
        for (int j = 0; j < w + 1; j++) {
            dp[0][j] = j / wt[0] * val[0];
        }

        for (int i = 1; i < wt.length; i++) {
            for (int j = 0; j < w + 1; j++) {
                int notTake = dp[i - 1][j];
                int take = Integer.MIN_VALUE;
                if (wt[i] <= j) {
                    take = val[i] + dp[i][j - wt[i]];
                }
                dp[i][j] = Math.max(notTake, take);
            }
        }
        return dp[dp.length - 1][w];
    }

    static int spaceOpt(int[] wt, int[] val, int w) {
        // base
        int[] prev = new int[w + 1];
        for (int j = 0; j < w + 1; j++) {
            prev[j] = j / wt[0] * val[0];
        }

        for (int i = 1; i < wt.length; i++) {
            int[] curr = new int[w + 1];
            for (int j = 0; j < w + 1; j++) {
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;
                if (wt[i] <= j) {
                    take = val[i] + curr[j - wt[i]];
                }
                curr[j] = Math.max(notTake, take);
            }
            prev = curr;
        }
        return prev[w];
    }

    static int spaceOptUsing1ArrOnly(int[] wt, int[] val, int w) {
        // base
        int[] dp = new int[w + 1];
        for (int j = 0; j < w + 1; j++) {
            dp[j] = j / wt[0] * val[0];
        }

        for (int i = 1; i < wt.length; i++) {
            for (int j = 0; j < w + 1; j++) {
                int notTake = dp[j];
                int take = Integer.MIN_VALUE;
                if (wt[i] <= j) {
                    take = val[i] + dp[j - wt[i]];
                }
                dp[j] = Math.max(notTake, take);
            }
        }
        return dp[w];
    }
}
