package recursion.rec_1_easy;
// 15th feb
public class N_to_1 {
    public static void main(String[] args) {
        nos(5);
    }

    // 5 4 3 2 1
    static void nos(int n) {
        if (n == 0) {
            return;
        }

        // or, do :-
//        if (n == 1) {
//            System.out.print(n + " ");
//            return;
//        }

        System.out.print(n + " ");
        nos(n-1);
    }

}
