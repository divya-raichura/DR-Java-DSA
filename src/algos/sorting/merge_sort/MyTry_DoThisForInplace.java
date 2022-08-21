package src.algos.sorting.merge_sort;

import java.util.Arrays;

// BEST

public class MyTry_DoThisForInplace {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,9};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int s, int e) {
        if (e > s) {
            int m = (s + e) / 2;
            sort(arr, s, m);
            sort(arr, m + 1, e);
            merge(arr, s, m, e);
        }
    }
/*
     static void merge(int[] arr, int s, int m, int e) {
        int i = s;
        int j = m + 1;
        int[] mix = new int[e - s + 1];

        for (int l = 0; l < mix.length; l++) {
            if (i > m) {
                mix[l] = arr[j++];
            } else if (j > e) {
                mix[l] = arr[i++];
            } else if (arr[i] > arr[j]) {
                mix[l] = arr[j++];
            } else {
                mix[l] = arr[i++];
            }
        }

        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }
    }

 */
    static void merge(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s + 1];
        int i = s;
        int j = m + 1;
        int k = 0;
        while (i <= m && j <= e) {
            if (arr[i] <= arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= m) {
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j <= e) {
            mix[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }
    }
}
