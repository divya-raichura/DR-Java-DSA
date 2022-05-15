package src.concepts.bitwiseOperators.lec_1;

public class RightmostSetPosn {
    public static void main(String[] args) {
        System.out.println(main(4));
    }

    static int main(int n) {

        // n and -n (ie) a number and its negative number in binary shows a unique observation
        // eg in binary,
        //  10 ==> 1010
        // -10 ==> 0110
        // we observe that part  before the rightmost set bit is complement of positive
        // number and after the rightmost set bit it always remains zero
        // so whenever we do '&' of a postive and negative number, bits before rightmost set bit
        // become zero cause of '&' and rightmost set bit remains as it is and after it all are zeros
        // hence we remain with 0010
        // log2(10) in decimal ==> log10(10) in binary, which equals 1
        // when we add '1' to ans we get the required ans (ie) the position of rightmost set bit
        // Hence the below formula...
        return (int) (1 + (Math.log(n & -n)/ Math.log(2)));
    }

}
