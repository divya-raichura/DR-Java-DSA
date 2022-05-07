package src.basicTopics.basicprograms;

import java.util.Scanner;

public class PrimeNos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int c = 2;
        int count = 0;

        //        bad solution
//        while(c < num) {
//            if (num % c == 0) {
//                count++;
//                break;
//            }
//            c = c +1;
//        }
//        if (count == 0) {
//            System.out.println("prime");
//        } else {
//            System.out.println("not prime");
//        }

        System.out.println(main(num));
        System.out.println(main2(num));

    }

    // complexity 'n'
    static String main(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return "not prime";
            }
        }
        return "prime";
    }

    // instead of complexity 'n'
    // now the complexity is 'root n'
    static String main2(int n) {
//        for (int i = 2; i <= Math.pow(n, 0.5); i++) { // i*i<=n
//            if (n % i == 0) {
//                return "not prime";
//            }
//        }

        for (int i = 2; i * i <= n; i++) { // Math.pow(n, 0.5)
            if (n % i == 0) {
                return "not prime";
            }
        }
        return "prime";
    }


}
