package bitwiseOperators.lec_1;

public class RightmostSetPosn {
    public static void main(String[] args) {
        System.out.println(main(4));
    }

    static int main(int n) {
        return (int) (1 + (Math.log(n & -n)/ Math.log(2)));
    }

}
