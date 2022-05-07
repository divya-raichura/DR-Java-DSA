package src.recursion.rec_9_backtrackingQuestions;

import java.util.Arrays;

public class Revise {
    public static void main(String[] args) {
        /*
        // to check what is the value when the elements inside array are not initialized
        char[][] arr = new char[4][4];
        for (char[] chars : arr) {
            System.out.println(Arrays.toString(chars));
        }
        */
        queens(new char[4][4], 0);
    }

    static void queens(char[][] arr, int col) {
        if (col == arr.length) {
            for (char[] ans : arr) {
                for (char ch : ans) {
                    if (ch == 0 || ch == ' ') { // because, char is primitive so initially when it is
                        // not given a value 'in an array', it is by default zero
                        ch = 'X';
                    }
                    System.out.print(ch + " ");
                }
                System.out.println();

            }
            System.out.println();
            return;
        }

        for (int row = 0; row < arr.length; row++) {
            if (safe(row, col, arr)) {
                arr[row][col] = 'Q';
                queens(arr, col + 1);
                arr[row][col] = ' ';
            }
        }
    }

    static boolean safe(int r, int c, char[][] arr) {
        int ogR = r;
        int ogC = c;

        while (c >= 0) {
            if (arr[r][c] == 'Q') {
                return false;
            }
            c--;
        }
        c = ogC;
        while (r >= 0 && c >= 0) {
            if (arr[r][c] == 'Q') {
                return false;
            }
            r--;
            c--;
        }
        r = ogR;
        c = ogC;
        while (r < arr.length && c >= 0) {
            if (arr[r][c] == 'Q') {
                return false;
            }
            r++;
            c--;
        }
        return true;
    }
}
