package com.company.PQquestions.newQ;

import java.util.Collections;
import java.util.PriorityQueue;

public class SumBetween {

    public static void main(String[] args) {
        sumBetween(new int[]{1, 3, 12, 5, 15, 11}, 3, 6);
    }

    public static void sumBetween(int[] arr, int k1, int k2) {
        int f = kthSmallest(arr, k1);
        int s = kthSmallest(arr, k2);
        int sum = 0;
        for (int n : arr) {
            if (n > f && n < s) {
                sum += n;
            }
        }
        System.out.println(sum);
    }

    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : arr) {
            pq.add(n);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.remove();
    }
}
