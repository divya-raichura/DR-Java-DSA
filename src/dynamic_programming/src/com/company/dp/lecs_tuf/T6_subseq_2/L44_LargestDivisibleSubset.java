package com.company.dp.lecs_tuf.T6_subseq_2;

import java.util.ArrayList;
import java.util.Arrays;

public class L44_LargestDivisibleSubset {
    public static void main(String[] args) {

    }

    static void printLDS(int[] arr) {
        int[] dp = new int[arr.length];
        int[] hash = new int[arr.length];
        for (int i = 0; i < hash.length; i++) hash[i] = i;
        Arrays.fill(dp, 1);
        int maxLenIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && (1 + dp[j] > dp[i])) {
                    hash[i] = j;
                    dp[i] = 1 + dp[j];
                }
            }
            if (dp[maxLenIndex] < dp[i]) {
                maxLenIndex = i;
            }
        }

        int len = dp[maxLenIndex];
        int[] ans = new int[len];
        while (len > 0) {
            ans[len - 1] = arr[maxLenIndex];
            maxLenIndex = hash[maxLenIndex];
            len--;
        }
        System.out.println(Arrays.toString(ans));
    }

    public ArrayList<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        return returnLDSList(nums);
    }

    static ArrayList<Integer> returnLDSList(int[] arr) {
        int[] dp = new int[arr.length];
        int[] hash = new int[arr.length];
        for (int i = 0; i < hash.length; i++) hash[i] = i;
        Arrays.fill(dp, 1);
        int maxLenIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && (1 + dp[j] > dp[i])) {
                    hash[i] = j;
                    dp[i] = 1 + dp[j];
                }
            }
            if (dp[maxLenIndex] < dp[i]) {
                maxLenIndex = i;
            }
        }

        int len = dp[maxLenIndex];
        ArrayList<Integer> list = new ArrayList<>();
        while (len > 0) {
            list.add(arr[maxLenIndex]);
            maxLenIndex = hash[maxLenIndex];
            len--;
        }
        return list;
    }
}


