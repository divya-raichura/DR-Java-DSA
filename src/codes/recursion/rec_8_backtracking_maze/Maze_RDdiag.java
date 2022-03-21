package src.codes.recursion.rec_8_backtracking_maze;

import java.util.ArrayList;
import java.util.List;

public class Maze_RDdiag {
    public static void main(String[] args) {
        System.out.println(mazeRetPathDiag("", 3, 3));
    }
    static int mazeCountWays(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }
        int count;
        int down = mazeCountWays(row - 1, col);
        int right = mazeCountWays(row, col - 1);
        count = down + right;
        return count;
        /*
                OR

        if (row == 1 || col == 1) {
          return 1;
        }
        int down = mazeCountWays(row - 1, col);
        int right = mazeCountWays(row, col - 1);
        return down + right;

         */

        /*
                OR

        if (row == 1 || col == 1) {
            return 1;
        }
        return mazeCountWays(row - 1, col) + mazeCountWays(row, col - 1);

         */
    }

    static void mazePrintPath(String p, int row, int col) {
        if (row == 1 || col == 1) {
            if (row == 1) {
                System.out.println(p + "RR");
            }
            if (col == 1) {
                System.out.println(p + "DD");
            }
            return;
        }
        mazePrintPath(p + "D", row - 1, col);
        mazePrintPath(p + "R", row, col - 1);
    }

    static void mazePrintPath2(String p, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.println(p);
            return;
        }
        if (row > 1) {
            mazePrintPath2(p + "D", row - 1, col);
        }
        if (col > 1) {
            mazePrintPath2(p + "R", row, col - 1);
        }
    }

    static List<String> mazeRetPath(String p, int row, int col) {
        if (row == 1 && col == 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();
        if (row > 1) {
//            List<String> ans = (mazeRetPath(p + "D", row - 1, col));
//            list.addAll(ans);
            list.addAll(mazeRetPath(p + "D", row - 1, col));
        }
        if (col > 1) {
//            List<String> ans = (mazeRetPath(p + "R", row, col - 1));
//            list.addAll(ans);
            list.addAll(mazeRetPath(p + "R", row, col - 1));
        }
        return list;
    }


    // row ==> D/V, col ==> R/H and diagonal(d) as well
    // ie -> if row > 1 go down or vertical
    // if col > 1 you can go right or horizontal

    static List<String> mazeRetPathDiag(String p, int row, int col) {
        if (row == 1 && col == 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();
        if (row > 1) {
//            List<String> ans = (mazeRetPathDiag(p + "V", row - 1, col));
//            list.addAll(ans);
            list.addAll(mazeRetPathDiag(p + "V", row - 1, col));
        }
        if (col > 1) {
//            List<String> ans = (mazeRetPathDiag(p + "H", row, col - 1));
//            list.addAll(ans);
            list.addAll(mazeRetPathDiag(p + "H", row, col - 1));
        }

        if (row > 1 && col > 1) {
            list.addAll(mazeRetPathDiag(p + "D", row - 1, col - 1));
        }
        return list;
    }
}
