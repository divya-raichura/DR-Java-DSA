package src.codes.algos.sorting.selection_sort;

import java.util.Arrays;
import java.util.Stack;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, -1, 0, 39, -13, 3};
//        selectionMin(arr);
//        System.out.println(Arrays.toString(arr));
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

    static void selectionMin(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // i<arr.length-1 hona chahiye
            int minIndex = getminIndex(arr, i, arr.length - 1);
            swap(arr, minIndex, i);
        }
    }



    static int getminIndex(int[] arr, int start, int end) {
        int min = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        return min;
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
