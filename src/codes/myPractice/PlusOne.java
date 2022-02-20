package myPractice;
import java.util.Arrays;


        // 13 feb 2022 : 9 pm

// https://leetcode.com/problems/plus-one/

public class PlusOne {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
//        System.out.println(Arrays.toString(plusOne1(arr)));
//        System.out.println(Arrays.toString(plusOne2(arr)));
//        System.out.println(plusOneMyTry(arr));
        // my try is String type, so it doesn't update the arr
        // if we run multiple times as we know that strings are immutable
        // but if we run above two solutions(methods) arr updates with every run
    }



    static int[] plusOne1(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < 9) {
                arr[i]++;
            } else {
                arr[i] = 0;
            }
        }

        if (arr[0] == 0) {
            int[] digits = new int[arr.length + 1];
            arr[0] = 1;
            return digits;
        }
        return arr;
    }

    // leetcode solution 2
    static int[] plusOne2(int[] digits) {

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    static String plusOneMyTry(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = num * 10 + arr[i];
        }
        num = num + 1;
        String n = Integer.toString(num);
        char[] num2 = n.toCharArray();
        return Arrays.toString(num2);
    }


}
