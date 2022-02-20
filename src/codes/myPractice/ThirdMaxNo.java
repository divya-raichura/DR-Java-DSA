package myPractice;

// https://leetcode.com/problems/third-maximum-number/
public class ThirdMaxNo {
    public static void main(String[] args) {

    }


    // leetcode mindblowing solution
    public int thirdMax(int[] nums) {

        // use long data tyoe because, the constraint includes Integer.MIN_VALUE and Integer.MAX_VALUE;
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;

        // if nums has only one element
        if (nums.length == 1) {
            return nums[0];
        }
        // if nums has only two elements
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // use 3 variables to keep track of first maximum, second maximum and third maximum
        for (int num : nums) {
            if (num > max1) {
                max1 = num;
                max2 = max1;
                max3 = max2;
            } else if (num > max2 && num != max1) {
                max2 = num;
                max3 = max2;
            } else if (num > max3 && num != max1 && num != max2) {
                max3 = num;
            }

        }

        // at the end if thr third max is still Long.MIN_VALUE, it means there are no 3 distinct element in
        // nums. So we return the maximum as specified on the question
        if (max3 == Long.MIN_VALUE) {
            return (int) max1;
        }
        return (int) max3;
    }
}
