package com.company.PQquestions.newQ;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KSortedArrMethod2 {
    public static void main(String[] args) {

//        k space and n(logk) complexity
//        n is the size of arr and k is the number of elements and logK means height 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for  (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k + 1; i < arr.length; i++) {
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }

        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }
    }
}
