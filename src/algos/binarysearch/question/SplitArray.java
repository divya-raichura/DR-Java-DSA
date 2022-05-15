package src.algos.binarysearch.question;

import java.util.Scanner;

//   https://leetcode.com/problems/split-array-largest-sum/

public class SplitArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = {7, 5, 2, 10, 8};
        int m = in.nextInt();
        System.out.println(splitArray(nums, m));
    }

    static int splitArray(int[] nums, int m) {
        int start = 0; // start is max element in the array
        int end = 0; // end is the sum of all elements in the array

        // Here, we divide the array into pieces.
        // If pieces <= m, then we increase the value of mid, else we decrease the value of mid.

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); // in the end of the loop it will contain the max item from the array
            end = end + nums[i];
        }
        // binary search as we have the range now
        while (start < end) { // why not "<=" ? cause when start==end, it will be our ans lol, so at end we return it and no put '<=' here
            // try for the middle as potential answer
            int mid = start + (end - start) / 2;

            // calculate how many pieces you can divide this in with this max sum
            int sum = 0;
            int pieces = 1; // initially you can divide it in atleast in one piece
            for (int num : nums) { // this means for every number in the nums array
                if (sum + num > mid) {
                    // you cannot add this in this sub array, make new one
                    // say you add this num in  new sub array, then sum = num
                    sum = num; // to understand this watch lec @3hr 56min or see my notes
                    pieces++;
                } else {
                    // keep adding
                    sum += num;
                }
            }
            // If pieces <= m, then we increase the value of mid, else we decrease the value of mid.
            if (pieces > m) {
                start = mid + 1; // why not "start = mid" just like "end = mid"
            } else {
                end = mid;
            }
        }
        return start; // here we can also return 'end' as 'start == end'
    }
}
