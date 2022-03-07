package src.codes.recursion.practice;

import java.util.Arrays;

public class Sorted {
    public static void main(String[] args) {
        int[] arr = {1};
//        System.out.println(sort(arr, 0));
    }

    static boolean sort(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }
        return arr[index + 1] > arr[index] && sort(arr, index + 1);
    }

    static boolean sorting(int[] arr, int i) {

        if (i == arr.length - 1) {
            return true;
        }

        if (arr[i + 1] < arr[i]) {
            return false;
        }
        return sorting(arr, i + 1);
    }

}
