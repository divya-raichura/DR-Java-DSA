package bitwiseOperators.lec_2;

import java.util.Scanner;

public class NewtonSQRT {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(sqrt(n));
    }

    static double sqrt(int n) {
        double root;
        double x = n;
        while (true) {
            root = 0.5 * (x + n / x);

            if (Math.abs(root - x) < 1) { // also take < 0.5, jitna kam karenge
                // utna close jayenge ans ke, but then, the steps will increase
                break;
            }
            x = root;
        }
        return root;
    }

}
