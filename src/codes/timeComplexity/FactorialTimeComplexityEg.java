package src.codes.basicTopics.timeComplexity;

public class FactorialTimeComplexityEg {
    public static void main(String[] args) {
        factorial(3);
    }

    static void factorial(int n) {
        if (n == 0) {
            System.out.println(n);
            return;
        }
        for (int i = 0; i < n; i++) {
            factorial(n-1);
        }
    }

}
