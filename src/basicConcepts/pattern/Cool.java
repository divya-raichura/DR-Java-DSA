package src.concepts.pattern;

public class Cool {
    public static void main(String[] args) {
//        pattern_yay();
//        dhoka();
        dhokaSimpleWay();
//        intezar();
    }

    static void intezar() {
        // same as dhoka simple way just change in formula
        int n = 4;
        for (int row = 1; row < 2  * n; row++) {
            int space = row <= n ? n - row : row - n;
            int col = row <=n ? row : 2 * n - row;
            for (int i = 1; i <= space; i++) {
                System.out.print("  ");
            }
            for (int i = col; i >= 1; i--) {
                System.out.print(i + " ");
            }
            for (int i = 2; i <= col; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static void dhokaSimpleWay() {
        int n = 5;
        for (int row = 1; row <= n; row++) {
            int spaces = n - row;
            int cols = row;
            for (int i = 1; i <= spaces; i++) {
                System.out.print("  ");
            }
            for (int i = cols; i >= 1; i--) {
                System.out.print(i + " ");
            }
            for (int i = 2; i <= cols; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static void dhoka() {
        int n = 5;
        for (int row = 1; row <= n; row++) {
            int spaces = n - row;
            int cols = 2 * row - 1;
            for (int i = 1; i <= spaces; i++) {
                System.out.print("   ");
            }
            for (int i = 1; i <= cols; i++) {
                if (row - i + 1 > 0) {
                    System.out.print(row - i + 1 + " ");
                } else {
                    System.out.print(i - row + 1 + " ");
                }
            }
            System.out.println();
        }
    }

    static void pattern_yay() {
        int n = 5;
        for (int row = 1; row < 2 * n; row++) {
            int stars = row <= n ? row : 2 * n - row; // total no of cols
            int spaces = row <= n ? n - row : row - n;
            // or simply, spaces = n - stars
            for (int i = 1; i <= spaces; i++) {
                System.out.print(" ");// by changing no of spaces
//                pattern hi change hojata hai
            }
            for (int i = 1; i <= stars; i++) {
                System.out.print("* ");  // by changing no of spaces
//                pattern hi change hojata hai
            }
            System.out.println();
        }
    }

    static void pattern() {
        int n = 4;
        for (int row = 0; row < n; row++) {
            int col = n - row;
            for (int i = 0; i < col; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern2() {
        int n = 5;
        for (int row = 0; row < 2 * n; row++) {
            int noOfCol = row < n ? row : 2 * n - row;
            for (int j = 0; j < noOfCol; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

/*
 int n = 5;
        for (int row = 1; row <= n; row++) {
            int space = n - row;
            int nos = n - space;
            for (int j = 1; j <= space; j++) {
                System.out.print("  ");
            }
            for (int j = row; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
 */