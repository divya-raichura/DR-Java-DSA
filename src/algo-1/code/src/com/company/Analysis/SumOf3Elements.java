package com.company.Analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

// https://fizzbuzzed.com/top-interview-questions-1/
public class SumOf3Elements {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int[] ints = {-1, 0, 1, 2, -1, -4};
        System.out.println("normalThatOutputsDuplicatesToo      : " + normalThatOutputsDuplicatesToo(arr));
        System.out.println("normalThatDoesNOTOutputsDuplicates  : " + normalThatDoesNOTOutputsDuplicates(ints));
    }

    // O(n3) and og arr: {-1, 0, 1, 2, -1, -4};
    // [[-1, 0, 1], [-1, 2, -1], [0, 1, -1]]
    // we don't want these repeated lists
    static List<List<Integer>> normalThatOutputsDuplicatesToo(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                for (int k = j + 1; k < nums.length; ++k) {
                    if (k != j + 1 && nums[k] == nums[k - 1]) continue;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // one liner for below code : list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        list.add(l);
                    }
                }
            }
        }
        return list;
    }

    // O(n3) and og arr: {-1, 0, 1, 2, -1, -4};
    static List<List<Integer>> normalThatDoesNOTOutputsDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                for (int k = j + 1; k < nums.length; k++) {
                    if (k != j + 1 && nums[k] == nums[k - 1]) continue;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return list;
    }


}


