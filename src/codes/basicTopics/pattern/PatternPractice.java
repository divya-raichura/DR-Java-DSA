package lectures.pattern;


            // simple same syntax for all Q's
// kunal se bhi updated & better, just 1-2 steps inc kiye mene & tab jake ache se samja

/*

--> row loop start
--> formula relating col and that row
--> col loop start
--> print("whatever")
--> col loop end
--> new line for next row
--> row loop end

*/

public class PatternPractice {
    public static void main(String[] args) {
//        pattern1(5);
//        pattern2(5);
//        pattern3(5);
//        pattern4(5);
//        pattern5(5);
//        pattern28(5);
        pattern30(5);
    }

    static void pattern1(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        /*
         * * * * *
         * * * * *
         * * * * *
         * * * * *
         * * * * *
         */
    }

    static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        /*
         *
         * *
         * * *
         * * * *
         * * * * *
         */
    }

    static void pattern3(int n) {
        for (int row = 1; row <= n; row++) {
            int last = n - row + 1;
            for (int col = 1; col <= last; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        /*
         * * * * *
         * * * *
         * * *
         * *
         *
         */
    }

    static void pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        /*
        1
        1 2
        1 2 3
        1 2 3 4
        1 2 3 4 5
         */
    }

    // can't believe solved this on my own
    static void pattern5(int n) {
        for (int row = 1; row < n * 2; row++) { // last --> total cols in that row
            int last = row > n ? n * 2 - row : row; // eg- when row=2, is 2>5(n) ? --> no therefore, last == row (2)
            for (int col = 1; col <= last; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        /*
         *
         * *
         * * *
         * * * *
         * * * * *
         * * * *
         * * *
         * *
         *
         */
    }

    static void pattern28(int n) {
        for (int row = 1; row < n * 2; row++) { // last --> total cols in that row
            int last = row > n ? n * 2 - row : row; // eg- when row=2, is 2>5(n) ? --> no therefore, last == row (2)
            int noOfSpaces = n - last;
            for (int s = 0; s < noOfSpaces; s++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= last; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
/*

    *
   * *
  * * *
 * * * *
* * * * *
 * * * *
  * * *
   * *
    *

*/
    }

    static void pattern30(int n) {
        for (int row = 1; row <= n; row++) {
            int noOfSpaces = n - row;
            for (int s = 1; s <= noOfSpaces; s++) {
                System.out.print("  ");
            }
            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
/*
        1
      2 1 2
    3 2 1 2 3
  4 3 2 1 2 3 4
5 4 3 2 1 2 3 4 5

  */

    }

}
