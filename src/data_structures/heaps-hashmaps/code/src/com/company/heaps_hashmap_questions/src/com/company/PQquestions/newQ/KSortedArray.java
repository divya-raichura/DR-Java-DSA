package com.company.PQquestions.newQ;

import java.util.PriorityQueue;

public class KSortedArray {

    public static void main(String[] args) {
        sortK(new int[]{6,5,3,2,8,10,9}, 3);
    }

    public static void sortK(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j : arr) {
            pq.add(j);
            if (pq.size() > k) {
                System.out.print(pq.remove() + " ");
            }
        }
        while (pq.size() > 0) {
            System.out.print(pq.remove() + " ");
        }
    }
}
