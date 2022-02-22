package com.topics.recursion.array_rec_lec2;

import java.util.Arrays;

public class Sorted {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
//        System.out.println(check(arr));
//        System.out.println(check2(arr));
//        System.out.println(recCheck(arr, 0));
        System.out.println(sortedRecursion(arr, 0));

    }



    // kk
    static boolean sortedRecursion(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }

        return (arr[index] < arr[index + 1]) && sortedRecursion(arr, index + 1);
    }



    // my try
    static boolean recCheck(int[] arr, int start) {
        if (arr.length == 1) {
            return true;
        }

        if (start == arr.length - 1) {
            return true;
        }

        if (arr[start] > arr[start + 1]) {
            return false;
        }

        return recCheck(arr, ++start);

    }

    static boolean check(int[] arr) {
        if (arr.length == 1) {
            return true;
        }

        int start = 0;
        int end = start + 1;
        while (end < arr.length) {
            if (arr[start] > arr[end]) {
                return false;
            }
            start++;
            end++;
        }
        return true;
    }

    static boolean check2(int[] arr) {
        if (arr.length == 1) {
            return true;
        }

        int start = 0;
        while (start + 1 < arr.length) {
            if (arr[start] > arr[start + 1]) {
                return false;
            }
            start++;
        }
        return true;
    }

}
