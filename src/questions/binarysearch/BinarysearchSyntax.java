package questions.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class BinarysearchSyntax {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {99, 98, 84, 31, 12, 1, 0, -16, -23};
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 99, 443, 677};
        int target = in.nextInt();
        int ans = binarySearchNormalSyntax(nums, target);
        System.out.println(ans);
    }

    static int binarySearchOrderAgnoSyntax(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    static int binarySearchNormalSyntax(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
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
