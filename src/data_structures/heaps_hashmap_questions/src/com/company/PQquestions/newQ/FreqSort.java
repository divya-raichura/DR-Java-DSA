package com.company.PQquestions.newQ;

import java.util.*;

public class FreqSort {

    public static void main(String[] args) {
        frequencySort(new int[]{1,1,2,2,2,3});
    }


    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()) == 0 ? Integer.compare(b.getKey(), a.getKey()) : Integer.compare(a.getValue(), b.getValue()));
        minHeap.addAll(map.entrySet());
        int[] arr = new int[nums.length];
        int i = 0;
        while (minHeap.size() > 0) {
            Map.Entry<Integer, Integer> entry = minHeap.remove();
            int k = entry.getKey();
            int v = entry.getValue();
            while (v-- > 0) {
                arr[i] = k;
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
