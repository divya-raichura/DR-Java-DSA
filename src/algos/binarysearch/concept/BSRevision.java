package src.algos.binarysearch.concept;

import java.util.Scanner;

public class BSRevision {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {-18, -9, -5, -1, 0, 2, 4, 24, 55, 64, 69, 78, 83, 99};
        int target = in.nextInt();
        int ans = binary(arr, target);
        System.out.println(ans);
    }

    static int binary(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        // int mid = start + (end - start) / 2; // mistake- here when loop is running,
        // midvalue is never updated and we keep using same mid value, hence we need to
        //  put this inside the loop
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) { // then target lies on left side of mid, and start point will remain same but end point will become one index less than mid
                    end = mid - 1;
                } else { // then target lies on right side of mid, and end point will remain same but start point will become one index more than mid
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) { // then target lies on left side of mid, and start point will remain same but end point will become one index less than mid
                    end = mid - 1;
                } else { // then target lies on right side of mid, and end point will remain same but start point will become one index more than mid
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
