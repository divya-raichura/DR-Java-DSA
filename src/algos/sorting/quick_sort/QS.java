// package src.algos.sorting.quick_sort;

import java.util.Arrays;

// https://www.youtube.com/watch?v=0SkOjNaO1XY&ab_channel=CSDojo
public class QSpreferred {
    public static void main(String[] args) {
        int[] arr = {5, 0, 21, 45, 24};
        qs(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void qs(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        qs(arr, l, p - 1);
        qs(arr, p + 1, r);
    }

    static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] < pivot) {
                i += 1;
                swap(arr, j, i);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
