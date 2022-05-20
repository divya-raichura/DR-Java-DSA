package com.company.revision;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 5, 4, 3, 2, 1};
//        int[] ans = mergeSort(arr);
//        System.out.println(Arrays.toString(ans));
//        mergeSortInPlace(0, arr.length - 1, arr);
//        System.out.println(Arrays.toString(arr));
    }

    static void mergeSortInPlace(int s, int e, int[] arr) {
        if (e > s) {
            int m = (s + e) / 2;
            mergeSortInPlace(0, m, arr);
            mergeSortInPlace(m + 1, e, arr);
            mergeInPlace(s, e, arr, m);
        }
    }

    static void mergeInPlace(int s, int e, int[] arr, int m) {

        int[] mix = new int[e - s + 1];
        int i = s;
        int j = m + 1;
        int k = 0;
        while (i <= m && j <= e) {
            if (arr[i] < arr[j]) {
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

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] l = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] r = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(l, r);
    }

    static int[] merge(int[] l, int[] r) {
        int i = 0;
        int j = 0;
        int[] mix = new int[l.length + r.length];
        int k = 0;
        while (i < l.length && j < r.length) {
            if (l[i] < r[j]) {
                mix[k] = l[i];
                i++;
            } else {
                mix[k] = r[j];
                j++;
            }
            k++;
        }

        while (i < l.length) {
            mix[k] = l[i];
            i++;
            k++;
        }

        while (j < r.length) {
            mix[k] = r[j];
            j++;
            k++;
        }

        return mix;
    }
}


