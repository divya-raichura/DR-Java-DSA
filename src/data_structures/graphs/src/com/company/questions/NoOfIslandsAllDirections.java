package com.company.questions;

public class NoOfIslandsAllDirections {
    public static void main(String[] args) {

    }

    // for bfs approach see striver's lecture

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] != '0') {
                    count++;
                    dfs(grid,i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int sr, int sc) {
        if(sr < 0 || sr >= grid.length || sc < 0 || sc >= grid[0].length || grid[sr][sc] == '0') return;
        grid[sr][sc] = '0';
        dfs(grid, sr - 1, sc);
        dfs(grid, sr, sc + 1);
        dfs(grid, sr + 1, sc);
        dfs(grid, sr, sc - 1);
        dfs(grid, sr - 1, sc + 1);
        dfs(grid, sr + 1, sc + 1);
        dfs(grid, sr + 1, sc - 1);
        dfs(grid, sr - 1, sc - 1);
    }
}
