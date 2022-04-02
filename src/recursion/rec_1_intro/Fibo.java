package recursion.recursion_intro;

import java.util.Scanner;

public class Fibo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("nth fibo no is : " + fiboRecursion(n));
    }


    static int fiboRecursion(int n) {
        // base condition
        if (n < 2) {
            return n;
        }

        // this does extra step of adding and then returning, it is not returning directly
        // hence this is not tail recursion
        return fiboRecursion(n - 1) + fiboRecursion(n - 2);
    }


    static int fibo(int n) {
        // 0, 1, 1, 2, 3, 5, 8, 13, ...
        int a = 0;
        int b = 1;
        int count = 2;
        while (count <= n) {
            int temp = b;
            b = a + b;
            a = temp;
            count++;
        }
        return b;
    }
}
