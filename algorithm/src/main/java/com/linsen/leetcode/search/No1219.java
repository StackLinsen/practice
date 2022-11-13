package com.linsen.leetcode.search;

/**
 * @author: linsen
 * @date: 2022/11/12
 * @description: 黄金矿工 Path with Maximun Gold
 */
public class No1219 {


    int[][] dirts = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        No1219 no1219 = new No1219();
//        int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
        int[][] grid = {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};
        System.out.println(no1219.getMaximumGold(grid));
    }


    public int getMaximumGold(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int max = 0;
        boolean[][] seen = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] != 0){
                    //可以开始采矿
                    max = Math.max(max, dfs(i, j, grid, seen));
                }
            }
        }
        return max;
    }

    private int dfs(int x, int y, int[][] grid, boolean[][] seen) {
        int m = grid.length, n = grid[0].length;
        int sum = 0;
        seen[x][y] = true;
        for(int d = 0; d < 4; d++){
            int nx = dirts[d][0] + x, ny = dirts[d][1] + y;
            if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                if(grid[nx][ny] != 0 && !seen[nx][ny]){
                    sum = Math.max(sum, dfs(nx, ny, grid, seen));
                }
            }
        }
        seen[x][y] = false;
        return sum + grid[x][y];
    }


}
