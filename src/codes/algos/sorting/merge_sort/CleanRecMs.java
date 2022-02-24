package src.codes.algos.sorting.merge_sort;

import java.util.Arrays;

public class CleanRecMs {
    public static void main(String[] args) {
        int[] arr = {6, 1, 23, 3, 0};
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int m = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, m));
        int[] right = mergeSort(Arrays.copyOfRange(arr, m, arr.length));

        return mergeArr(left, right);
    }

    static int[] mergeArr(int[] first, int[] second) {
        int i = 0;
        int j = 0;

        int[] mix = new int[first.length + second.length];
        int k = 0;

        while (first.length > i && second.length > j) {

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
