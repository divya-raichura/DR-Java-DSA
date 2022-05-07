package src.algos.sorting.merge_sort;

import java.util.Arrays;

public class MsBook {

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 1, 3, 2};
        mergesort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void mergesort(int[] array) {
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length - 1);
    }


    static void mergesort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergesort(array, helper, low, middle); // Sort left half
            mergesort(array, helper, middle + 1, high); // Sort right half
            merge(array, helper, low, middle, high); // Merge them
        }
    }


    static void merge(int[] array, int[] helper, int low, int middle, int high) {
        /* Copy both halves into a helper array*/
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

         /* Iterate through helper array. Compare the left and right half, copying back
        the smaller element from the two halves into the original array.*/
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                array[k] = helper[i];
                i++;
            } else {//If right element is smaller than left element
                array[k] = helper[j];
                j++;
            }
            k++;
        }

        /* Copy the rest of the left side of the array into the target array*/
        int remaining = middle - i;
        for (int a = 0; a <= remaining; a++) {
            array[k + a] = helper[i + a];
        }
    }
}
