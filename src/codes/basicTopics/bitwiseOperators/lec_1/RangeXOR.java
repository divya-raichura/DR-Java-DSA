package bitwiseOperators.lec_1;

public class RangeXOR {
    public static void main(String[] args) {
        // xor for the range a to b
        // xor = 0 to (a - 1) ^ 0 to b
        int a = 3;
        int b = 9;

        int ans = xor(a - 1) ^ xor(b);
        System.out.println(ans);

        // only to cross check, time limit exceed(tle) for large nos
        int ans2 = 0;
        for (int i = a; i <= b; i++) {
            ans2 = ans2 ^ i;
        }
        System.out.println(ans2);
        // ans1 = ans2 (ans2 == time limit exceed(tle) for large nos)
    }


    // this gives xor from 0 to a
    static int xor(int a) {
        if (a % 4 == 0) {
            return a;
        }

        if (a % 4 == 1) {
            return 1;
        }

        if (a % 4 == 2) {
            return a + 1;
        }

        return 0;
    }
}
