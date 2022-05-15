package lectures.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Revision {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int[] arr = new int[5];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = in.nextInt();
//        }

        // first method to print
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }

        // second method to print
//        for (int j : arr) {
//            System.out.print(j + " ");
//        }

        // third way to print
//        System.out.println(Arrays.toString(arr));// 'arrays' class (isliye capital letter hai A) has a 'to string' method


                                        // 2D  ARRAYS

        int[][] arr = new int[3][3];

        for (int row = 0; row < arr.length; row++) {
            // now iterating over columns
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = in.nextInt(); // in first step arr[0][0], in second step arr[0][1], '0 row' ie 1st array and '1 col' ie 2nd element in that first array
            }
        }

        // 1st method of output

//        for (int row = 0; row < arr.length; row++) {
//            // now iterating over columns
//            for (int col = 0; col < arr[row].length; col++) {
//                System.out.print(arr[row][col] + " "); // this will print output in single row
//                // to print in matrix form u need to leave line everytime after a row
//            }
//            System.out.println(); // above for loop will print one array(first row)
//            // after coming out it will start with second arr(sec row) from new line due to this sout
//        }

        // 2nd method of output

//        for (int row = 0; row < arr.length; row++) {
//            System.out.println(Arrays.toString(arr[row]));// in first step arr[0] (0 is row)
            // so 0th row ie first array of 2D array will be printed and then similarly for 1st and 2nd row ie 2nd and third arr
//        }

        //3rd method of output
        for (int[] nums : arr) {
            System.out.println(Arrays.toString(nums));
        }





    }
}
