package com.company.questions;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargeElements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for  (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        // O(nlogk)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j : arr) {
            if (pq.size() < k) {
                pq.add(j);
            } else {
                if (j > pq.peek()) {
                    pq.remove();
                    pq.add(j);
                }
            }
        }

        while (pq.size() > 0) {
            System.out.println(pq.peek());
        }
    }
}
