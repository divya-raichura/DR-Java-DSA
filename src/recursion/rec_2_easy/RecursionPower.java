package src.codes.recursion.rec_2_easy;

// https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-1/tutorial/

public class RecursionPower {
    public static void main(String[] args) {
        System.out.println(recursivePower(5, 3));
    }

    static int recursivePower(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * recursivePower(x, n - 1);
    }
}
