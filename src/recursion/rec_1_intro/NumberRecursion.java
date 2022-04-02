package src.codes.recursion.rec_1_intro;

public class NumberRecursion {
    public static void main(String[] args) {
        print(1);
    }

    static void print(int n) {
        // base condition
        if (n == 5) {
            System.out.println(5);
            return;
        }
        System.out.println(n);

        // this is called the tail recursion
        // this is the last function call
        print(n + 1);
    }
}
