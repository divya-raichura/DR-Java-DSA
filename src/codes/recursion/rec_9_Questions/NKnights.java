package src.codes.recursion.rec_9_Questions;

public class NKnights {
    public static void main(String[] args) {
        knights(4);
    }

    static void knights(int n) {
        String[][] board = new String[n][n];
        solve(0, 0, board, n);
    }

    static void solve(int row, int col, String[][] board, int noOfKnights) {
        if (noOfKnights == 0) {
            display(board);
            System.out.println();
            return;
        }
        if (row == board.length - 1 && col == board.length) {
            return;
        }
        if (col == board.length) {
            solve(row + 1, 0, board, noOfKnights);
            return;
        }
        if (isSafe(board, row, col)) {
            board[row][col] = "K";
            solve(row, col + 1, board, noOfKnights - 1);
            board[row][col] = null;
        }
        solve(row, col + 1, board, noOfKnights);
    }

    private static boolean isSafe(String[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1] != null) return false;
        }
        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2] != null) return false;
        }
        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1] != null) return false;
        }
        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2] != null) return false;
        }
        return true;
    }

    private static boolean isValid(String[][] board, int row, int col) {
        if (col >= 0 && col < board.length && row >= 0 && row < board.length) {
            return true;
        }
        return false;
    }


    static void display(String[][] board) {
        String[][] boardPrint = new String[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == null) {
                    boardPrint[row][col] = "X";
                    System.out.print(boardPrint[row][col] + " ");
                } else {
                    boardPrint[row][col] = board[row][col];
                    System.out.print(boardPrint[row][col] + " ");
                }
            }
            System.out.println();
        }
    }
}
