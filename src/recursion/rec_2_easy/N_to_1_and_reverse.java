package src.codes.recursion.rec_2_easy;

public class N_to_1_and_reverse {
    public static void main(String[] args) {
        print(5);
    }


    // 5 4 3 2 1 1 2 3 4 5
    static void print(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        print(n-1);
        System.out.print(n + " ");
    }

}
