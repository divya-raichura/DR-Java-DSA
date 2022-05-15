package src.algos.binarysearch.question;

//  https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

import java.util.Scanner;

public class InfiniteArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {1, 2, 4, 6, 9, 10, 13, 56, 65, 82, 109, 356, 366};
        int target = in.nextInt();
//        System.out.println(ans(arr, target));
        int end = 0;
        int temp = end;
        end = 9;
        System.out.println(temp);
        System.out.println(end);
    }

    static int ans(int[] arr, int target) {
        // first find the range
        // first start with the box of size 2 & then keep doubling till
        // target element > end element
        int start = 0;
        int end   = 1;

        // condition for the target to lie in the range
        while (target > arr[end]) {
            int temp = end + 1; // this is the new start
            // double the box value
            // end = previous end + size of box * 2
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return binarysearch(arr, target, start, end);
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
