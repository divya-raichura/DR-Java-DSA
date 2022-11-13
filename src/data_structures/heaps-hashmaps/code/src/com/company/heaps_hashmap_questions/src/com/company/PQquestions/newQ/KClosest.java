package com.company.PQquestions.newQ;

import java.util.*;

public class KClosest {

    public static void main(String[] args) {
        findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
    }

    // can be solved by binary search
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int j : arr) {
            Pair p = new Pair(Math.abs(j - x), j);
            pq.add(p);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        while (pq.size() > 0) {
            list.add(pq.remove().val);
        }
        Collections.sort(list);
        System.out.println(list);
        return list;
    }

    static class Pair implements Comparable<Pair> {

        int diff;
        int val;

        public Pair(int diff, int val) {
            this.diff = diff;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.diff - o.diff == 0) return this.val - o.val;
            return this.diff - o.diff;
        }
    }
}

