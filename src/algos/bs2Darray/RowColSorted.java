package lectures.bs2Darray;

import java.util.Arrays;
import java.util.Scanner;


        // In matrix related qs always think how ccan u reduce rows and cols
        // and minimize the search space

public class RowColSorted {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };
        int target = in.nextInt();
        System.out.println(Arrays.toString(search(arr, target)));
        // time complexity is bigo of N
        // as col wise 'n' and row wise 'n' so total = '2n'
        // and constants are ignored so complexity = bigo of n
    }

    static int[] search(int[][] arr, int target) {
        int row = 0;
        int col = arr[row].length - 1;

        while (row < arr.length && col >= 0) {
            if (target == arr[row][col]) {
                return new int[]{row, col};
            }
            if (target > arr[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return new int[]{-1, -1};
    }
}
