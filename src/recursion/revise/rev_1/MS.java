package src.codes.recursion.revise;

import java.util.Arrays;

public class MS {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        arr = sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int[] sort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = sort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    static int[] merge(int[] first, int[] sec) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] mix = new int[first.length + sec.length];
        while (i < first.length && j < sec.length) {
            if (first[i] < sec[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = sec[j];
                j++;
            }
            k++;
        }

        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j < sec.length) {
            mix[k] = sec[j];
            j++;
            k++;
        }
        return mix;
    }

}
