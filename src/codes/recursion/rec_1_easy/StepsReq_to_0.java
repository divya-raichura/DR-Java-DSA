package com.topics.recursion.rec_1_easy;
// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class StepsReq_to_0 {
    public static void main(String[] args) {
        System.out.println(noOfSteps(6));
    }

    static int noOfSteps(int n) {
        return count(n, 0);
    }



    static int count(int n, int c) {

        if (n == 0) {
            return c;
        }

        if (n % 2 == 0) {
            return count(n / 2, ++c);
        }
        return count(n - 1, ++c);
    }

}
