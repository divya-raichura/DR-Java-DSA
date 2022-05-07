package questions.binarysearch;

import java.util.Scanner;

public class SplitArrRev {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = {7, 2, 5, 10, 8};
        System.out.print("Enter m : ");
        int m = in.nextInt();
        System.out.println(splitArray(nums, m));
    }

    static int splitArray(int[] nums, int m) {
        int start = Integer.MIN_VALUE;
        int end   = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > start) {
                start = nums[i];
            }
            end = end + nums[i];
        }
        while (start < end) {
            int mid = start + (end - start) / 2;

            // calculate how many pieces you can divide into if this mid is max sum
            int sum = 0; //
            int pieces = 1;
            for (int num : nums) {
                if (sum + num > mid) { // was misunderstanding here that mid is index of mid in num
                    // array, see, like other q's, here mid is element in array, not the index of mid
                    // so if s = 10, e = 32, then mid = 21 not the index of 21 or index of mid of
                    // nums array.
                    // u cannot add this in this in this subarray, make a new one
                    // say u add this num in new subarray, then sum = num
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }
            if (pieces > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end; // here start == end
    }
}
