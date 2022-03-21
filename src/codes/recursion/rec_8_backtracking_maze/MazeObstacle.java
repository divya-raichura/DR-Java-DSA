package src.codes.recursion.rec_8_backtracking_maze;

public class MazeObstacle {
    public static void main(String[] args) {
        boolean[][] obs = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        mazeObsPath("", obs, 0, 0);
    }

    static void mazeObsPath(String p, boolean[][] obs, int row, int col) {
        if (row == obs.length - 1 && col == obs[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!obs[row][col]) {
            return;
        }
        if (row < obs.length - 1) {
            mazeObsPath(p + "D", obs, row + 1, col);
        }
        if (col < obs[0].length - 1) {
            mazeObsPath(p + "R", obs, row, col + 1  );
        }
    }
}
