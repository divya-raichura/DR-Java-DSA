package com.company.practice;

import java.util.*;

public class DjBfs {
    public static void main(String[] args) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        int n = 3;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // -ve
//        adj.get(0).add(new Pair(1, 10));
//        adj.get(1).add(new Pair(2, -8));
//        adj.get(0).add(new Pair(2, 5));

//        adj.get(0).add(new Pair(1, -2));
//        adj.get(1).add(new Pair(0, -2));

        adj.get(0).add(new Pair(1, 6));
        adj.get(1).add(new Pair(2, -12));
        adj.get(2).add(new Pair(0, -7));

        // 0
//        adj.get(0).add(new Pair(3, 1));
//        adj.get(0).add(new Pair(1, 4));
        // 1
//        adj.get(1).add(new Pair(0, 4));
//        adj.get(1).add(new Pair(2, 1));
//        adj.get(1).add(new Pair(3, 2));
//
//        // 2
//        adj.get(2).add(new Pair(1, 1));
//        adj.get(2).add(new Pair(6, 2));
//
//        // 3
//        adj.get(3).add(new Pair(0, 1));
//        adj.get(3).add(new Pair(4, 3));
//        adj.get(3).add(new Pair(1, 2));
//
//        // 4
//        adj.get(4).add(new Pair(3, 3));
//        adj.get(4).add(new Pair(5, 2));
//
//        // 5
//        adj.get(5).add(new Pair(4, 2));
//        adj.get(5).add(new Pair(6, 1));
//
//        // 6
//        adj.get(6).add(new Pair(2, 2));
//        adj.get(6).add(new Pair(5, 1));
//        adj.get(6).add(new Pair(7, 4));
//        adj.get(6).add(new Pair(8, 3));
//
//        // 7
//        adj.get(7).add(new Pair(6, 4));
//        adj.get(7).add(new Pair(8, 1));
//
//
//        // 8
//        adj.get(8).add(new Pair(6, 3));
//        adj.get(8).add(new Pair(7, 1));

//        adj.get(0).add(new Pair(1, 10));
//        adj.get(0).add(new Pair(2, 20));
//        adj.get(1).add(new Pair(0, 10));
//        adj.get(1).add(new Pair(3, 5));
//        adj.get(2).add(new Pair(3, 5));
//        adj.get(2).add(new Pair(0, 20));

        //
//        adj.get(0).add(new Pair(1, 3));
//        adj.get(0).add(new Pair(2, 1));
//
//        adj.get(1).add(new Pair(0, 3));
//        adj.get(1).add(new Pair(2, 1));
//
//        adj.get(2).add(new Pair(0, 1));
//        adj.get(2).add(new Pair(1, 1));


//        System.out.println(Arrays.toString(path(adj, n)));
//        System.out.println(Arrays.toString(bfs(adj, n)));
//        System.out.println();
//        System.out.println(Arrays.toString(dijkstra(adj, n)));

        // what does path(bfs) do here? it calculates shortest path to end node
        // "shortest path" means that it tells the path to an edge which has least
        // number of edges not "edge weight" along its path

        // while the dijkstra tells shortest path according to the edge weight
        // bfs() is modified version which works like dijkstra but isn't as efficient

        // negative paths
        // a = 0; b = 2; c = 1; d = 3
        // a
//        adj.get(0).add(new Pair(1, 0)); // a to c
//        adj.get(0).add(new Pair(2, 1)); // a to b
//        adj.get(0).add(new Pair(3, 99)); // a to d

        // b
//        adj.get(2).add(new Pair(1, 1));

        // c

        // d
//        adj.get(3).add(new Pair(2, -300));

//        bfs(adj, n);
//        dijkstra(adj, n);
        System.out.println("\n\nnegative...\n");
        dijkstraNegative(adj, n);
    }

    static void path(ArrayList<ArrayList<Pair>> adj, int n) {
        Queue<Pair> q = new LinkedList<>();
        int[] path = new int[n];
        boolean[] vis = new boolean[n];
        vis[0] = true;
        q.add(new Pair(0, 0));
        while (!q.isEmpty()) {
            int node = q.remove().node;
            for (Pair ne : adj.get(node)) {
                if (!vis[ne.node]) {
                    vis[ne.node] = true;
                    path[ne.node] = node;
                    q.add(ne);
                }
            }
        }

        System.out.println("bfs path: " + Arrays.toString(path));
    }

    static void bfs(ArrayList<ArrayList<Pair>> adj, int n) {
        int[] dis = new int[n];

        Queue<Pair> q = new LinkedList<>();
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        q.add(new Pair(0, 0));

        while (!q.isEmpty()) {
            int node = q.peek().node;
            q.remove();
            for (Pair neighbour : adj.get(node)) {
                if (dis[neighbour.node] > dis[node] + neighbour.weight) {
                    dis[neighbour.node] = dis[node] + neighbour.weight;
                    q.add(neighbour);
                }
            }
        }
        System.out.println("bfs dis : " + Arrays.toString(dis));
    }

    // below one works for negative edges but fails in case of cycles(runs infinitely)
    // eg : 1 -----(-2)----- 2
    // in above graph it will again and again go back and forth
    static void dijkstraNegative(ArrayList<ArrayList<Pair>> adj, int n) {
        int[] dis = new int[n];
        int[] nodeAtThatIndexOfDis = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Integer[] prev = new Integer[n];

        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            pq.remove();

            for (Pair neighbour : adj.get(node)) {
                if (dis[neighbour.node] > dis[node] + neighbour.weight) {
                    dis[neighbour.node] = dis[node] + neighbour.weight;
                    prev[neighbour.node] = node;
                    nodeAtThatIndexOfDis[neighbour.node] = neighbour.node;
                    pq.add(new Pair(neighbour.node, dis[neighbour.node]));
                }
            }
        }

        System.out.println("dij dis : " + Arrays.toString(dis));
        System.out.println("nodeAtThatIndexOfDis dis : " + Arrays.toString(nodeAtThatIndexOfDis));
        System.out.println("prev: " + Arrays.toString(prev));
        System.out.println("printing prev in style...");
        List<Integer> path = new ArrayList<>();
        for (Integer i = prev.length-1 ; i != null; i = prev[i]) {
            path.add(i);
        }
        Collections.reverse(path);
        for (int i = 0; i < path.size(); i++) {
            String s = (i < path.size() - 1) ? path.get(i) + " => " : path.get(i) + "";
            System.out.print(s);
        }
    }

    // this implementation will fail for all negative edges and it may/may not
    // give shortest path to a node in graphs having negative edges
    // in short, this implementation ignores visited edges hence may or may not work in
    // -ve edge weight graphs
    static void dijkstra(ArrayList<ArrayList<Pair>> adj, int n) {
        int[] dis = new int[n];
        int[] nodeAtThatIndexOfDis = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Integer[] prev = new Integer[n];

        boolean[] vis = new boolean[n]; // imp for negative edges

        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int w = pq.peek().weight;
            pq.remove();

            // for duplicate values in pq we directly remove them instead of going
            // further in the for loop, this improves efficiency
            if (dis[node] < w) continue;

            vis[node] = true; // imp for negative edge

            for (Pair neighbour : adj.get(node)) {
                if (vis[neighbour.node]) continue;
                if (dis[neighbour.node] > dis[node] + neighbour.weight) {
                    dis[neighbour.node] = dis[node] + neighbour.weight;
                    prev[neighbour.node] = node;
                    nodeAtThatIndexOfDis[neighbour.node] = neighbour.node;
                    pq.add(new Pair(neighbour.node, dis[neighbour.node]));
                }
            }
        }

        System.out.println("dij dis : " + Arrays.toString(dis));
        System.out.println("nodeAtThatIndexOfDis dis : " + Arrays.toString(nodeAtThatIndexOfDis));
        System.out.println("prev: " + Arrays.toString(prev));
        System.out.println("printing prev in style...");
        List<Integer> path = new ArrayList<>();
        for (Integer i = prev.length-1 ; i != null; i = prev[i]) {
            path.add(i);
        }
        Collections.reverse(path);
        for (int i = 0; i < path.size(); i++) {
            String s = (i < path.size() - 1) ? path.get(i) + " => " : path.get(i) + "";
            System.out.print(s);
        }
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }
}
