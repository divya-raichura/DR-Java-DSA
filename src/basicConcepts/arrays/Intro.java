package lectures.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Intro {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//        arrays of primitives
//     int[] arr = new int[5];
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = in.nextInt();
//        }

        int[] arr = {2, 4, 7, 7, 8, 9, 13};
//      1st way of printing

        System.out.println(arr.length); // arr.length is 7
        // int i is '0' at starting and then it will go till arr.length-1 which means it will go till 6
        // "it will go till 6" is where I was making mistake, see its written
        // i < arr.length-1 which means that its not equal to 6 it will go till 'i' is less than 6 which is 5
        //hence when when arr.length-1 it prints only till 9 element
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }

        // for each loop , enhanced way- 2nd way

//        for (int nums : arr) {
//            System.out.print(nums + " ");
//        }

//        3rd way of printing

//        System.out.println(Arrays.toString(arr));


//        String example

//        String[] str = new String[4];
//
//        for (int i = 0; i < str.length; i++) {
//            str[i] = in.next();
//        }
//        System.out.println(Arrays.toString(str));


        // simple doubt ka try

//        int[] ints = {1, 2, 3, 4, 5};
//
//        System.out.println(Arrays.toString(ints));

    }
}
