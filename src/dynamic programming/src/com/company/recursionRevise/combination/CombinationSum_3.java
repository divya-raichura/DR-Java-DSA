package com.company.recursionRevise.combination;

import java.util.ArrayList;

public class CombinationSum_3 {

    // duplicates allowed ie, elements can be repeated
    // {2, 3, 6, 7} target = 7
    // ans => 2,2,3 or 7
    public static void main(String[] args) {
//        int[] arr = {2, 3, 6, 7};
//        int[] arr = {1, 1, 1, 2, 2};
//        int target = 4;
//        int[] arr = { 2, 3, 6, 7};
        int[] arr = {1, 7, 1};
//        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        //        int[] arr = {1, 1, 1, 2, 2};
//        int target = 8;
//        print(target, 0, arr, new ArrayList<>());

    }


    static void print(int target, int ind, int[] arr, ArrayList<Integer> list) {
        if (ind == arr.length) {

            if(target == 0) System.out.println(list);

            return;
        }

        // pick (if target is achievable)
        if (target - arr[ind] >= 0) {
            list.add(arr[ind]);
            print(target - arr[ind], ind, arr, list);
            list.remove(list.size() - 1);
        }

        // not pick
        print(target, ind + 1, arr, list);
    }


    // another method

//    public List<List<Integer>> combinationSum(int[] arr, int target) {
//        List<List<Integer>> ans = new ArrayList<>();
//        sum(ans, new ArrayList<>(), target, arr, 0);
//        return ans;
//    }
//
//    static void sum(List<List<Integer>> ans, List<Integer> list, int target, int[] arr, int index) {
//        if(target == 0) {
//            ans.add(new ArrayList<>(list));
//            return;
//        }
//
//        if(index >= arr.length || target < 0) return;
//
//        list.add(arr[index]);
//        sum(ans, list, target - arr[index], arr, index);
//        list.remove(list.size() - 1);
//        sum(ans, list, target, arr, index + 1);
//    }

}
