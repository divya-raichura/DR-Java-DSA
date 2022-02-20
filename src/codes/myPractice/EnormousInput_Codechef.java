package myPractice;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.codechef.com/problems/INTEST
public class EnormousInput_Codechef {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = in.nextInt();
        int k = in.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            list.add(in.nextInt());
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % k == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
