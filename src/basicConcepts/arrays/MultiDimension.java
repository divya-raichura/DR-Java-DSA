package src.codes.basicTopics.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MultiDimension {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /*
                1 2 3
                4 5 6
                7 8 9
         */

//        int[][] arr = new int[3][3];

//        int[][] arr = {
//                {1, 2, 3}, // 0th index
//                {4, 5}, // 1st index
//                {6, 7, 8, 9}, // 2nd index -> arr[2] = {6, 7, 8, 9}
//        };

        // input

//        int[][] arr = new int[3][2]; // this will take only 6 elements from 1 to 6
//        System.out.println(arr.length); // arr.length will give the no of rows not columns
//        (here its 3)

//        int[][] arr = new int[3][3]; // this will take 9 input elements

                // input

//        for (int row = 0; row < arr.length; row++) {
            // for each column in every row, another for loop

            /*
                 size of column is varying for every particular
                 index of the array, example array
                  at first index has a size of 2 but in
                  this ex that we are taking size of all
                  columns is same
             */

//            for (int col = 0; col < arr[row].length ; col++) {
                // arr[row].length means every array at that row the length of that array
//                arr[row][col] = in.nextInt();
//            }
//        }

                // output

//        for (int row = 0; row < arr.length; row++) {

//            for (int col = 0; col < arr[row].length; col++) {
//                System.out.print( arr[row][col] + " ");
//            }

//            System.out.println(); // to print every row on next line
//        }

        // using another method

//        int[][] arr = new int[3][3];
//
//        for (int row = 0; row < arr.length; row++) {
//            for (int col = 0; col < arr[row].length; col++) {
//                arr[row][col] = in.nextInt();
//            }
//        }
//        for (int row = 0; row < arr.length; row++) {
//            System.out.println(Arrays.toString(arr[row]));
//        }


        // using enhanced for loop

        int[][] arr = new int[3][3];

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = in.nextInt();
            }
        }
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }








    }
}


