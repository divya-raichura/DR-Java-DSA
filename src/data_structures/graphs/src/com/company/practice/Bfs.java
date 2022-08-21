package com.company.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {

    void bfs(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] vis = new boolean[v];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        vis[0] = true;
        ArrayList<Integer> ans = new ArrayList<>();
        int whileCount = 0;
        int forCount = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            ans.add(node);
            whileCount++;

            for (int n : adj.get(node)) {
                forCount++;
                if (!vis[n]) {
                    queue.add(n);
                    vis[n] = true;
                }
            }
        }
        System.out.println("bfs: " + ans);
        System.out.println("while loop : " + whileCount);
        System.out.println("for loop : " + forCount);
    }

    public static void main(String[] args) {
        Bfs bfs = new Bfs();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 4;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    adj.get(i).add(j);
                }
            }
        }
        System.out.println(adj);
        bfs.bfs(adj, n);
    }
}
