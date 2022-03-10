package src.codes.myPractice.prac1;

import java.util.Arrays;
import java.util.Scanner;

public class Determinant {
    static final int N = 3;

    // Function to get cofactor of mat[p][q] in temp[][].
    // n is current dimension of mat[][]
    static void getCofactor(int[][] mat, int[][] temp, int p, int q, int n) {
        int i = 0, j = 0;
        // Looping for each element of the matrix
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
 // Copying into temporary matrix only those element which are not in given row and column
                if (row != p && col != q) {
                    temp[i][j++] = mat[row][col];
                    // Row is filled, so increase row index and reset col index
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    /* Recursive function for finding determinant
    of matrix. n is current dimension of mat[][]. */
    static int determinantOfMatrix(int[][] mat, int n) {
        int D = 0; // Initialize result
        // Base case : if matrix contains single element
        if (n == 1) {
            return mat[0][0];
        }
        // To store cofactors
        int[][] temp = new int[N][N];

        // To store sign multiplier
        int sign = 1;

        // Iterate for each element of first row
        for (int f = 0; f < n; f++) {
            // Getting Cofactor of mat[0][f]
            getCofactor(mat, temp, 0, f, n);

            D += sign * mat[0][f] * determinantOfMatrix(temp, n - 1);

            // terms are to be added with alternate sign
            sign = -sign;
        }

        return D;
    }

    /* function for displaying the matrix */
    static void display(int mat[][], int row, int col)
    {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.print(mat[i][j]);

            System.out.print("\n");
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[][] mat = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };
        System.out.print("Determinant of the matrix is : " + determinantOfMatrix(mat, N));
//        Scanner in = new Scanner(System.in);
//        System.out.print("dimension : ");
//        int n = in.nextInt();
//        int[][] arr = new int[n][n];
//        System.out.println("fill elements");
//        for (int row = 0; row < arr.length; row++) {
//            for (int col = 0; col < arr[row].length; col++) {
//                arr[row][col] = in.nextInt();
//            }
//        }
//        System.out.println(det(arr));
    }


//    static int det(int[][] mat) {
//        if (mat.length == 1)
//            return mat[0][0];
//        if (mat.length == 2)
//            return mat[0][0] * mat[1][1] - mat[1][0] * mat[0][1];
//        int sum = 0, sign = 1;
//        int newN = mat.length - 1;
//        int[][] temp = new int[newN][newN];
//        for (int t = 0; t < newN; t++) {
//            int q = 0;
//            for (int i = 0; i < newN; i++) {
//                for (int j = 0; j < newN; j++) {
//                    temp[i][j] = mat[1 + i][q + j];
//                }
//                // ye 'j' for loop ki jagah
////                System.arraycopy(mat[1 + i], q + 0, temp[i], 0, newN);
//                if (q == i)
//                    q = 1;
//            }
//            sum += sign * mat[0][t] * det(temp);
//            sign *= -1;
//        }
//        return sum;
//    }

}
