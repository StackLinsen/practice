package com.linsen.leetcode.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: linsen
 * @date: 2022/11/2
 * @description:
 */
public class No1293 {

    public int[][] dirt = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};


    public static void main(String[] args) {
        No1293 no1293 = new No1293();
        no1293.shortestPath(new int[][]{{0,1,1},{0,1,1},{0,0,0},{0,1,0},{0,1,0}}, 2);
    }

    public int shortestPath(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 && n == 1){
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        //这个地方不能只记录位置是否被访问过，而是应该记录该位置还剩下多少砖块时有没有被访问过
        //到达同一个位置并且剩余可以去除的砖块数也相等时，才证明先访问到的路径才是最短的
        boolean[][][] seen = new boolean[m][n][k+1];
        queue.offer(new int[]{0,0,k,0});
        seen[0][0][k] = true;
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            for(int d = 0; d < 4; d++){
                int dx = cell[0] + dirt[d][0];
                int dy = cell[1] + dirt[d][1];
                if(dx == m - 1 && dy == n - 1 && cell[2] >= 0){
                    return cell[3] + 1;
                }
                if(dx >= 0 && dx < m && dy >= 0 && dy < n){
                    if(grid[dx][dy] == 1 && !seen[dx][dy][cell[2] - 1]){
                        seen[dx][dy][cell[2] - 1] = true;
                        queue.offer(new int[]{dx,dy,cell[2] - 1, cell[3] + 1});
                    }else if(grid[dx][dy] == 0 && !seen[dx][dy][cell[2]]){
                        seen[dx][dy][cell[2]] = true;
                        queue.offer(new int[]{dx,dy,cell[2], cell[3] + 1});
                    }
                }
            }
        }
        return -1;
    }


}
