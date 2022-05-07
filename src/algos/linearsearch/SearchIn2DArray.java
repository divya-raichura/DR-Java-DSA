package lectures.linearsearch;

import java.util.Arrays;
import java.util.Scanner;

public class SearchIn2DArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] arr = {
                {23, 4, 1},
                {18, 12, 3, 9},
                {78, 99, 34, 56},
                {18, 12}
        };
//        int[][] arr = new int[][]{ // can do like this but not necessary
//                {23, 4, 1},
//                {18, 12, 3, 9},
//                {78, 99, 34, 56},
//                {18, 12}
//        };
        int target = in.nextInt();
        int[] ans = search(arr, target); // return will be in format {row,col}
        System.out.println(Arrays.toString(ans));
    }

    static int[] search(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    // can do like this
//                  /*1--*/ int[] jawab = {row, col};
//                    return jawab;
//                  /*2-*/ return new int[]{row, col}; // kk

                    // can do like this, niche jaisa hi, bas thoda farak and boom
//                    int[] jawab = new int[2]; // OR int[] jawab = {-1,-1};
//                    jawab[0] = row;
//                    jawab[1] = col;
//                    return jawab;

                    // can't do like this
//                    int[] jawab = new int[2];
//                    jawab = {row, col};
//                    return jawab;
                    // watch lec if not understood @42min

                }
            }
        }
        return new int[]{-1, -1};
    }


        // max function by simple usual method
    // max and min value
    // we will learn this "Integer.MAX_VALUE" later in detail
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);

//    static int max(int[][] arr) {
//        int max = arr[0][0];
//        for (int row = 0; row < arr.length; row++) {
//            for (int col = 0; col < arr[row].length; col++) {
//                if (arr[row][col] > max) {
//                    max = arr[row][col];
//                }
//            }
//        }
//        return max;
//    }

        // max function by kind of complex method

//    static int max(int[][] arr) {
//        int max = Integer.MIN_VALUE;
//        for (int row = 0; row < arr.length; row++) {
//            for (int col = 0; col < arr[row].length; col++) {
//                if (arr[row][col] > max) {
//                    max = arr[row][col];
//                }
//            }
//        }
//        return max;
//    }

        // same as above but converting into enhanced for loop

    static int max(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int[] rows : arr) { // woh bahar wale array ka har ek element array hai toh uske liye "int[]"
            for (int element : rows) { // woh andar wale jo arrays hai unke andar elements hai isliye "int" only
                if (element > max) {
                    max = element;
                }
            }
        }
        return max;
    }
}
