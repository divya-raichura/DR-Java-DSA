package com.company.dp.lecs_tuf.T7_partition;

import java.util.List;

public class L53_Palindrome {
    public static void main(String[] args) {

    }

    static boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

//    public static int rec(String s) {
//
//    }
//
//    public static int rec(String s) {
//
//    }
}
