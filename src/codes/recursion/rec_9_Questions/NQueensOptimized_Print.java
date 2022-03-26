package src.codes.recursion.rec_9_Questions;

public class NQueensOptimized_Print {
    public static void main(String[] args) {
        queens(4);
    }

    static void queens(int n) {
        String[][] board = new String[n][n];
        int colSize = board[0].length;
        int[] leftRow = new int[colSize];
        int[] upperDiagonal = new int[2 * colSize - 1];
        int[] lowerDiagonal = new int[2 * colSize - 1];
        solve(colSize, 0, board, leftRow, upperDiagonal, lowerDiagonal);
    }

    static void solve(int colSize, int col, String[][] board, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal) {
        if (col == colSize) {
            print(colSize, board);
            System.out.println();
            return;
        }
        for (int row = 0; row < colSize; row++) {
            if (leftRow[row] == 0 && upperDiagonal[colSize - 1 + col - row] == 0 && lowerDiagonal[row + col] == 0) {
                board[row][col] = "Q";
                leftRow[row] = 1;
                upperDiagonal[colSize - 1 + col - row] = 1;
                lowerDiagonal[row + col] = 1;
                solve(colSize, col + 1, board, leftRow, upperDiagonal, lowerDiagonal);
                board[row][col] = null;
                leftRow[row] = 0;
                upperDiagonal[colSize - 1 + col - row] = 0;
                lowerDiagonal[row + col] = 0;
            }
        }
    }

    static void print(int colSize, String[][] board) {
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
