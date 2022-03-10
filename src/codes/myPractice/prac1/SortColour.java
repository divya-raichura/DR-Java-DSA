package myPractice;

// https://leetcode.com/problems/sort-colors/

import java.util.Arrays;

public class SortColour {
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        // call function -->
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }


    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }




    // leetcode solutions(most voted ones) :-

    static void sortColors(int[] nums) {
        // 1-pass
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                // p1 pe jo element hai usko index ko de denge aur p1 pe 0 dalenge
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2]; // matlab nums[p2] pe jo no hai woh ab nums[index]
                // pe aajayega aur agle step me p2 ko 2 de dete hai
                nums[p2] = 2;
                p2--;
                index--; // ye dala kyuki niche wala index++ balance karna tha
            }
            index++;
        }
    }

    static void sortColors2(int[] nums) {
        // 2-pass
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {count0++;}
            if (nums[i] == 1) {count1++;}
            if (nums[i] == 2) {count2++;}
        }
        for(int i = 0; i < nums.length; i++) {
            if (i < count0) {nums[i] = 0;}
            else if (i < count0 + count1) {nums[i] = 1;}
            else {nums[i] = 2;}
        }
    }

    static void sortColours3(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return;
        }


        int left = 0;
        int right = len - 1;
        int current = 0;

        while (current <= right) {

            if (arr[current] == 0) {
//                swap(nums, left, current);
                left++;
                current++;
            } else if (arr[current] == 1) {
                current++;
            } else {
//                swap(arr, right, current);
                right--;
            }

        }
    }

}
