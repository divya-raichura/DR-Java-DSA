package com.company.dp.lecs_tuf.oneD_arr_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NavigableMap;

public class _11_Triangle {
//    https://leetcode.com/problems/triangle/
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new ArrayList<>());
        }
        list.get(0).add(2);
        list.get(1).add(3);
        list.get(1).add(4);
        list.get(2).add(6);
        list.get(2).add(5);
        list.get(2).add(7);
        list.get(3).add(4);
        list.get(3).add(1);
        list.get(3).add(8);
        list.get(3).add(3);

        System.out.println(rec(list));
        System.out.println(memo(list));
        System.out.println(tabulation(list));
    }

    // recursion
    // tc : exponential
    // sc : size of outer list
    static int rec(List<List<Integer>> triangle) {
        return rec(triangle, 0, 0);
    }

    static int rec(List<List<Integer>> outer, int row, int index) {
        if (row == outer.size() - 1) {
            return outer.get(row).get(index);
        }

        int l = outer.get(row).get(index) + rec(outer, row + 1, index);
        int r = outer.get(row).get(index) + rec(outer, row + 1, index + 1);

        return Math.min(l, r);
    }

    // memo
    // tc : n * n
    // sc : n + n*n {for dp}
    static int memo(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return memo(triangle, 0, 0, dp);
    }

    static int memo(List<List<Integer>> outer, int row, int index, int[][] dp) {
        if (row == outer.size() - 1) {
            return outer.get(row).get(index);
        }

        if (dp[row][index] != -1) return dp[row][index];

        int l = outer.get(row).get(index) + memo(outer, row + 1, index, dp);
        int r = outer.get(row).get(index) + memo(outer, row + 1, index + 1, dp);

        return dp[row][index] = Math.min(l, r);
    }

    // tabulation
    // tc : n*n
    // sc : n*n for dp table
    static int tabulation(List<List<Integer>> outer) {
        int[][] dp = new int[outer.size()][outer.size()];

        for (int oList = outer.size() - 1; oList >= 0; oList--) {
            for (int element = 0; element < outer.get(oList).size(); element++) {
                if (oList == outer.size() - 1) {
                    dp[oList][element] = outer.get(oList).get(element);
                } else {
                    int l = outer.get(oList).get(element) + dp[oList + 1][element];
                    int r = outer.get(oList).get(element) + dp[oList + 1][element + 1];
                    dp[oList][element] = Math.min(l, r);
                }
            }
        }
        return dp[0][0];
    }

    // space optimisation
    // tc : n*n
    // sc : n for dp table
    static int spaceOpt(List<List<Integer>> outer) {
        int[] dp = new int[outer.size()];

        for (int oList = outer.size() - 1; oList >= 0; oList--) {
            for (int element = 0; element < outer.get(oList).size(); element++) {
                if (oList == outer.size() - 1) {
                    dp[element] = outer.get(oList).get(element);
                } else {
                    int l = outer.get(oList).get(element) + dp[element];
                    int r = outer.get(oList).get(element) + dp[element + 1];
                    dp[element] = Math.min(l, r);
                }
            }
        }
        return dp[0];
    }
}
