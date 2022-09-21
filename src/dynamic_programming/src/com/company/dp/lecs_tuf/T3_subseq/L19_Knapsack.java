package com.company.dp.lecs_tuf.T3_subseq;

public class L19_Knapsack {
    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int w = 7;
        System.out.println(rec(wt, val, w, wt.length - 1));
    }

    static int rec(int[] wt, int[] val, int w, int i) {
        if (i == 0) {
            if (wt[0] <= w) return val[0];
            return 0;
        }

        int notTake = rec(wt, val, w, i - 1);
        int take  = Integer.MIN_VALUE;
        if (w - wt[i] >= 0) {
            take = val[i] + rec(wt, val, w - wt[i], i - 1);
        }

        return Math.max(notTake, take);
    }
}
