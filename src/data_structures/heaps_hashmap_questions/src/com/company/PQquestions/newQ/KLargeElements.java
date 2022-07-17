package com.company.PQquestions.newQ;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargeElements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("arr size : ");
        int n = in.nextInt();
        System.out.print("k : ");
        int k = in.nextInt();
        int[] arr = new int[n];
        for  (int i = 0; i < n; i++) {
            System.out.print("element : ");
            arr[i] = in.nextInt();
        }
        kLargestElements(arr, k);
    }

    public static void kLargestElements(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j : arr) {
            pq.add(j);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        System.out.print("ans : ");
        while (pq.size() > 0) {
            System.out.print(pq.remove() + " ");
        }
    }
}
