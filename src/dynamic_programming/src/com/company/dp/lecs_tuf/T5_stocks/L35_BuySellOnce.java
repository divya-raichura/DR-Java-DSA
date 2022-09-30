package com.company.dp.lecs_tuf.T5_stocks;

public class L35_BuySellOnce {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] arr) {
        int mini = 0;
        int profit = 0;
        for(int i = 1; i < arr.length; i++) {
            profit = Math.max(profit, arr[i] - arr[mini]);
            if(arr[i] < arr[mini]) mini = i;
        }
        return profit;
    }
}
