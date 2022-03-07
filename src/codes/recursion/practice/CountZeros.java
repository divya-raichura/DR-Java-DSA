package src.codes.recursion.practice;

public class CountZeros {
    public static void main(String[] args) {
        int n = 2022;
        System.out.println(cz(n, 0));
    }

    static int cz(int n, int count) {

        if (n % 10 == n) {
            return count;
        }

        if (n % 10 == 0) {
            return cz(n / 10, count + 1);
        }
        return cz(n / 10, count);
    }

}
