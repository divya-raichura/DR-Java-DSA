package src.algos.sorting.insertion_sort;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int[] arr = {2, 235, 54, 1, 0, -14, 5, 5, 6, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0 ; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
