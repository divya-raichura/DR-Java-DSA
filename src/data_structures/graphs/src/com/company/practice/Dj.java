package com.company.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dj {

    static void prims(ArrayList<ArrayList<Integer>> adj, int v, int source) {
        int[] mst = new int[v];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        mst[source] = 0;
        boolean[] vis = new boolean[v];
        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int w = pq.peek().weight;
            pq.remove();
            vis[node] = true;


        }

    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] dis = new int[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[S] = 0;
        pq.add(new Pair(S, 0));
        boolean[] vis = new boolean[S];

        while(!pq.isEmpty()) {
            int node = pq.peek().node;
            int w = pq.peek().weight;
            pq.remove();
            vis[node] = true;

            if(dis[node] < w) continue;

            for (ArrayList<Integer> l : adj.get(node)) {

                int neighbour = l.get(0);
                int edge = l.get(1);
                if(vis[neighbour]) {
                    continue;
                }

                if(dis[neighbour] > dis[node] + edge) {
                    dis[neighbour] = dis[node] + edge;
                    pq.add(new Pair(neighbour, dis[neighbour]));
                }

            }
        }

        return dis;

    }

    static class Pair implements Comparable<Pair>{
        int node;
        int weight;
        Pair (int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }
}
