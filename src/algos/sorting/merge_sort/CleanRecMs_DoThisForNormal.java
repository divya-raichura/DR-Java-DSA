package src.algos.sorting.merge_sort;

import java.util.Arrays;

public class CleanRecMs_DoThisForNormal {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 1, 3, -12, 0, -124};
//        int[] arr = {8, 4, 5, 1, 3, 2};
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int m = arr.length / 2; // (arr.length - 1) / 2 then we can do 0 to m and m + 1 to last
        // ie below, we can do from 0 to m + 1 (exclusive, so m) and m to length(exclusive so len - 1)

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, m));
        int[] right = mergeSort(Arrays.copyOfRange(arr, m, arr.length));

        // if m is changed then error
//        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, m + 1));
//        int[] right = mergeSort(Arrays.copyOfRange(arr, m + 1, arr.length));

        // if m is decreased instead, then also error
//        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, m - 1));
//        int[] right = mergeSort(Arrays.copyOfRange(arr, m - 1, arr.length));
        return mergeArr(left, right);
    }

    static int[] mergeArr(int[] first, int[] second) {

        int i = 0;
        int j = 0;

        int[] mix = new int[first.length + second.length];
        int k = 0;

//        while (first.length > i && second.length > j) {
        while (i < first.length && j < second.length) {

            if (first[i] < second[j]) {
                mix[k] = first[i];
                i += 1;
            } else {
                mix[k] = second[j];
                j += 1;
            }

            k += 1;
        }

        // if one of the arrays is not complete

        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }
}
