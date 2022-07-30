package com.company.implementation;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            list.get(u).add(v);
            list.get(v).add(u); // for undirected graph
        }
    }
}
