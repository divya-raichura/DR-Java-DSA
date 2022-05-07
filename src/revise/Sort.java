package src.revise;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 4, 2};
        int[] num = {35, 52, 11, 0, -13, 532, 14, -41, 52, 555, -352, -32, 51, -3, -14, 5};
//        bubble(arr);
        selection(num);
//        System.out.println(Arrays.toString(num));
        
    }


    static void selection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = max(arr, 0, arr.length - 1 - i);
            swap(arr, maxIndex, arr.length - 1 - i);
        }
    }

    static int max(int[] arr, int start, int end) {
        int max_ans = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > arr[max_ans]) {
                max_ans = i;
            }
        }
        return max_ans;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
