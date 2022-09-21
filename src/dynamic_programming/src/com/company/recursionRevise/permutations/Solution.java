package com.company.recursionRevise.permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] arr = {1, 2, 3};
        boolean[] freq = new boolean[arr.length];
        usingMap(arr, freq, ans, list);
        System.out.println(ans);
        System.out.println();

        List<List<Integer>> ans2 = new ArrayList<>();
        withoutUsingExtraSpace(arr, 0, ans2);
        System.out.println(ans2);
    }

    static void withoutUsingExtraSpace(int[] arr, int index,  List<List<Integer>> ans) {

        if (index >= arr.length) {
            List<Integer> list = new ArrayList<>();
            for (int j : arr) {
                list.add(j);
            }
            ans.add(list);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            withoutUsingExtraSpace(arr, index + 1, ans);
            swap(arr, i, index);
        }

    }

    // my try -> correct

//    static void withoutUsingExtraSpace(int[] arr, int index, List<Integer> list, List<List<Integer>> ans) {
//        if (list.size() == arr.length) {
//            ans.add(new ArrayList<>(list));
//            return;
//        }
//
//        for (int i = index; i < arr.length; i++) {
//            swap(arr, i, index);
//            list.add(arr[index]);
//            withoutUsingExtraSpace(arr, index + 1, list, ans);
//            list.remove(list.size() - 1);
//            swap(arr, i, index);
//        }
//
//    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void usingMap(int[] arr, boolean[] freq, List<List<Integer>> ans, List<Integer> list) {
        if (list.size() == arr.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                list.add(arr[i]);
                usingMap(arr, freq, ans, list);
                list.remove(list.size() - 1);
                freq[i] = false;
            }
        }
    }
}
