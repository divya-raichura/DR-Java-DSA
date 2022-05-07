package src.algos.sorting.quick_sort;

import java.util.Arrays;

public class QSkk {
    public static void main(String[] args) {
        int[] num = {5, 0, 21, 45, -24};
        int[] arr = {1, 2, 3, 4, 5};
        sort(num, 0, num.length - 1);
        System.out.println(Arrays.toString(arr));
//        Arrays.sort(arr);
    }

    static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int s = l;
        int e = r;
        int m = s + (e - s) / 2;
        int pivot = arr[m];

        while (s <= e) {

            // also a reason why if its already sorted it will not swap
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }

            if (s <= e) { // if we do < & not <= then at the end when s == e,
//  this condition will not hit & so s++ and e-- will not hit and the while loop will keep running
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        // now pivot is at correct index sort two halves
        sort(arr, l, e);
        sort(arr, s , r);
    }
}
