 package bitwiseOperators.lec_1;


public class PowOf2 {
    public static void main(String[] args) {
        System.out.println(powerOneStep(8));
        System.out.println(power(8));
    }




    static boolean powerOneStep(int n) {
        return (n & (n-1)) == 0; // exception for '0'
        // gives true for '0', should give false
    }

    // loop method... correct for all
    static boolean power(int n) {
        int count = 0;
        while (count < 2 && n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count == 1;
    }

}
