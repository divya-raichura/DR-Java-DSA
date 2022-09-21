package com.company.dp.lecs_av.knapsack;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int target = 25;
        System.out.println(sum(arr, 0, target));
    }

    static boolean sum(int[] arr, int index, int target) {

        if (target == 0) {
            return true;
        }

        if (index == arr.length) {
            return false;
        }

        boolean take = false;
        if (target >= arr[index]) {
            take = sum(arr, index + 1, target - arr[index]);
        }
        boolean notTake = sum(arr, index + 1, target);

        return take || notTake;
    }

}
