package src.algos.sorting.question;

// https://leetcode.com/problems/missing-number/submissions/

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {3, 0, 2};
        System.out.println(sort(arr));
    }

    static int sort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i];
            if (arr[i] == arr.length) {
                i++;
            } else if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
            /*
            if (arr[i] != arr[correct] && arr[i] < arr.length) {
                swap(arr, i, correct);
            } else {
                i++;
            }
            */
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j) {
                return j;
            }
        }
        return arr.length;
    }

    static void swap(int[] arr, int num1, int num2) {
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }

//    public int missingNumber(int[] nums) {
//        int i = 0;
//        while (i < nums.length) {
//            int correct = nums[i];
//            if (nums[i] == nums.length) {
//                i++;
//            } else if (nums[i] != nums[correct]) {
//                swap(nums, i, correct);
//            } else {
//                i++;
//            }
//        }
//        for (int j = 0; j < nums.length; j++) {
//            if (nums[j] != j) {
//                return j;
//            }
//        }
//        return nums.length;
//    }

}
