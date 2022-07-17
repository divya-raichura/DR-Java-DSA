package com.company.PQquestions.newQ;

import java.util.PriorityQueue;

public class MinRopes {

    public static void main(String[] args) {
        System.out.println(ropes(new int[]{1, 2, 3, 4, 5}));
    }

    public static int ropes(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : arr) {
            pq.add(n);
        }
        int ans = 0;
        while (pq.size() >= 2) {
            int first = pq.remove();
            int second = pq.remove();
            int sum = first + second;
            ans += sum;
            pq.add(sum);
        }
        return ans;
    }
}
