package recursion.rec_1_easy;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String name = in.next();
//        System.out.println(palindrome(name, 0, name.length() - 1));
//        System.out.println(palindrome2(name, 0, name.length() - 1));
        System.out.println(palindrome3(2202022)); // date of 20/2/2022
    }

    static boolean palindrome(String name, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (name.charAt(start) != name.charAt(end)) {
            return false;
        }
        ++start;
        --end;
        return palindrome(name, start, end);
    }

    static boolean palindrome2(String name, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (name.charAt(start) != name.charAt(end)) {
            return false;
        }

        return palindrome(name, ++start, --end);
    }


//     2nd method (for integers only)
    static boolean palindrome3(int n) {
        return n == reverse(n, 0);
    }

    static int reverse(int n, int ans) {
//        if (n % 10 == n) {
//            return ans * 10 + n % 10;
//        }
        if (n == 0) {
            return ans;
        }
        ans = ans * 10 + n % 10;
        return reverse(n / 10, ans);
    }

}
