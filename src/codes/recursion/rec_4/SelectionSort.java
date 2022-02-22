package src.codes.recursion.rec_4;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3, 0, -3, 5, 1};
        System.out.println(Arrays.toString(arr));
//        selection(arr);
//        recursionSelection(arr, 0);
        selectionPatternApproach(arr, arr.length, 0, 0); // max is the index of the maximum element in the array
        System.out.println(Arrays.toString(arr));
    }


    static void selectionPatternApproach(int[] arr, int r, int c, int max) {
        if (r == 0) { // why not r == 1
            return;
        }
        if (c < r) {
            if (arr[c] > arr[max]) {
                selectionPatternApproach(arr, r, c + 1, c);
            } else {
                selectionPatternApproach(arr, r, c + 1, max);
            }
        } else {
            int temp = arr[max];
            arr[max] = arr[r - 1];
            arr[r - 1] = temp;
            selectionPatternApproach(arr, r - 1, c = 0, 0);
        }
    }





    static void recursionSelection(int[] arr, int i) {

        if (i == arr.length - 1) {
            return;
        }

        int last = arr.length - i -1;
        int maxIndex = max(arr, 0, last);
        swap(arr, last, maxIndex);
        recursionSelection(arr, ++i);
    }

    static void selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i -1;
            int maxIndex = max(arr, 0, last);
            swap(arr, last, maxIndex);
        }
    }

    static int max(int[] arr, int s, int e) {
        int maxIndex = s;
        for (int i = s + 1; i <= e; i++) {
            if (arr[maxIndex] < arr[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static void swap(int[] arr, int num1, int num2) {
        int temp = arr[num2];
        arr[num2] = arr[num1];
        arr[num1] = temp;
    }

}
