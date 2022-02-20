package questions.binarysearch;

import java.util.Scanner;

public class SearchInMounArrRev {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {1, 2,4, 5, 3, 1};
        System.out.print("Enter a number : ");
        int target = in.nextInt();
        System.out.println(search(arr,target));
    }


     static int search(int[] arr, int target) {
        int peak = mountainArrayIndex(arr);
        // searching in first half, before peak
        int firstTry = binarySearchOrderAgnoSyntax(arr, target, 0, peak);
        if (firstTry != -1) {
            return firstTry;
        }
        // if ans not found, now search in second half which is after peak
        return binarySearchOrderAgnoSyntax(arr, target, peak + 1, arr.length - 1);
    }

    // wrong approach below

//    static int search(int[] arr, int target) {
//        int peak = mountainArrayIndex(arr);
//        if (target <= arr[peak]) { // this will not work as, 3 peak ke baad hai
//            // and 3<arr[peak] so ye code run hoga asc(lhs) ke liye but udr 3 hai
//            // hi nahi and so, wrong ans
//            return binarySearchOrderAgnoSyntax(arr, target, 0, peak);
//        } else {
//            return binarySearchOrderAgnoSyntax(arr, target, peak + 1, arr.length - 1);
//        }
//    }

    static int binarySearchOrderAgnoSyntax(int[] arr, int target, int start, int end) {


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

    static int mountainArrayIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid + 1] > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start; // or return end, doesnt matter as when ans is found, start==end
    }


    // can't do normal search as agar peak ke baad ans hoga toh ye niche
    // wala search asc order ke liye hai aur peak ke baad des order hai
    // so peak ke baad ans hua toh des wala search lagana padega aur hence
    // we need order agnostic

//    static int binarySearchNormalSyntax(int[] arr, int target, int start, int end) {
//
//        while (start <= end) {
//            // find the middle element's index
//            // int mid = ( start + end ) / 2; // might be possible that (start + end) exceeds the range of 'int' in java so we will use modified formula
//            int mid = start + (end - start) / 2;
//
//            if (target < arr[mid]) { // then target lies on left side of mid, and start point will remain same but end point will become one index less than mid
//                end = mid - 1;
//            } else if (target > arr[mid]) { // then target lies on right side of mid, and end point will remain same but start point will become one index more than mid
//                start = mid + 1;
//            } else {
//                return mid; // we studied in func that whenever return statement is hit the function exits and it goes in psvm... khatam tata bye bye
//            }
//        }
//        // if any above conditions doesn't come true that means the target element is not found, and in that case we need to return -1
//        return -1;
//    }
}
