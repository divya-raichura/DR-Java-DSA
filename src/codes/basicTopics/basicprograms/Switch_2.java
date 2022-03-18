package src.codes.basicTopics.basicprograms;

import java.util.Scanner;

public class Switch_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        char ch;
        do {
            System.out.println("1. Divya");
            System.out.println("2. Raichura");
            System.out.println("3. Exit");
            System.out.print("Input a number to start playing : ");
            n = in.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Divya");
                    break;
                case 2:
                    System.out.println("Raichura");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("input valid number");
            }
            System.out.println("wanna try again? y/n ");
            ch = in.next().trim().charAt(0);
        } while (ch == 'y');
    }
}
