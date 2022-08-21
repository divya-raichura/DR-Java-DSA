package com.company.practice;

import java.util.*;

public class Prims {
    public static void main(String[] args) {
//        System.out.println(map.values());
//        System.out.println(map.keySet());
//        System.out.println(map.entrySet());
//        Iterator<Integer> it = map.values().iterator();
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(map.values().iterator().next());
//        System.out.println(map.values().iterator().next());
    }

    static void prims(ArrayList<ArrayList<Pair>> adj, int noOfV, int src) {
        int index = 0, mstCost = 0;
        int noOfEdges = -1;
        int allowedNoOfEdges = noOfV - 1; // no of vertices - 1
        int[] mstEdges = new int[noOfV];
        int[] parent = new int[noOfV];
        boolean[] vis = new boolean[noOfV];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src, 0, -1));
        while (!pq.isEmpty() && noOfEdges != allowedNoOfEdges) {
            Pair node = pq.remove();
            if (vis[node.node]) continue;
            vis[src] = true;

            mstEdges[index] = node.node;
            parent[index] = node.parent;
            mstCost += node.w;
            index++;
            noOfEdges++;

            for (Pair neigh : adj.get(node.node)) {
                if (!vis[neigh.node]) {
                    pq.add(new Pair(neigh.node, neigh.w, node.node));
                }
            }
        }
        if (noOfEdges != allowedNoOfEdges) {
            System.out.println("mst not possible!!!");
            return;
        }
        System.out.println("mst cost : " + mstCost);
        System.out.println("mst edges : " + Arrays.toString(mstEdges));
        System.out.println("mst parent : " + Arrays.toString(parent));
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int w;
        int parent;

        Pair(int node, int w, int parent) {
            this.node = node;
            this.w = w;
            this.parent = parent;
        }

        @Override
        public int compareTo(Pair o) {
            return this.w - o.w;
        }
    }
}
