package myPractice;

// I did Yay
// 31 jan 2022

// https://leetcode.com/problems/matrix-diagonal-sum/

public class SumOfDiagonal2dArr {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(lToR(arr));
    }




    // my solution that was very slow
    static int diaSum(int[][] arr) {
        int r = 0;
        int c = 0;
        int sum = 0;
        while (r < arr.length && c < arr[0].length) {
            sum = sum + arr[r][c];
            r++;
            c++;
        }

        int r2 = 0;
        int c2 = arr[0].length - 1;
        int sum2 = 0;
        int temp = r2;
        int temp2 = c2;

        while (r2 <= temp2 && c2 >= temp) {
            if (r2 != c2) {
                sum2 = sum2 + arr[r2][c2];
            }
            r2++;
            c2--;
        }

        return sum + sum2;
    }


    // after making some changes, my soln also gave 100% yay
    static int lToR(int[][] arr) {
        int r = 0;
        int c = 0;
        int sum = 0;
        while (r < arr.length && c < arr[0].length) {
            sum = sum + arr[r][c];
            r++;
            c++;
        }

        r = 0;
        c = arr[0].length - 1;
        int temp = c;
        int temp2 = r;

        while (r <= temp && c >= temp2) {
            if (r != c) {
                sum = sum + arr[r][c];
            }
            r++;
            c--;
        }

        return sum;
//        return sum2;
    }


     // leetcode 100% fast solution
    static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        //Summing up diagonal 1
        for(int i=0;i<n;i++){
            sum += mat[i][i];
        }

        //Summing up diagonal 2
        for(int i=0;i<n;i++){
            sum += mat[i][n-i-1];
        }

        //If element repeating (in case n odd) subtracting that
        if(n%2==1){
            sum -= mat[n/2][n/2];
        }
        return sum;
    }

}
