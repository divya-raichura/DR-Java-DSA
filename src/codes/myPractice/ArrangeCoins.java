package myPractice;
// 31 jan 2022

import java.math.BigInteger;
import java.util.ArrayList;

// https://leetcode.com/problems/arranging-coins/

public class ArrangeCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
    }


// my wrong ans, actually, the ans is write, but arr ka range infinity jara
    static int noOfRows(int n) {
        int[][] arr = new int[n][];
        int count = 0;
        int noOfR = 0;

        for (int row = 1; row < arr.length; row++) {
            for (int col = 1; col <= row; col++) {
                if (count < n) {
                    count++;
                } else {
                    return noOfR;
                }
            }
            noOfR++;
        }
        return -1;
    }


    // correct ans leetcode
    static int arrangeCoins(int n) {
        int res;
        for (res = 1; res <= n; res++) {
            n = n-res;
        }
        return res-1;
    }


//    static BigInteger main(int n) {
//        return getRows(BigInteger.valueOf(n));
//    }

//    static BigInteger getRows(BigInteger n) {
//        BigInteger N = new BigInteger(String.valueOf(n));
//        BigInteger inc = new BigInteger("1");
//        BigInteger limit = new BigInteger("1");
//        BigInteger count = new BigInteger("0");
//        while (true) {
//            if (limit.compareTo(N) < 0) {
//                N = N.subtract(limit);
//                limit = limit.add(inc);
//                count = count.add(inc);
//            } else {
//                break;
//            }
//        }
//        if (limit.compareTo(N) == 0) {
//            count = count.add(inc);
//        }
//        return count;
//    }


    static BigInteger arrangeCoins(BigInteger n) {
        BigInteger N = new BigInteger(String.valueOf(n));
        BigInteger inc = new BigInteger("1");
        BigInteger limit = new BigInteger("1");
        BigInteger count = new BigInteger("0");
        while (true) {
            if (limit.compareTo(N) < 0) {
                N = N.subtract(limit);
                limit = limit.add(inc);
                count = count.add(inc);
            } else {
                break;
            }
        }
        if (limit.compareTo(N) == 0) {
            count = count.add(inc);
        }
        return count;
    }










}
