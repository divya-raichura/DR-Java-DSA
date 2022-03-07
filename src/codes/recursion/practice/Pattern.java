package src.codes.recursion.practice;

import java.util.Arrays;

public class Pattern {
    public static void main(String[] args) {
        int[] arr = {55, -34, 4, 3, 2, 1, 0};
//        bubblepat(arr, 6, 0); // row == arr.length - 1, col = 0
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }




    static void selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int maxIndex = mI(arr, 0, last);
            swap(arr, last, maxIndex);
        }
    }

    static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

    static int mI(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }

    static void bubblepat(int[] arr, int row, int col) {
        if (row <= 0) {
            return;
        }
        if (row == col) {
            bubblepat(arr, row - 1, 0);
        } else {
            if (arr[col] > arr[col + 1]) {
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }
            bubblepat(arr, row, col + 1);
        }
    }

    static void pat(int row, int col) {
        if (row <= 0) {
            return;
        }
        if (row == col) {
            System.out.println();
            pat(row - 1, 0);
        } else {
            System.out.print("* ");
            pat(row, col + 1);
        }
    }

    static void pat2(int row, int col) {
        if (row <= 0) {
            return;
        }
        if (row == col) {
            pat2(row - 1, 0);
            System.out.println();
        } else {
            pat2(row, col + 1);
            System.out.print("* ");
        }
    }

    static void pat3(int row, int col) {
        if (row <= 0) {
            return;
        }
        if (row == col) {
            System.out.println();
            pat3(row - 1, 0);
            System.out.println();
        } else {
            System.out.print("* ");
            pat3(row, col + 1);
            System.out.print("* ");
        }
    }
}
