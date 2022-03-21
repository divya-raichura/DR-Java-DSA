package src.codes.recursion.rec_8_backtracking_maze;

public class AllPaths {
    public static void main(String[] args) {
        boolean[][] obs = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        allPaths("", obs, 0, 0);
    }


    // gives stackoverflow error as same block gets called again when the
    // function is returning
    // so to avoid this we mark the block which is visited as false
    // but again, as the og arr gets modified, false block remains as false
    // so in next path also it remains false and the function doesn't go to
    // that block result of which, that path which was valid is also not counted

    // hence to solve this we use backtracking
    // in this, we revert the changes made in a function call when it is
    // returning
    static void allPaths(String p, boolean[][] obs, int row, int col) {
        if (row == obs.length - 1 && col == obs[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!obs[row][col]) {
            return;
        }
        if (row < obs.length - 1) {
            allPaths(p + "D", obs, row + 1, col);
        }
        if (col < obs[0].length - 1) {
            allPaths(p + "R", obs, row, col + 1  );
        }
        if (col > 0) {
            allPaths(p + "L", obs, row, col - 1);
        }
        if (row > 0) {
            allPaths(p + "U", obs, row - 1, col);
        }
    }
}
