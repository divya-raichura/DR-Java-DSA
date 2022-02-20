package questions.binarysearch;

import java.util.Scanner;

public class Ceiling {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = in.nextInt();
        int ans = ceiling(arr, target);
        System.out.println(ans);
    }

    static int ceiling(int[] arr, int target) {

        // but what if the target element is greater than the greatest number of the array
        // then no number in the array is there which is greater than the target number

        if (target > arr[arr.length - 1]) {
            return -1;
        }
        // if this "if" statement was not added, it will return index 7 which does not exist in the array
        // in the floor question this "if" statement is not needed cause without it also it will return -1 automatically

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
        return start;
    }
}
