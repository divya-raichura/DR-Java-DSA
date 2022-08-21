package com.company.questions;

import java.util.LinkedList;
import java.util.Queue;

public class FailedRottenOranges {
    public static void main(String[] args) {

        int[][] grid = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };

        FailedRottenOranges ans = new FailedRottenOranges();
        int count = ans.orangesRotting(grid);
        System.out.println(count);
    }

    public int orangesRotting(int[][] grid) {

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    int c = bfs(i, j, grid);
                    count += c;
                }
            }
        }

        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    return -1;
                }
            }
        }

        return count;
    }

    int bfs(int sr, int sc, int[][] grid) {

        int count = 0;
        int ifCount = 0;

        int[] rows = {-1, 0, 1, 0};
        int[] cols = {0, 1, 0, -1};

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));

        while (!queue.isEmpty()) {

            int r = queue.peek().r;
            int c = queue.peek().c;
            queue.remove();

            for (int i = 0; i < 4; i++) {

                int row = r + rows[i];
                int col = c + cols[i];

                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] != 0 && grid[row][col] != 2) {

                    grid[row][col] = 2;
                    queue.add(new Pair(row, col));
                    ifCount++;

                }

            }

            if (ifCount > 0) {
                count++;
                ifCount = 0;
            }

        }

        return count;
    }

    public int orangesRotting2(int[][] grid) {

        int initial = 0;
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    initial++;
                    queue.add(new Pair(i, j));
                }
            }
        }


        int count = bfs2(grid, queue, initial);

        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    return -1;
                }
            }
        }

        return count;
    }

    int bfs2(int[][] grid, Queue<Pair> queue, int initial) {



        int[] rows = {-1, 0, 1, 0};
        int[] cols = {0, 1, 0, -1};
        int count = 0;

        while (!queue.isEmpty()) {

            if(initial > 0) {
                initial--;
            } else {
                count++;
            }

            int r = queue.peek().r;
            int c = queue.peek().c;
            queue.remove();

            for (int i = 0; i < 4; i++) {

                int row = r + rows[i];
                int col = c + cols[i];

                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] != 0 && grid[row][col] != 2) {

                    grid[row][col] = 2;
                    queue.add(new Pair(row, col));


                }

            }
        }
        return count;
    }

    class Pair {
        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
