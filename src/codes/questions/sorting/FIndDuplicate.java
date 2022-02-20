package questions.sorting;

// https://leetcode.com/problems/find-the-duplicate-number/submissions/

class FIndDuplicate {
    static int duplicatesKK(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != i + 1) {
                int correct = arr[i] - 1; // correct index for that element
                if (arr[i] != arr[correct]) {
                    swap(arr, i, correct);
                } else {
                    return arr[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    static void swap(int[] arr, int num1, int num2) {
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }

    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1; // correct index for that element
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        int ans = -1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                ans = nums[j];
            }
        }
        return ans;
    }
}