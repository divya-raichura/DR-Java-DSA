package src.questions.binarysearch;

//  https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

import java.util.Arrays;
import java.util.Scanner;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = {2, 3, 3, 7, 7, 8, 7, 8, 9, 20};
        int target = in.nextInt();
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
    static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        // check for the first occdurrence if target first
        ans[0] = search(nums, target, true); // log N time complexity
        if (ans[0] != -1) {
            ans[1] = search(nums, target, false); // log N time complexity
        }
        // so if the 'if' condition is satisfied then the time complexity is ...
        // log N + log N = 2 * log N , but it is not "2 * log N" it is "log N" only
        // this is because constants are ignored in time complexity
        // hence 2 which is a constant, is ignored
        return ans;
    }


    static int search(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target){
                start = mid + 1;
            } else {
                // potential ans
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
