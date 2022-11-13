package com.company.PQquestions.newQ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class NearOrigin {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 3},
                {-2, 2}
        };
        kClosest(arr, 1);
    }

    public static int[][] kClosest(int[][] points, int k) {
        // max-heap
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        return o2.d - o1.d;
                    }
                }
        );
        for (int[] rows : points) {
            int x = rows[0];
            int y = rows[1];
            int d = x * x + y * y;
            Pair p = new Pair(new int[]{x, y}, d);
            pq.add(p);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        int[][] arr = new int[pq.size()][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = pq.remove().p;
        }
        for (int[] r : arr) {
            System.out.println(Arrays.toString(r));
        }
        return arr;
    }

    static class Pair {
        int[] p;
        int d;

        public Pair(int[] p, int d) {
            this.p = p;
            this.d = d;
        }
    }
}
