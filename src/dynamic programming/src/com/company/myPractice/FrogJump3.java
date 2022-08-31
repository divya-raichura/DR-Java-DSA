package com.company.myPractice;

public class FrogJump3 {
    public static void main(String[] args) {

    }

    static int recursion(int[] arr, int index, int[] dp) {

        if (index == 0) return 0;

        if(dp[index] != -1) return dp[index];

        int two = Integer.MAX_VALUE;
        if (index > 1) {
            two = recursion(arr, index - 2, dp) + Math.abs(arr[index] - arr[index - 2]);
        }
        int one = recursion(arr, index - 1, dp) + Math.abs(arr[index] - arr[index - 1]);

        return dp[index] = Math.min(two, one);
    }
}
