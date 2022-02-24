package src.codes.recursion.rec_2_easy;

public class One_to_N {
    public static void main(String[] args) {
        print(5);

    }

    // 1 2 3 4 5
    static void print(int n) {
        if (n == 0) {
            return;
        }
        print(n-1);
        System.out.println(n);
    }

}
