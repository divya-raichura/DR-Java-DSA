package com.topics.recursion.rec_1_easy;

public class Reverse {

    // using this method of taking variable outside :-
    static int sum = 0;

    static void rev1(int n) {
        if (n == 0) {
            return;
        }

        int rem = n % 10;
        sum = sum * 10 + rem;

        rev1(n / 10);
    }



// for palindrome program, also wrote in its class

//    static boolean palindrome(int n) {
//        return n == reverse(n, 0);
//    }

    // my try
    static int reverse(int n, int ans) {
        if (n % 10 == n) {
            return ans * 10 + n % 10; // ans * 10 + n; bhi lik sakte
        }
        ans = ans * 10 + n % 10;
        return reverse(n / 10, ans);
    }

    // or with diff base condition :-

    static int reverseTRY(int n, int ans) {
        if (n == 0) {
            return ans; // ans * 10 + n; bhi lik sakte
        }
        ans = ans * 10 + n % 10;
        return reverse(n / 10, ans);
    }



    // using helper function concept
    static int rev(int n) {
        int digits = (int) (Math.log10(n)) + 1;
        return helper(n, digits);
    }

    static int helper(int n, int digits) {
        if (n % 10 == n) {
            return n;
        }
        int rem = n % 10;
        return rem * (int) (Math.pow(10, digits - 1)) + helper(n / 10, digits - 1);
    }


    public static void main(String[] args) {
        System.out.println(rev(1234));
        System.out.println(reverse(1234, 0));
        System.out.println(reverseTRY(1234, 0));

        rev1(1234);
        System.out.println(sum);
    }

}
