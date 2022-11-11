package com.linsen.leetcode.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: linsen
 * @date: 2022/11/10
 * @description:
 */
public class No490 {

    int[][] dirts = {{0,1},{0,-1},{-1,0},{1,0}};

    public static void main(String[] args) {
        No490 no490 = new No490();
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0,4};
        int[] des = {3,2};
        System.out.println(no490.hasPath(maze, start, des));
    }




    public boolean hasPath(int[][] maze, int[] start, int[] destination){

            int m = maze.length, n = maze[0].length;
            int sx = start[0], sy = start[1];
            int dx = destination[0], dy = destination[1];
            if(sx == dx && sy == dy){
                return true;
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{sx,sy});
            boolean[][] seen = new boolean[m][n];
            seen[sx][sy] = true;

            while(!queue.isEmpty()){
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for(int d = 0; d < 4; d++){
                    int nx = x, ny = y;
                    int a = dirts[d][0], b = dirts[d][1];
                    while(nx+a >= 0 && nx+a < m && ny+b>=0 && ny+b < n && maze[nx+a][ny+b] == 0){
                        //还在边界内活着还没有遇到墙就一直往下走
                        nx += a;
                        ny += b;
                    }
                    if(nx == dx && ny == dy){
                        return true;
                    }
                    if(!seen[nx][ny]){
                        seen[nx][ny] = true;
                        queue.offer(new int[]{nx,ny});
                    }

                }
            }
            return false;
    }
}
