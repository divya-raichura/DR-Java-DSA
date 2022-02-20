package bitwiseOperators.lec_2;

public class Sqrt {
    public static void main(String[] args) {
        int n = 40;
        int p = 3; // precision value
//        System.out.println(sqrt(4));
        System.out.println(sqrt(n, p));
        System.out.println(sqrtForLoopChanged(n, p));
    }



    // with point ans
    // Time : O(log(n))
    static double sqrt(int n, int p) {
        long s = 1;
        long e = n;
        double root = 0.0;
        while (s <= e) {
            long m = s + (e - s) / 2;

            if (m * m == n) {
                return m;
            }

            if (m * m > n) {
                e = m - 1;
            } else {
                s = m + 1;
                root = e;
            }
        }
        double increment = 0.1;
        for (int i = 0; i < p; i++) { // npt i <= p as we are taking from i = 0
            while (root * root <= n) {
                root = root + increment;
            }
            root = root - increment;
            increment /= 10;
        }
        return root;
    }

    static double sqrtForLoopChanged(int n, int p) {
        long s = 1;
        long e = n;
        double root = 0.0;
        while (s <= e) {
            long m = s + (e - s) / 2;

            if (m * m == n) {
                return m;
            }

            if (m * m > n) {
                e = m - 1;
            } else {
                s = m + 1;
                root = e;
            }
        }
        double increment = 0.1;
        for (int i = 1; i <= p; i++) { // npt i <= p as we are taking from i = 0
            while (root * root <= n) {
                root = root + increment;
            }
            root = root - increment;
            increment /= 10;
        }
        return root;
    }

    // perfect square
    static long sqrtPerfect(int n) {
        long s = 1;
        long e = n;
        while (s <= e) {
            long m = s + (e - s) / 2;

            if (m * m == n) {
                return m;
            }

            if (m * m > n) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return -1;
    }



}
