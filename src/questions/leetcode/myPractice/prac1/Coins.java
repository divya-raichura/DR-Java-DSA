package myPractice;

import java.math.BigInteger;
import java.util.Scanner;

public class Coins {
    static void getRows() {
        Scanner in = new Scanner(System.in);
        BigInteger N = new BigInteger(in.next());
        BigInteger inc = new BigInteger("1");
        BigInteger limit = new BigInteger("1");
        BigInteger count = new BigInteger("0");
        while (true) {
            if (limit.compareTo(N) < 0) {
                N = N.subtract(limit);
                limit = limit.add(inc);
                count = count.add(inc);
            } else {
                break;
            }
        }
        if (limit.compareTo(N) == 0) {
            count = count.add(inc);
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Coins c = new Coins();
        c.getRows();
    }

}
