package src.codes.recursion.rec_2_easy;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(0));
    }

    static int factorial(int n) {
        if (n <= 1) { // <= as if og n is 0 then 0! is also one hence this condition but if og input is anything else, it will obviously stop at 1!
            return 1;
        }

        return n * factorial(n - 1);
    }

}
