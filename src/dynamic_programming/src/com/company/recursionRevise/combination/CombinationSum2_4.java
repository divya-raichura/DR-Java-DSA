package com.company.recursionRevise.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2_4 {

    // {10,1,2,7,6,1,5} target = 8
    // eg ans and condition : 1,2,5 or 2,1,5 we cannot pick both!

    public static void main(String[] args) {
//        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        //        int[] arr = {1, 1, 1, 2, 2};
        int[] arr = {1, 7, 1};
        int target = 8;
        List<List<Integer>> ans = combinationSum2(arr, target);
        System.out.println();
        System.out.println(ans);
    }

    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        dfs_com(candidates, 0, target, new ArrayList<>(), list);
        return list;
    }

    static void dfs_com(int[] arr, int ind, int target, List<Integer> list, List<List<Integer>> ans) {
        if (target == 0) {
            System.out.print(list + " ");
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue;
            if (target < 0) return;
            list.add(arr[i]);
            dfs_com(arr, i + 1, target - arr[i], list, ans); // v imp note : ind = i + 1 not ind + 1
            list.remove(list.size() - 1);
        }
    }
}
