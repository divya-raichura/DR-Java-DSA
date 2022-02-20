package bitwiseOperators.lec_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Factors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        normal(n);
        System.out.println();
        optimised(n);
        System.out.println();
        optimisedSorted(n);
    }




    // in this case we have space complexity as well
    // so both time and space complexity is O(sqrt(n))
    static void optimisedSorted(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (n / i == i) { // cause of nos like 36, 36%6 == 36/36 in such cases it prints two times
                    // so this condition to print only once
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " ");
                    list.add(n/i);
                }
            }
        }
        for (int i = list.size()-1; i >= 0 ; i--) {
            System.out.print(list.get(i) + " ");
        }
    }

    // O(sqrt(n))
    static void optimised(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (n / i == i) { // cause of nos like 36, 36%6 == 36/36 in such cases it prints two times
                    // so this condition to print only once
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " " + n / i + " ");
                }
            }
        }
    }

    // O(n)
    static void normal(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

}
