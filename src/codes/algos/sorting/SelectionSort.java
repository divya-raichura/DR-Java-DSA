package lectures.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        Arrays.sort(arr);
    }

    static void selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // i<arr.length-1 hona chahiye
            int last = arr.length - i - 1;
            int maxIndex = getmaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);
        }
    }

    static int getmaxIndex(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }

    static void swap(int[] arr, int num1, int num2) {
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }
}
