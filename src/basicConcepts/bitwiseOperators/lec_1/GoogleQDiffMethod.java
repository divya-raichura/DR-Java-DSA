package src.concepts.bitwiseOperators.lec_1;

import java.util.Arrays;

public class GoogleQDiffMethod {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(arr)));
    }


    // to do xor while swapping
    // best solution ==> 100% faster
    static int[][] flipAndInvertImage(int[][] arr) {
        for (int[] ints : arr) {
            swap(ints);
        }
        return arr;
    }

    static void swap(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int temp = arr[start] ^ 1;
            arr[start] = arr[end] ^ 1;
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
