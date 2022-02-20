package FiboFormula;

public class FiboFormula {
    public static void main(String[] args) {
        for (int i = 0; i <= 11; i++) {
            System.out.println(fibo(i));
        }
    }

    static int fibo(int n) {


        return (int) ((Math.pow((1 + Math.sqrt(5)) / 2, n) - Math.pow((1 - Math.sqrt(5)) / 2, n)) / Math.sqrt(5));
        // we can ignore the second term as it is less dominating
        // but it gives wrong ans for one of the nos
        // so above one is best
//        return (int) (Math.pow((1 + Math.sqrt(5)) / 2, n) / Math.sqrt(5));
    }

    static int fiboRec(int n) {
        if (n < 2) {
            return n;
        }
        return fiboRec(n - 1) + fiboRec(n - 2);
    }

}
