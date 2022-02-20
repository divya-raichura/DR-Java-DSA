package bitwiseOperators.lec_1;

// https://www.includehelp.com/algorithms/fast-exponentiation-using-bitmasking.aspx

public class ApowerB {
    public static void main(String[] args) {
        int base = 4, ans = 1, pow = 4;
        while (base > 0) {
            int last_bit = (pow & 1);
            if (last_bit > 0) {
                ans = ans * base;
            }
            base = base * base;
            pow = pow >> 1;
        }
        System.out.println(ans);
    }
}
