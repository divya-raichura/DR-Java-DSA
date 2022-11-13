package com.company.questions;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public static void main(String[] args) {

    }

    static class Pair implements Comparable<Pair> {

        int val;
        int li;
        int di;

        public Pair(int val, int li, int di) {
            this.val = val;
            this.li = li;
            this.di = di;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }

    public ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < lists.size(); i++) {
            Pair p = new Pair(lists.get(i).get(0), i, 0);
            pq.add(p);
        }
        while (pq.size() > 0) {
            Pair p = pq.remove();
            ans.add(p.val);
            p.di++;

            if (p.di < lists.get(p.li).size()) {
                p.val = lists.get(p.li).get(p.di);
                pq.add(p);
            }
        }
        return ans;
    }
}
