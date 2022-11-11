package com.linsen.leetcode.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: linsen
 * @date: 2022/10/15
 * @description:
 */
public class No1765 {

    static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};


    public static void main(String[] args) {
        No1765 no1765 = new No1765();
        no1765.highestPeak(new int[][]{{0,1},{0,0}});
    }


    public int[][] highestPeak(int[][] isWater) {

        //1.先遍历所有格子，将格子为1的（水域）高度设置为0，并放入队列
        int m = isWater.length, n = isWater[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] height = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isWater[i][j] == 1){
                    height[i][j] = 0;
                    queue.offer(new int[]{i,j});
                    seen[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            for (int d = 0; d < 4; d++){
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];
                if(ni >= 0 && ni < m && nj >= 0 && nj < n){
                    if(!seen[ni][nj] && isWater[ni][nj] == 0){
                        //没有被扫描的陆地，则高度加1
                        height[ni][nj] = height[i][j] + 1;
                        seen[ni][nj] = true;
                        queue.offer(new int[]{ni,nj});
                    }
                }
            }
        }
        return height;
    }

}
