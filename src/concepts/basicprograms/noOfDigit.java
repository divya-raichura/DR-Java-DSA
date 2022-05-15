package src.concepts.basicprograms;

import java.util.Scanner;
// this
public class noOfDigit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = (int) (Math.log10(n)+ 1);
        System.out.println(ans);
    }
}
// basically when you want to get no of digits in a particular no sys
// add that no system's base in log
// here we wanted for decimal so we did log 10
// if we want no of bits that is binary we do log 2 base