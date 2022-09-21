package com.company.dp.lecs_tuf.T3_subseq;

public class L17_Count {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        int tar = 3;
        System.out.println(rec(arr, tar));
    }

    public static int rec(int[] arr, int tar) {
        return rec(arr, tar, arr.length - 1);
    }

    public static int rec(int[] arr, int tar, int index) {
        if (tar == 0) return 1;
        if (index == 0) return arr[0] == tar ? 1 : 0;
        int take = 0;
        if (tar - arr[index] >= 0) {
            take = rec(arr, tar - arr[index], index - 1);
        }

        int notTake = rec(arr, tar, index - 1);
        return take + notTake;
    }
    // memo and tab similar to prev questions, not much difference

    // above code will not work for cases like { 0, 0, 1 }
    // because we are returning right away after tar == 0
    // to make such cases work we wait till end
    // so, just remove if (tar == 0) return 1; condition and make following changes
    /*
        if (index < 0) {
            if (tar == 0) return 1;
            return 0;
        }


        // or

        if (index == 0) {
            if (arr[index] == 0 && tar == 0) return 2;
            if (tar == 0 || arr[0] == tar) return 1;
            return 0;
        }

        // in tabulation...
        if(arr[0] == 0) dp[0][0] = 2; // arr[index] == 0 && tar == 0
        else dp[0][0] = 1; // tar == 0, 2nd condition
        if (arr[0] != 0 && arr[0] <= tar) dp[0][arr[0]] = 1; // arr[0] == tar, 2nd condition

        NOTE : all this was for if(index == 0) ie 0th row of dp array as it
        represents index 0, hence there was no for loop like in
        previous count implementation of tabulation
     */
}
