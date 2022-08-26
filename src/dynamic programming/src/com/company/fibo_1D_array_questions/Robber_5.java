package com.company.fibo_1D_array_questions;

public class Robber_5 {

    public static void main(String[] args) {

    }

    static int rob(int[] arr, int ind) {
        if(ind == 0) return arr[ind];

        int max = arr[ind];

        for (int i = ind - 1; i >= 0; i--) {
            if(i + 1 == ind) continue;
            int ans = rob(arr, i) + arr[ind];
            max = Math.max(max, ans);
        }

        return max;
    }

}
