package questions.sorting;

// https://leetcode.com/problems/set-mismatch/submissions/

// just a combination question of duplicate and missing element

class MisMatch {
    public int[] findErrorNums(int[] nums) {
        int i =0;
        while (i < nums.length) {
            int correct = nums[i] - 1; // correct index for that element
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
//        int[] arr = {-1, -1};
//        for (int j = 0; j < nums.length; j++) {
//            if (nums[j] != j + 1) {
//                arr[0] = nums[j]; // duplicate
//            }
//            if (nums[j] != j + 1) {
//                arr[1] = j + 1; // missing
//            }
//        }
//        return arr;


                // kk method :-

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return new int[] {nums[j],j + 1};
            }
        }
        return new int[]{-1, -1};
    }

    static void swap(int[] arr, int num1, int num2) {
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }

}