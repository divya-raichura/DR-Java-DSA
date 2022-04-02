package src.codes.recursion.rec_2_easy;

public class Sum_till_N {
    public static void main(String[] args) {
        System.out.println(sum(0));
    }

    static int sum(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sum(n - 1);
    }
}
