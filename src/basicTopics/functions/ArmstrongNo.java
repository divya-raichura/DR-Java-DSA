package functions;

import java.util.Scanner;

public class ArmstrongNo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        System.out.print("Enter a three digit number: ");
//        int n = in.nextInt();
//        boolean ans = isArmstrong(n);
//        System.out.println(ans);

//        print all three digit armstrong nos
        for (int i = 100; i < 1000; i++) {
            if (isArmstrong(i)) {
                System.out.print(i + " ");
            }
        }
    }
    static boolean isArmstrong(int n) {
        int sum = 0;
        int original = n;

        while(n > 0) {
            int rem = n % 10;
            sum = sum + rem*rem*rem;
            n = n / 10;
        }
//        if (sum == original) {
//            return true;
//        }
//        return false;
        return sum == original;
    }
}

// code for printing all three digit armstrong numbers


