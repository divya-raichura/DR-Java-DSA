package src.codes.questions.sorting;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/submissions/

import java.util.ArrayList;
import java.util.List;

class FindAllMissingNos {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i =0;
        while (i < nums.length) {
            int correct = nums[i] - 1; // correct index for that element
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                ans.add(j + 1);
            }
        }
        return ans;
    }

    static void swap(int[] arr, int num1, int num2) {
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }
}