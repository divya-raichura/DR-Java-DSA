package myPractice;

// https://leetcode.com/problems/largest-perimeter-triangle/

import java.util.Arrays;

public class PerimeterSorting {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        System.out.println(perimeterLargest(arr));
    }

    static int perimeterLargest(int[] arr) {
        Arrays.sort(arr); // can use bubble sort
        for (int i = arr.length - 1; i-1>= 0 && i-2 >=0 ; i--) {
            if ( arr[i - 1] + arr[i - 2] > arr[i]) {
                return arr[i - 1] + arr[i - 2] + arr[i];
            }
        }
        return 0;
    }

    // leetcode solution from discussion
        static int largestPerimeter(int[] nums) {
            Arrays.sort(nums);

            for(int i = nums.length - 3; i >= 0; i--) {
                if(nums[i] + nums[i + 1] > nums[i + 2])
                    return nums[i] + nums[i + 1] + nums[i + 2];
            }
            return 0;
        }
}
