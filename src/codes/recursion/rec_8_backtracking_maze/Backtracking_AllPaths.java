package src.codes.recursion.rec_8_backtracking_maze;

public class Backtracking_AllPaths {
    public static void main(String[] args) {
        boolean[][] arr1 = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        boolean[][] arr2 = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        boolean[][] arr3 = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        allPath("", arr1, 0, 0);
//        System.out.println();
//        allPathExpi("", arr2, 0, 0);
//        System.out.println();
        // W R O N G
//        allPathExpi2("", arr3, 0, 0);
    }

    static void allPath(String p, boolean[][] arr, int row, int col) {
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            System.out.print(p + " ");
            return;
        }
        if (!arr[row][col]) {
            return;
        }
        arr[row][col] = false;
        if (row < arr.length - 1) {
            allPath(p + "D", arr, row + 1, col);
        }
        if (col < arr[0].length - 1) {
            allPath(p + "R", arr, row, col + 1);
        }
        if (row > 0) {
            allPath(p + "U", arr, row - 1, col);
        }
        if (col > 0) {
            allPath(p + "L", arr, row, col - 1);
        }
        arr[row][col] = true;
    }


    static void allPathExpi(String p, boolean[][] arr, int row, int col) {
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            System.out.print(p + " ");
            return;
        }
        if (!arr[row][col]) {
            return;
        }

        if (row < arr.length - 1) {
            arr[row][col] = false;
            allPathExpi(p + "D", arr, row + 1, col);
            arr[row][col] = true;
        }
        if (col < arr[0].length - 1) {
            arr[row][col] = false;
            allPathExpi(p + "R", arr, row, col + 1);
            arr[row][col] = true;
        }
        if (row > 0) {
            arr[row][col] = false;
            allPathExpi(p + "U", arr, row - 1, col);
            arr[row][col] = true;
        }
        if (col > 0) {
            arr[row][col] = false;
            allPathExpi(p + "L", arr, row, col - 1);
            arr[row][col] = true;
        }
    }



    //  W R O N G
    static void allPathExpi2(String p, boolean[][] arr, int row, int col) {
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            System.out.print(p + " ");
            return;
        }
        if (!arr[row][col]) {
            return;
        }
        arr[row][col] = false;

        if (row < arr.length - 1) {
//            arr[row][col] = false;
            allPathExpi2(p + "D", arr, row + 1, col);
            arr[row][col] = true;
        }
        if (col < arr[0].length - 1) {
//            arr[row][col] = false;
            allPathExpi2(p + "R", arr, row, col + 1);
            arr[row][col] = true;
        }
        if (row > 0) {
//            arr[row][col] = false;
            allPathExpi2(p + "U", arr, row - 1, col);
            arr[row][col] = true;
        }
        if (col > 0) {
//            arr[row][col] = false;
            allPathExpi2(p + "L", arr, row, col - 1);
            arr[row][col] = true;
        }
    }
}
