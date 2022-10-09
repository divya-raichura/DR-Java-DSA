package lectures.arrays;

import java.util.Arrays;

public class Max {
    public static void main(String[] args) {
        int[] arr = {2, 45, 32, 55, 23};
//        int ans = max(arr);
//        System.out.println(ans);

        int ans2 = maxRange(arr, 1, 3);
        System.out.println(ans2);
//        or directly  after int[] arr... you can do sout(max(arr))
//        System.out.println(max(arr));
    }

    // imagine that the array is not empty
     static int max(int[] arr) {
        int MaxVal = arr[0];
         for (int i = 1; i < arr.length; i++) {
             if (arr[i] > MaxVal) {
                 MaxVal = arr[i];
             }
         }
         return MaxVal;
    }

    // if you want the maximum number in range like between 1st index and 3rd index
    static int maxRange(int[] arr, int start, int end) {
        int maxval = arr[start];
        for (int i = start; i <= end; i++) {
            if (arr[i] > maxval ) {
                maxval = arr[i];
            }
        }
        return maxval;
    }
}
