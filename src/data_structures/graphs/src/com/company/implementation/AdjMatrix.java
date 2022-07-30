package com.company.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class AdjMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] adjMatrix = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            adjMatrix[u][v] = 1;
            adjMatrix[v][u] = 1; // for undirected graph
        }

        for (int[] arr : adjMatrix) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
