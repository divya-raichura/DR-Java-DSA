package src.codes.algos.sorting.bubble_sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
//        int[] arr = {5, 2, 6, 8, 1}; // 1,2,5,6,8
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        // run the outer loop n-1 times
        boolean swapped; // if arr was already sorted then also it checked for all 'i'
        // hence this boolean so that it will check for 1st 'i' and then end, and also for some array in which it gets
        // sorted at i=2; so that it doesn't need to check for further 'i'

        for (int i = 0; i < arr.length-1; i++) { // kk ne i<arr.length kiya tha

            // run the swap loop till < length-i
            swapped = false;

            for (int j = 1; j < arr.length - i; j++) { // or j <= arr.length - i - 1

                // swap condition
                if (arr[j] < arr[j - 1]) {
//                    swap(arr, arr[j], arr[j - 1]); // NOT NEEDED
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true; // as if it entered this if condn, this means it was swapped
                } // and we need to break only if it doesn't swap, ie swapped == false
            }
            // if swapped == false matlab ek bhi 'j' ke value ke liye swap nahi hua
            // which eventually means ki array is already sorted and no need to check
            // for other values of 'i'
            if (!swapped) { // !swapped --> swapped == false
                break;
            }
        }
    }
}
    // not needed
//    static void swap(int[] arr, int num1, int num2) { // num1 = 5, num2 = 25
//        int temp = num1; // temp = 5, num1 = 5, num2 = 25
//        num1 = num2; // num1 = 25, temp = 5, num2 = 25
//        num2 = temp; // num1 = 25, num2 = 5, temp = 5
//        // num1 = 25, num2 = 5
//    }
//}
