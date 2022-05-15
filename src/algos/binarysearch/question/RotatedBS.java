package src.algos.binarysearch.question;
//  https://leetcode.com/problems/search-in-rotated-sorted-array/
import java.util.Scanner;

public class RotatedBS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int[] arr = {4, 5, 6, 7, 0, 1, 2};
//        int[] arr = {3, 5, 1};
        int[] arr = {0, 1, 2, 3, 4, 6, 7};
        System.out.println("index of the pivot is = " + findPivot(arr));
//        System.out.print("input the target = ");
//        int target =  in.nextInt();
//        System.out.println("index of the targeted element is = " + search(arr, target));
    }

    static int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (pivot == -1) {
            // this means the array is not rotated, so do normal BS
            return binarysearch(nums, target, 0, nums.length - 1);
        }
        // if pivot is found, you have two asc sorted arrays, before and after pivot
        if (nums[pivot] == target) {
            return pivot;
        }
        // nums[0] = start element
        if (nums[0] > target) { // V E R Y IMPORTANT NOTE // don't do '>='
        /*
             '>=' here gives error that, if the target element is nums[0] that is,
              the starting element,  but if it is just '>' it gives correct ...
             By debugging I found that cause of '>=' and if target is starting element
             this below return condition executes and the pointers point at pivot+1 and nums.length-1
             which is why we get -1 as these pointers are not correct and doesn't include the starting
             element in it and if we do only '>' this if condition doesn't apply
             next return outside this condition is applied and that is correct but this return is not correct
        */
            return binarysearch(nums, target, pivot + 1, nums.length - 1);
            // start != pivot as nums[0] > target and wkt nums[0] i.e the start element is the smallest largest number
            // in the RHS of the pivot , so obv is start element is greater than the target then
            // the pivot, the largest number is obv greater than target and wkt after pivot, all numbers are smaller
            // than the numbers on rhs of pivot ... see in this example {4,5,6,7,0,1,2,3}
        }
            return binarysearch(nums, target, 0, pivot - 1);


       /*
         The below stuff is not a part of code, like, sirf upar wala ya niche wala dono me se ek hi rahkho
         dusra wala toh alag method explain karneke liye hai
         but in other case if we take opposite of above and do then we need to do target >= nums[0]
         not like above case just '>'
        */
        /*
            if (nums[0] <= target) { // V E R Y IMPORTANT NOTE // don't do only '<' here like above

            //
            '<' here gives error that, if the target element is nums[0] that is,
             the starting element,  but if it is '<=' it gives correct ...
            By debugging I found that cause of '<' and if target is starting element
            the if condition doesn't even execute this time cause target and nums[0] is the same element (as target was the starting element)
            so if '<' it is not true and it doesn't even enter if condition and next outside return executes which is obv wrong
             //

                return binarysearch(nums, target, 0, pivot - 1);
            }
                return binarysearch(nums, target, pivot + 1, nums.length - 1);
        */
    }

    // this will not work for duplicate values
    static int findPivot(int[] arr) {
        int start = 0;
        int end   = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases here (I wrote those in notes)
            if (end > mid && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (start < mid && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[start] >= arr[mid]) { // need >= in any of these third or fourth
                // case for a normal array warna end me when s=e=m,
//       (note: s == m || e == m ek case me hoga sirf, when s = e, hence aage ka reason...)
                // aur ye >= wala nahi hoga infinite loop hojayega
                // as koi cond hi hit nahi hogi aur baar baar loop run hoga

                // <= isliye kyuki already sorted arr ke liye, found this during debug
                end = mid - 1;
            } else { // upar >= nahi kiya toh chalega, kyuki ye else hai, agar alag se if likha aur dono me >= nahi dala toh aisa scene hoga
                start = mid + 1; // not start == mid? kyuki agar mid ans hota toh we would have caught  it in first two cases
//     so mid ans nahi hai even if mid>=start  as mid ans hota toh 1st two cases me pakad me ajata hai
//     isliye ye dono 3rd and 5th cases me mid+1/mid-1 kiya as mid hota toh pehle 2 cases me pakad me ajata
            }
        }
        return -1;
    }
    static int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end   = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases here (I wrote those in notes)
            if (end > mid && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (start < mid && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            // if  elements at middle, start and end are equal then just skip the duplicates
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                // skip the duplicates in this case

                // NOTE: But, what if the elements start and end were the pivots??
                // So, check if start is pivot
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // Now, check if end is pivot
                if (arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // left side is sorted, so the pivot should be in right
            // 2,9,2
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1; // {2, 2, 9, 1} jaise arr ke liye 2nd || wala condn
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    static int binarysearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            // find the middle element's index
            // int mid = ( start + end ) / 2; // might be possible that (start + end) exceeds the range of 'int' in java so we will use modified formula
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) { // then target lies on left side of mid, and start point will remain same but end point will become one index less than mid
                end = mid - 1;
            } else if (target > arr[mid]) { // then target lies on right side of mid, and end point will remain same but start point will become one index more than mid
                start = mid + 1;
            } else {
                return mid; // we studied in func that whenever return statement is hit the function exits and it goes in psvm... khatam tata bye bye
            }
        }
        // if any above conditions doesn't come true that means the target element is not found, and in that case we need to return -1
        return -1;
    }
}
