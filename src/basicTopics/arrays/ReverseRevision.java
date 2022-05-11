package src.basicTopics.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseRevision {
    public static void main(String[] args) {
        int[] arr = {1, 3, 99, 12, 69};
        System.out.println(Arrays.toString(arr));
        reverse(arr, 0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start = start + 1;
            end = end - 1;
        }
    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }



//    static void swap(int[] arr) { // this code doesn't swap the values in array
//        // this is because i am storing arr[] values in start and end (other variables)
//        // and then swapping the values of that variables and not the actual value of elements inside arr
//        int start = arr[0];
//        int end = arr[arr.length - 1];
//        int temp = start;
//        start = end;
//        end = temp;
//    }
}
