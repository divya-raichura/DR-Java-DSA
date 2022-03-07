package src.codes.recursion.practice;

public class DigitSum {
    public static void main(String[] args) {
        System.out.println(sum(0));
    }

    static int sum(int n) {
        if (n <= 0) {
            return 0;
        }
        return sum(n / 10) + n % 10;
    }

}
