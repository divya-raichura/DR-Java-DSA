package src.codes.recursion.rec_9_Questions;

public class Sudoku {
    public static void main(String[] args) {
        char[][] arr = new char[3][3];


    }

    static void sudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }

    static boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

                if (board[i][j] == '.') {

                    for (char check = '1'; check <= '9'; check++) {

                        if (isValid(i, j, check, board)) {
                            board[i][j] = check;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }

                    }
                    return false;
                }

            }
        }
        return true;
    }

    static boolean isValid(int row, int col, char check, char[][] board) {

        for (int i = 0; i < 9; i++) {

            // we put && condition so that it doesn't check the box we are validating for
            // if we don't put &&, the element we are checking for is '.' and in this loop
            // when it will come to the element we are validating for, it will compare
            // element we are validating with itself and as '.' == '.' it will return false
            // which is wrong
            // So, we put && condition to skip the element we are validating for

            // to check every row element
            if (board[row][i] != '.' && board[row][i] == check) return false;

            // to check every col element
            if (board[i][col] != '.' && board[i][col] == check) return false;

            // to check every sub-matrix element
            if (board[(3 * (row / 3)) + (i / 3)][(3 * (col/3)) + (i % 3)] != '.' && board[(3 * (row / 3)) + (i / 3)][(3 * (col/3)) + (i % 3)] == check) return false;

        }
        return true;
    }
}
