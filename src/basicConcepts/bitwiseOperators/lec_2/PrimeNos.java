package bitwiseOperators.lec_2;

import java.util.Scanner;

public class PrimeNos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // to find every no prime or not, till 'n', complexity is
        // we are running this 'n' times, prime no function below runs
        // 'sqrt of n' times, so final complexity is "n * sqrt(n)"
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " " + isPrime(i));
        }
    }


    // just to find whether a number if prime or not, complexity is sqrt of n
    static boolean isPrime(int n) {
        int c = 2;

        if (n <= 1) {
            return false;
        }

        while (c * c <= n) {

            if (n % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }
}
