package com.company.recursionRevise.subset;

import java.util.ArrayList;

public class SubseqWhoseSumIsK_2 {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 1};
        int[] arr = {1, 1, 1, 2, 2};
        int target = 4;

//        printSum(arr, 0, new ArrayList<>(), 2, 0);

        printSum(arr, 0, new ArrayList<>(), target, 0);
    }

    static void printSum(int[] arr, int i, ArrayList<Integer> list, int target, int sum) {
        if (i == arr.length) {
            if (sum == target) {
                System.out.println("-> sum == target  :  " + list);
            } else {
                System.out.println("sum != target  :  " + list);
            }
            return;
        }

        sum += arr[i];
        list.add(arr[i]);
        printSum(arr, i + 1, list, target, sum);

        sum -= arr[i];
        list.remove(list.size() - 1);
        printSum(arr, i + 1, list, target, sum);
    }

    static int printSumCount(int[] arr, int i, ArrayList<Integer> list, int target, int sum) {
        if (i == arr.length) {
            if (sum == target) {
                System.out.println("-> sum == target  :  " + list);
                return 1;
            }
//            System.out.println("sum != target  :  " + list);
            return 0;
        }

        int count = 0;

        sum += arr[i];
        list.add(arr[i]);
        count += printSumCount(arr, i + 1, list, target, sum);

        sum -= arr[i];
        list.remove(list.size() - 1);
        count += printSumCount(arr, i + 1, list, target, sum);

        return count;
    }
}
