package src.algos.binarysearch.question;

//  https://leetcode.com/problems/peak-index-in-a-mountain-array/

public class MountainArray {
    public static void main(String[] args) {
        int[] arr = {0, 10, 5, 0};
        System.out.println(peakIndexInMountainArray(arr));
    }
    static int peakIndexInMountainArray(int[] nums) {
        int start = 0;
        int end   = nums.length - 1;
        while (start < end) { // we don't put "<=" as the loop will continue running infinitely at the end when start=mid=end as it will say start =end so enter loop and then end=mid but start=mid=end already so it will keep running like this
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // you are in the dec part of the array
                // this may be the ans but check in lhs
                // it may be the ans and this is why we didn't say
                // end = mid - 1;
                end = mid;
            } else {
                // you are in the asc part of the array
                start = mid + 1; // bec we know that mid + 1 ele > mid ele hence, we ignore the mid ele
            }
             /*
            in the end, start == end and pointing to the largest number cause of the two checks above
             start and end are always trying to find max element in above two checks
             hence when they are pointing to just one element that is the maximum one because that is what the checks say
             more elaboration: at every point of time for start and end, they have the best possible ans till that time
             and if we are saying that only one item is remaining, hence cuz of above line that is the best possible ans
             */
        }
        return start; // or return end as both are equal
    }
}
