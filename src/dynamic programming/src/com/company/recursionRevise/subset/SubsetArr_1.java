package com.company.recursionRevise.subset;

import java.util.ArrayList;
import java.util.List;

public class SubsetArr_1 {

    public static void main(String[] args) {
//        int[] arr = {1, 7, 1};
        int[] arr = {2, 3, 6};
        ArrayList<Integer> list = new ArrayList<>();
        subset(arr, 0, list); // subset 1, output : 1,7 and 7,1 ie duplicate subsets included
        // in subset 2: only 1,7 ie duplicate subsets omitted
        System.out.println();
        iterativeDupAllowed(arr);
    }

    // for iterative approach see recursion package or kk video
    // wrote iterative approach below

    static void subset(int[] arr, int i, ArrayList<Integer> list) {

        if (i == arr.length) {
            System.out.print(list + " ");
            return;
        }

        list.add(arr[i]);
        subset(arr, i + 1, list); // take
        list.remove(list.size() - 1);
        subset(arr, i + 1, list); // don't take
    }

    static void iterativeDupAllowed(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int n : arr) {
            int len = outer.size();
            for (int i = 0; i < len; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(n);
                outer.add(inner);
            }
        }
        System.out.println(outer);
    }
}