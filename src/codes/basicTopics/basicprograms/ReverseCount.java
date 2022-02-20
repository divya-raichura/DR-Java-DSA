package lectures.basicprograms;

import java.util.Scanner;

public class ReverseCount {
    public static void main(String[] args) {
//        int n = 123456;
//        int ans = 0;
//
//        while (n > 0) {
//            int rem = n % 10;
//            ans = ans * 10 + rem;
//            n /= 10;
//        }
//        System.out.println("Reverse number is " + ans);

//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter the number : ");
//        int n = in.nextInt();
//         while (n > 0) {
//             int rem = n % 10;
//             System.out.print("Reverse number is " + rem);
//             n/=10;
//          }
//
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        while(n > 0) {
            int rem = n % 10;
            System.out.print(rem);
            n/=10;
        }
    }
}

