package lectures.bs2Darray;

import java.util.Arrays;
import java.util.Scanner;

public class SortedMatrixKK {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int target = in.nextInt();
        System.out.println(Arrays.toString(search(arr, target)));
    }

    static int[] binarySearch(int[][] matrix, int target, int row, int colStart, int colEnd) {
        while (colStart <= colEnd) {
            int mid = colStart + (colEnd - colStart) / 2;
            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            }
            if (matrix[row][mid] > target) {
                colEnd = mid - 1;
            } else {
                colStart = mid + 1;
            }
        }
        return new int[]{-1 - 1};
    }

    static int[] search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows == 1) {
            return binarySearch(matrix, target, 0, 0, cols - 1);// colEnd != matrix[0].length - 1 // my mistake, actually not mistake, but cols banaya hai toh phir kyu
        }

        // now we, have to perform binary search on the middle col
        int rStart = 0;
        int rEnd = rows - 1;
        int colMid = cols / 2;

        // run the loop till 2 rows are remaining
        while (rStart < (rEnd - 1)) { // while this is true, it will have more than 2 rows which we are tryn to eliminate
            int rmid = rStart + (rEnd - rStart) / 2;

            if (target == matrix[rmid][colMid]) {
                return new int[]{rmid, colMid};
            }

            if (target > matrix[rmid][colMid]) {
                rStart = rmid;
            } else {
                rEnd = rmid;
            }
        }

        // so now, we have two rows remaining
        // check whether target is in col of 2 rows matlab, jo colMid me search karre thee, ab usme
        // 2 rows bache usme check karo fir baki ke 4 portions me
        if (matrix[rStart][colMid] == target) {
            return new int[]{rStart, colMid};
        }
        // ye pehla wala, ab 2nd row in same col me jo element h kya woh hai target?
        if (matrix[rStart + 1][colMid] == target) {
            return new int[]{rStart + 1, colMid};
        }

        // ab woh 4 portions me binary search se target find karo

        // search in 1st half
        if (target <= matrix[rStart][colMid - 1]) {
            return binarySearch(matrix, target, rStart, 0, colMid - 1);
        }
        // search in 2nd half
        if (target >= matrix[rStart][colMid + 1] && target <= matrix[rStart][cols - 1]) {
            return binarySearch(matrix, target, rStart, colMid + 1, cols - 1);
        }
        // search in 3rd half
        if (target <= matrix[rStart+1][colMid - 1]) {
            return binarySearch(matrix, target, rStart+1, 0, colMid - 1);
        }
        // search in 4th half
       else {
            return binarySearch(matrix, target, rStart+1, colMid + 1, cols - 1);
        }
    }
}
