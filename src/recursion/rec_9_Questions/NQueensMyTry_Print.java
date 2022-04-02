package src.codes.recursion.rec_9_Questions;

public class NQueensMyTry_Print {
    public static void main(String[] args) {
        // only to understand and try what a code does :-
        /*
        String[][] arr = new String[4][4];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {

                if (row == col) {
                    arr[row][col] = "Q";
                }
            }
        }
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {

                if (arr[row][col] == null) {
                    arr[row][col] = "KK";
                    break;
                }
            }
        }
        for (String[] num : arr) {
            System.out.println(Arrays.toString(num));
        }

         */

        queens(4);

    }


    // correct ans but very bad complexity, very inefficient
    static void queens(int n) {
        String[][] board = new String[n][n];
        int colSize = board[0].length;
        solve(colSize, 0, board);
    }

    static void solve(int colSize, int col, String[][] board) {
        if (col == colSize) {
            display(colSize, board);
            System.out.println();
            return;
        }
        for (int row = 0; row < colSize; row++) {
//            board[row][col] = null;
            if (isSafe(row, col, board, colSize)) {
                board[row][col] = "Q";
                solve(colSize, col + 1, board);
                board[row][col] = null;
            }
        }
    }

    static boolean isSafe(int row, int col, String[][] board, int n) {
        int ogRow = row;
        int ogCol = col;


        // upper diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] != null) return false;
            row--;
            col--;
        }

        row = ogRow;
        col = ogCol;

        // blocks in left
        while (col >= 0) {
            if (board[row][col] != null) return false;
            col--;
        }
        col = ogCol;

        // lower diagonal
        while (row < n && col >= 0) {
            if (board[row][col] != null) return false;
            row++;
            col--;
        }
        return true;
    }


    static void display(int colSize, String[][] board) {
        String[][] boardPrint = new String[board.length][board[0].length];
        for (int row = 0; row < colSize; row++) {
            for (int colP = 0; colP < colSize; colP++) {
                if (board[row][colP] == null) {
                    boardPrint[row][colP] = "X";
                    System.out.print(boardPrint[row][colP] + " ");
                } else {
                    boardPrint[row][colP] = board[row][colP];
                    System.out.print(boardPrint[row][colP] + " ");
                }
            }
            System.out.println();
        }
        // or remove sout from above loops and print arr using below loop
//            for (String[] num : boardPrint) {
//                System.out.println(Arrays.toString(num));
//            }
    }
}
