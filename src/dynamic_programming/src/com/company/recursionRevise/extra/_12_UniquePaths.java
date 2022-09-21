package com.company.recursionRevise.extra;

public class _12_UniquePaths {
    // https://leetcode.com/problems/unique-paths-iii/
    public static void main(String[] args) {

    }

    public int uniquePathsIII(int[][] grid) {
        return rec(grid);
    }


    public int rec(int[][] arr) {
        int emp = 1;
        int r = 0, c = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    r = i;
                    c = j;
                } else if (arr[i][j] == 0) {
                    emp++;
                }
            }
        }
        return rec(arr, r, c, emp);
    }

    public int rec(int[][] arr, int r, int c, int emp) {
        if (r < 0 || c < 0 || r == arr.length || c == arr[0].length || arr[r][c] < 0) return 0;

        if (arr[r][c] == 2) {
            if (emp == 0) return 1;
            return 0;
        }

        arr[r][c] = -2;
        emp--;

        int left = rec(arr, r, c - 1, emp);
        int right = rec(arr, r, c + 1, emp);
        int up = rec(arr, r - 1, c, emp);
        int down = rec(arr, r + 1, c, emp);

        arr[r][c] = 0;
        emp++;

        return left + right + up + down;
    }
}
