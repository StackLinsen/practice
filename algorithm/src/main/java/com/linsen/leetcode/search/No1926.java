package com.linsen.leetcode.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: linsen
 * @date: 2022/10/22
 * @description:
 */
public class No1926 {

    static int[][] dirt = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};


    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length;;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0],entrance[1],0});
        boolean[][] seen = new boolean[m][n];
        seen[entrance[0]][entrance[1]] = true;

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            for(int d = 0; d < 4; d++){
                int ni = i + dirt[d][0];
                int nj = j + dirt[d][1];
                if(ni >=0 && ni < m && nj >= 0 && nj < n && maze[ni][nj] == '.' && !seen[ni][nj]){
                    if(ni == 0 || ni == m-1 || nj == 0 || nj == n-1){
                        return cell[2] + 1;
                    }
                    queue.offer(new int[]{ni,nj,cell[2] + 1});
                    seen[ni][nj] = true;
                }
            }
        }
        return -1;
    }
}
