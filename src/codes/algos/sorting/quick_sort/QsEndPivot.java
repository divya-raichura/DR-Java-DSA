package src.codes.algos.sorting.quick_sort;

import java.util.Arrays;

public class QsEndPivot {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 8, 9, 7};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int pi = partition(arr, start, end);
            sort(arr, start, pi - 1);
            sort(arr, pi + 1, end);
        }
    }


    static int partition(int[] arr, int start, int end) {
        int pi = start;
        int pivot = arr[end];
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[pi];
                arr[pi] = arr[i];
                arr[i] = temp;
                pi++;
            }
        }
        int temp = arr[pi];
        arr[pi] = arr[end]; // arr[pi] = pivot;
        arr[end] = temp; // pivot = temp; // this doesn't work as pivot is the value of end element it is not the end element, so pivot's value is changed to temp not arr[end]'s value
        return pi;
    }

}
