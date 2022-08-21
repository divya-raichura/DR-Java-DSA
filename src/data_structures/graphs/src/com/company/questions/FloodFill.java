package com.company.questions;

public class FloodFill {

//    https://leetcode.com/problems/flood-fill/solution/

    // sol 1

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r - 1, c, color, newColor);
            if (c >= 1) dfs(image, r, c - 1, color, newColor);
            if (r + 1 < image.length) dfs(image, r + 1, c, color, newColor);
            if (c + 1 < image[0].length) dfs(image, r, c + 1, color, newColor);
        }
    }

    // sol 2

    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        // row , col
        int[] rows = {-1, 0, 1, 0};
        int[] cols = {0, 1, 0, -1};
        dfs2(image, sr, sc, newColor, target, rows, cols);
        return image;
    }

    void dfs2(int[][] image, int sr, int sc, int newColor, int target, int[] rows, int[] cols) {
        image[sr][sc] = newColor;
        for (int i = 0; i < 4; i++) {
            int nrow = sr + rows[i];
            int ncol = sc + cols[i];
            if (nrow >= 0 && nrow < image.length && ncol >= 0 && ncol < image[0].length && image[nrow][ncol] == target && image[nrow][ncol] != newColor) {
                dfs2(image, nrow, ncol, newColor, target, rows, cols);
            }
        }
    }
}

// sol 3
//        class Solution {
//            public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//                if (image[sr][sc] == newColor) return image;
//                fill(image, sr, sc, image[sr][sc], newColor);
//                return image;
//            }
//
//            private void fill(int[][] image, int sr, int sc, int color, int newColor) {
//                if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
//                image[sr][sc] = newColor;
//                fill(image, sr + 1, sc, color, newColor);
//                fill(image, sr - 1, sc, color, newColor);
//                fill(image, sr, sc + 1, color, newColor);
//                fill(image, sr, sc - 1, color, newColor);
//            }
//        }