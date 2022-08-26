package com.company.recursionRevise.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetArrDup_5 {

    public static void main(String[] args) {
//        int[] arr = {2, 3, 6};
        int[] arr = {1, 2, 2}; // output : 1, 7 but not 7, 1
        // but in subset 1, output : 1,7 and 7,1 ie duplicate subsets included

        // iteration
        iterativeDupNotAllowed(arr);

        System.out.println();
        // take not take recursion
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        recursiveDupNotAllowedTakeNotTakeMethod(arr, 0, ans, new ArrayList<>());
        System.out.println(ans);

        System.out.println();

        // for loop recursion
        ArrayList<ArrayList<Integer>> ans2 = new ArrayList<>();
        recursiveDupNotAllowedForLoopMethod(arr, 0, ans2, new ArrayList<>());
        System.out.println(ans2);
    }

    static void recursiveDupNotAllowedForLoopMethod(int[] arr, int index, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list) {
// don't forget to sort the array in main

        ans.add(new ArrayList<>(list));

        for (int i = index; i < arr.length; i++) {
            if(i > index && arr[i] == arr[i - 1]) continue;
            list.add(arr[i]);
            recursiveDupNotAllowedForLoopMethod(arr, i + 1, ans, list);
            list.remove(list.size() - 1);
        }

    }


    static void recursiveDupNotAllowedTakeNotTakeMethod(int[] arr, int index, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list) {
// don't forget to sort the array in main
        if (index >= arr.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[index]);
        recursiveDupNotAllowedTakeNotTakeMethod(arr, index + 1, ans, list);
        list.remove(list.size() - 1);

        while (index + 1 < arr.length && arr[index] == arr[index + 1]) {
            index ++;
        }

        recursiveDupNotAllowedTakeNotTakeMethod(arr, index + 1, ans, list);
    }

    static void iterativeDupNotAllowed(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start;
        int end = 0;
        for (int o = 0; o < arr.length; o++) {
            start = 0;
            if (o > 0 && arr[o] == arr[o - 1]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            int len = outer.size();
            for (int i = start; i < len; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(arr[o]);
                outer.add(inner);
            }
        }
        System.out.println(outer);
    }

}
