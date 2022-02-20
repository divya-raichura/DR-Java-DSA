package lectures.linearsearch;

import java.util.Scanner;

public class Syntax {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        int[] arr = {2, 1, 44, 52, 22, 54, 78, 14};
        int ans = linearsearch(arr, target);
        boolean ans2 = linearsearch3(arr, target);
        System.out.println(ans);
        System.out.println(ans2);
    }

    static boolean linearsearch3(int[] arr, int target) {
        if (arr.length == 0) {
            return false;
        }

        for (int index = 0; index < arr.length; index++) {
            int element = arr[index];
            if (target == element) {
                return true;
            }
        }
        return false;
    }

    // return the target element
    static int linearsearch2(int[] arr, int target) {

        if (arr.length == 0) {
            return -1;
        }

        for (int index = 0; index < arr.length; index++) {
            int element = arr[index];
            if (target == element) {
                return element;
            }
        }
        return Integer.MIN_VALUE;
//        return -1; // in this case, target element in array might be -1
        // so how do we know whether -1 means target not found or it is the target found in array
    }


    // return the index of target element
    static int linearsearch(int[] arr, int target) {

        if (arr.length == 0) {
            return -1;
        }

        for (int index = 0; index < arr.length; index++) {
            // int element = arr[index];
            if (target == arr[index]) { // if(element == target) // kunal did this way
                return index;
            }
        }
        return -1; // here we can return -1 if we don't find the index of target
        // as index of target can never be -1; so if sout is -1 it means
        // target element is not in array
    }
}
