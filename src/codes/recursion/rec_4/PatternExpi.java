package src.codes.recursion.rec_4;

// just experimenting

public class PatternExpi {
    public static void main(String[] args) {
//        pattern(4, 1);
        pattern2(1, 1, 3);
    }

// trying new method to print triangle(patter) with base(max stars at bottom)
    static void pattern2(int row, int col, int n) { // n is the counter, that how many rows of pattern we need
        if (n == 0) {
            return;
        }

        if (row >= col) {
            System.out.print("* ");
            pattern2(row, col + 1, n);
            System.out.print("* ");
        } else {
            System.out.println();
            pattern2(row + 1, col = 1, n - 1);
            System.out.println();
        }
    }


    static void pattern(int r, int c) {

        if (r == 0) {
            return;
        }

        if (c <= r) {
            System.out.print("* ");
            pattern(r, c + 1);
        } else {
            System.out.println();
            pattern(r - 1, c = 1);
        }
    }

}
