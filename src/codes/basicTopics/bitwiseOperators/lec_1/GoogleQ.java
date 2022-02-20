package bitwiseOperators.lec_1;

import java.util.Arrays;


// https://leetcode.com/problems/flipping-an-image/
public class GoogleQ {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,0,0},
                {1,0,0,1},
                {0,1,1,1},
                {1,0,1,0}
        };
//        main(arr);
        // convert public to static in order to use this
//        System.out.println(Arrays.deepToString(flipAndInvertImage(arr)));
//        System.out.println(Arrays.deepToString(flipAndInvertImage2(arr)));
    }

// my try - successful
    static void main(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            swap(arr[row]);
            for (int col = 0; col < arr[0].length; col++) {
                arr[row][col] ^= 1;
            }
        }
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }

// my method hi hai, used this to submit on leetcode
    static int[][] flipAndInvertImage(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            swap(arr[row]);
            for (int col = 0; col < arr[0].length; col++) {
                arr[row][col] ^= 1;
            }
        }
        return arr;
    }

    static void swap(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // kk method
    static int[][] flipAndInvertImage2(int[][] arr) {
        for (int[] row : arr) {
            for (int i = 0; i < (arr[0].length + 1) / 2; i++) {
                // swap along with doing xor(to reverse)
                int temp = row[i] ^ 1;
                row[i] = row[arr[0].length - i - 1] ^ 1;
                row[arr[0].length - i - 1] = temp;
            }
        }
        return arr;
    }

}
