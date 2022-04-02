package src.codes.recursion.rec_8_backtracking_maze;

import java.util.Arrays;

public class PrintPath_Backtracking {
    public static void main(String[] args) {
        boolean[][] arr = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] print = new int[arr.length][arr[0].length];
        allPath("", arr, 0, 0, print, 1);
    }

    // we need to backtrack the print array cause array is an object so
    // all arrays in function calls have same ref variable and point to
    // og array so the og array is modified, so to print different paths
    // we need to backtrack, ie, delete previous path similar to the
    // boolean array we did in all paths class

    // but to print the path, we need to keep record of step/count number
    // now this step will be int, and wkt when primitives are passed in
    // function calls, in every func call it is a new object so,
    // count of previous call is not modified like in arrays it is modified
    // hence we don't need backtracking for this(primitives)

    static void allPath(String p, boolean[][] arr, int row, int col, int[][] print, int count) {
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            print[row][col] = count;
            for (int[] nums : print) {
                System.out.println(Arrays.toString(nums));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if (!arr[row][col]) {
            return;
        }
        arr[row][col] = false;
        print[row][col] = count;
        if (row < arr.length - 1) {
            allPath(p + "D", arr, row + 1, col, print, count + 1);
        }
        if (col < arr[0].length - 1) {
            allPath(p + "R", arr, row, col + 1, print, count + 1);
        }
        if (row > 0) {
            allPath(p + "U", arr, row - 1, col, print, count + 1);
        }
        if (col > 0) {
            allPath(p + "L", arr, row, col - 1, print, count + 1);
        }
        arr[row][col] = true;
        print[row][col] = 0;
    }
}
