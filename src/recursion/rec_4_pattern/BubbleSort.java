package src.codes.recursion.rec_4_pattern;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 0, -3, 5, 1};
        int[] arr2 = {1, 2, 3, 4, 5};
//        bubbleRecUsingPatternApproach(arr, arr.length-1, 1);
        bubbleRec(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleRecUsingPatternApproach(int[] arr, int i, int j) {
        if (i == 0) {
            return;
        }
        if (j <= i) {

            if (arr[j] < arr[j - 1]) {
                // swap
                swap(arr, j, j - 1);
            }

            bubbleRecUsingPatternApproach(arr, i, j + 1);
        } else {
            bubbleRecUsingPatternApproach(arr, i - 1, j = 1);
        }
    }

    static void bubbleRec(int[] arr, int i, int j) {

        if (i > arr.length - 1) {
            return;
        }

        if (j < arr.length - i) {
            if (arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                bubbleRec(arr, i, j + 1);
            } else {
                bubbleRec(arr, i, j + 1);
            }
        } else {
            bubbleRec(arr, i + 1, j = 1);
        }
    }



    static void bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    static void swap(int[] arr, int num1, int num2) {
        int temp = arr[num2];
        arr[num2] = arr[num1];
        arr[num1] = temp;
    }

}
