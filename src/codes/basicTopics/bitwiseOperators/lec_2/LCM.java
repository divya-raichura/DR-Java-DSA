package bitwiseOperators.lec_2;

public class LCM {
    public static void main(String[] args) {

    }


    static int lcm(int a, int b) {
        return a * b / gcdRemainder(a, b);
    }

    static int gcdRemainder(int a, int b) { // valid only for a > b
        if (b == 0) {
            return a;
        }

        return gcdRemainder(b, a % b);
    }

}
