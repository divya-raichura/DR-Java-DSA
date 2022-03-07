package src.codes.recursion.practice;

public class CountSteps {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(cs(n, 0));

    }

    static int cs(int n, int count) {

        if (n == 0) {
            return count;
        }

        if (n % 2 == 0) {
            return cs(n / 2, count + 1);
        }
        return cs(n - 1, count + 1);

    }

}
