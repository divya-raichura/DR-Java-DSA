package src.codes.algos.sorting.quick_sort;

import java.util.Arrays;

public class QSkk {
    public static void main(String[] args) {
        int[] num = {5, 0, 21, 45, -24};
        int[] arr = {1, 2, 3, 4, 5};
        sort(num, 0, num.length - 1);
        System.out.println(Arrays.toString(arr));
//        Arrays.sort(arr);
    }

    static void sort(int[] nums, int low, int hi) {
        if (low >= hi) {
            return;
        }

        int s = low;
        int e = hi;
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        while (s <= e) {

            // also a reason why if its already sorted it will not swap
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }

            if (s <= e) { // if we do < & not <= then at the end when s == e,
//  this condition will not hit & so s++ and e-- will not hit and the while loop will keep running
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }

        // now my pivot is at correct index, please sort two halves now
        sort(nums, low, e);
        sort(nums, s , hi);
    }
}
