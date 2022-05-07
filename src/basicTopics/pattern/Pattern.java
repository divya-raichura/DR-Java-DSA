package lectures.pattern;

public class Pattern {
    public static void main(String[] args) {
        pattern(5);
    }


    // by my own, took 1 hr
    static void pattern(int n) {
        for (int row = 1; row <= 2 * n; row++) {
            int noOfcol = row <= n ? n - row + 1 : row - n;
            for (int col = 1; col <= noOfcol; col++) {
                System.out.print("* ");
            }
            int spaces = row <= n ? row * 2 - 2 : (4 * n) - (2 * row);
            for (int s = 1; s <= spaces; s++) {
                System.out.print("  ");
            }
            int rhsCol = row <= n ? row + n : (n * 2) - (row - n - 1);
            for (int colRhs = rhsCol; colRhs <= n * 2; colRhs++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

/*
int rhsCol = row + n;
            for (int colRhs = rhsCol; colRhs <= 10; colRhs++) {
                System.out.print("* ");
            }
 */
