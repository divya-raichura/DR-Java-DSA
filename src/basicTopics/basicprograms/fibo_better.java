package src.basicTopics.basicprograms;

import java.util.Scanner;

public class fibo_better {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int count = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("fibo series till nth number\nn: ");
        int inp = in.nextInt();
        while (count <= inp) {
            System.out.print(a + " ");
            int temp = b;
            b = a + b;
            a = temp;
            count++;
        }

        int c = 0;
        int d = 1;
        System.out.print("\nfibo series till this number\nn: ");
        int input = in.nextInt();
        while (c <= input) {
            System.out.print(c + " ");
            int temp = d;
            d = c + d;
            c = temp;
            count++;
        }
    }
}
