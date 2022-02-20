package bitwiseOperators.lec_1;


public class MagicNos {
    public static void main(String[] args) {
        int n = 6;
//        myTryMagicNos(n);
//        kkStyle(n);
    }


    static void kkStyle(int n) { // complexity is log(n) // see lec to know 1.35hr
        // or kk style :-
        int ans = 0;
        int base = 5;
        while (n > 0) {
            int last = n & 1;
            n = n >> 1;
            ans += last * base;
            base = base * 5;
        }
        System.out.println(ans);
    }

    static void myTryMagicNos(int n) {
        int i = 0, sum = 0;
        while (n > 0) {
            int bit = n & 1;
            sum = (int) (sum + bit * Math.pow(5, i + 1));
            n = n >> 1;
            i++;
        }
        System.out.println(sum);
    }
}
