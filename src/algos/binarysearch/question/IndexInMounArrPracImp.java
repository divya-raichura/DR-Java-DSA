package src.algos.binarysearch.question;

import java.util.Arrays;
import java.util.Scanner;

public class IndexInMounArrPracImp {
    public static void main(String[] args) {
        int[] arr = {0, 4, 8, 12, 13, 14, 11, 10, 9, 5, 1};
        int[] nums = {0, 1, 0};
        System.out.println(mountainArray(arr));
    }

    static int mountainArray(int[] arr) {
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
}