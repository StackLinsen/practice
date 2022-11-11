package com.linsen.leetcode.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: linsen
 * @date: 2022/10/20
 * @description:
 */
public class No1091 {


    int[][] dirt = new int[][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};



    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] != 0 || grid[n-1][n-1] != 0){
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        boolean[][] seen = new boolean[n][n];
        seen[0][0] = true;
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for(int d = 0; d < 8; d++){
                int ni = i + dirt[d][0];
                int nj = j + dirt[d][1];
                if(ni >= 0 && ni < n && nj >= 0 && nj < n && !seen[ni][nj]){
                    if(grid[ni][nj] == 0){
                        queue.offer(new int[]{ni,nj,cell[2] + 1});
                        seen[ni][nj] = true;
                    }
                    if(ni == n-1 && nj == n-1){
                        return cell[2] + 1;
                    }
                }
            }
        }
        return -1;
    }





}
