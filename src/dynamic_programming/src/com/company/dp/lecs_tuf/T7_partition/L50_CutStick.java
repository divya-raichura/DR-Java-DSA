package com.company.dp.lecs_tuf.T7_partition;

import java.util.Arrays;

public class L50_CutStick {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5};
        System.out.println(rec(7, arr));
    }

    public static int rec(int n, int[] cuts) {
        int[] newCuts = new int[cuts.length+2];
        newCuts[0] = 0;
        newCuts[newCuts.length - 1] = n;
        for (int i = 0; i < cuts.length; i++) {
            newCuts[i + 1] = cuts[i];
        }
        Arrays.sort(newCuts);
        return rec(newCuts, 1, cuts.length );
    }

    public static int rec(int[] cuts, int i, int j) {
        if (i > j) return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int steps = (cuts[j + 1] - cuts[i - 1]) + rec(cuts, i, k - 1) + rec(cuts, k + 1, j);
            min = Math.min(min, steps);
        }
        return min;
    }
}
