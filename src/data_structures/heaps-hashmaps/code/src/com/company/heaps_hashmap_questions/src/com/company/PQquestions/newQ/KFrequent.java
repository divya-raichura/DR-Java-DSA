package com.company.PQquestions.newQ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KFrequent {

    public static void main(String[] args) {
        int[] ans = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(ans));
    }


    //    https://leetcode.com/problems/top-k-frequent-elements/discuss/81635/3-Java-Solution-using-Array-MaxHeap-TreeMap
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i : map.keySet()) {
            Pair p = new Pair(i, map.get(i));
            pq.add(p);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        int[] ans = new int[pq.size()];
        int n = pq.size();
        for (int i = 0; i < n; i++) {
            ans[i] = pq.remove().k;
        }
        return ans;
    }

    /*
     * exactly what I wanted

       public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            minHeap.add(entry);
            if (minHeap.size() > k) minHeap.poll();
        }

        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
     */


    static class Pair implements Comparable<Pair> {

        int k;
        int v;

        public Pair(int k, int v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public int compareTo(Pair o) {
            return this.v - o.v;
        }
    }
}
