package src.codes.basicTopics.bitwiseOperators.lec_1;

public class OddEven {
    public static void main(String[] args) {
        int a = 68; // 68 is not odd, so it will give false
        System.out.println(isOdd(a));
    }

    private static boolean isOdd(int n) {
        // wkt if lsb is 1 in binary, then the no is odd
        // and '&' of any no with 'one' gives no itself, so n & 1 will give lsb no
        // as n&1 implies nos before lsb will do & with 0 and & of any no with 0 is 0
        // and if it equals 1 then no is odd and return true else,
        // no is even and return false

        // also, even though here n is decimal, internally it gets converted to binary
        // and then & operation is done
        return (n & 1) == 1;
    }
}
