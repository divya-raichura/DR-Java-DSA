package src.codes.basicTopics.pattern;

// step 1: find the no of rows
// step 2: find the relation between row and col in each col
// step 3: print that many amount of time and print what u want to print

// relation(formula) between row, col and n is the main thing where we need to put brain, rest is all same

public class PatternQ {
    public static void main(String[] args) {
//        pattern2(4);
//        pattern1(5);
//        pattern3(5);
//        pattern4(5);
//        pattern5(9);
//        pattern5BetterApproach(5);
//        pattern28(5);
//        pattern30(5);
//        pattern30kk(5);
//        pattern17(5);
        pattern31(4);
    }



    static void pattern1(int n) {
        for (int row = 1; row <= n; row++) {
            // for every row, run the col
            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            // when one row is printed, we need to add a new line
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            // for every row, run the col
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            // when one row is printed, we need to add a new line
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 0; col <= n-row; col++) { // int col = 1; col <= n-row+1; col++
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row ; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void pattern5(int n) {
        for (int row = 1; row <= 5; row++) {
            // for every row, run the col
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            // when one row is printed, we need to add a new line
            System.out.println();
        }
        for (int row = 5; row <= n; row++) {
            for (int col = 1; col <= n-row; col++) { // int col = 1; col <= n-row+1; col++
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern5BetterApproach(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalColsInRow = row > n ? 2 * n - row : row;
            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern28(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalColsInRow = row > n ? 2 * n - row : row;
            int noOfSpaces = n - totalColsInRow;
            for (int s = 0; s < noOfSpaces; s++) {
                System.out.print(" ");
            }
            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    // ye wala mene khud se solve kiya, ss dek
    // jab me hard approach se karta hu tab kk easy approach leta hai
    // jab me easy karta hu tab woh hard approach leta hai
    static void pattern30(int n) {
        for (int row = 1; row <= n; row++) {
            int space = n - row;
            // space
            for (int s = 1; s <= space; s++) {
                System.out.print("  ");
            }
            // cols
            int noOfCols = row * 2 - 1;
            for (int col = 1; col <= noOfCols; col++) {
                if (col == row) {
                    System.out.print(1 + " ");
                }
                if (row > col) {
                    System.out.print(row - col + 1 + " ");
                }
                if (col > row) {
                    System.out.print(col - row + 1 + " ");
                }
            }
            System.out.println();
        }
    }

    // kk method, watch lec to understand // op insaan bhai
    // in number related pattern q, directly use col/row to print it
    static void pattern30kk(int n) {
        for (int row = 1; row <= n; row++) {
            int space = n - row;
            for (int s = 1; s <= space; s++) {
                System.out.print("  ");
            }
            for (int col = row; col >=1 ; col--) { // ye approach bhi aya tha ki
                // row is starting from row no -> dec to 1 -> again increasing to row number
                System.out.print(col + " ");
            }
            for (int col = 2; col <= row ; col++) {
                System.out.print(col + " ");
            }

            System.out.println();

        }
    }


    static void pattern17(int n) {
        for (int row = 1; row < 2 * n; row++) {
            int noOfCols = row > n ? 2 * n - row : row;
            int space = n - noOfCols;
            for (int s = 1; s <= space; s++) {
                System.out.print("  ");
            }
            for (int col = noOfCols; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= noOfCols; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }


    static void pattern31(int n) {
        for (int row = 1; row <= 2*n-1 ; row++) {
            for (int col = 1; col <= 2*n-1; col++) {
                // only thing we need to put brain is relation between row, col and n
                int atEveryIndex = Math.min(Math.min(row, col), Math.min(2 * n - row, 2 * n - col));
                System.out.print(5 - atEveryIndex + " ");
            }
            System.out.println();
        }
    }

}
