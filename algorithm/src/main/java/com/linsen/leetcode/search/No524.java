package com.linsen.leetcode.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: linsen
 * @date: 2022/10/14
 * @description:
 */
public class No524 {

    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};



    public int[][] updateMatrix(int[][] matrix){

        int m = matrix.length, n = matrix[0].length;

        int[][] dist = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    queue.offer(new int[]{i,j});
                    seen[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for(int d = 0; d < 4; d++){
                int ni = i + dirs[d][0];
                int nj = i + dirs[d][1];
                if(ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]){
                    dist[ni][nj] = dist[i][j] + 1;
                    //有些1不和0接壤，所以需要将已经统计过的1放入队列中，从这些格子开始进行深度为1广度优先搜索，如果搜索到则加1
                    //因为每个点只影响它周边的点，所以能保证最短，如果一个点有更短的路径，则他会在之前的广度优先中提前被便利到打上已经访问过的标签
                    queue.offer(new int[]{ni,nj});
                    seen[ni][nj] = true;
                }
            }
        }
        return dist;
    }
}
