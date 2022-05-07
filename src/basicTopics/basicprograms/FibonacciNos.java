package src.basicTopics.basicprograms;

import java.util.Scanner;

public class FibonacciNos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 0,1,1,2,3,5,8,13,21 ...
        int n = in.nextInt(); // 7 -> 13
        int a = 0;
        int b = 1;
        int count = 2;

        while(count <= n) {
            int temporary = b;
            b = b + a;
            a = temporary;
            count++;
        }
        System.out.println(b);

        /*
              Fibonacci Numbers question using for loop
                     0,1,1,2,3,5,8,13...
        int a = 0;
        int b = 1;
        int input = in.nextInt(); // input = 7 toh fir output = 13 ana mangta
        for (int i = 2; i <= input; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        System.out.println(b);
         */

    }
}
