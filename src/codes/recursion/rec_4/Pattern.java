package src.codes.recursion.rec_4;

public class Pattern {
    public static void main(String[] args) {
//        pattern(4);
        patternRec(4,0);

    }


    static void patternRec2(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col <= row) {
            patternRec2(row, ++col);
            System.out.print("* ");
        } else {
            patternRec2(row - 1, 1);
            System.out.println();
//            row -= 1;
//            col = 0;
        }
    }

    static void patternRec(int row, int col) {

        if (row == 0) {
            return;
        }

        if (col < row) {
            System.out.print("* ");
            patternRec(row, ++col);
        } else {
            System.out.println();
            patternRec(row - 1, 0);
//            row -= 1;
//            col = 0;
        }
//        patternRec(row, ++col);
    }

    static void pattern(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}
