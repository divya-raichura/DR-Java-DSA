package src.codes.recursion.rec_2_easy;

public class DigitSum {
    public static void main(String[] args) {
        System.out.println(sum(1342));
    }

    static int sum(int n) {
        if (n <= 0) {
            return 0;
        }
//        int last = n % 10;
        return sum(n / 10) + n % 10; // sum(n / 10) + last;
    }

}
