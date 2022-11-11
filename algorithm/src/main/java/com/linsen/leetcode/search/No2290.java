package com.linsen.leetcode.search;

import java.util.*;

/**
 * @author: linsen
 * @date: 2022/11/9
 * @description:
 */
public class No2290 {

    public int[][] dirts = {{0,1},{0,-1},{1,0},{-1,0}};


    /**
     * 普通的队列，时间会超过
     * @param grid
     * @return
     */
    public int minimumObstacles(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int[][] seen = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(seen[i], Integer.MAX_VALUE);
        }
        seen[0][0] = 0;
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for(int[] d : dirts){
                int dx = d[0] + x, dy = d[1] + y;
                if(dx >= 0 && dx < m && dy >= 0 && dy < n){
                    if(seen[x][y] + grid[dx][dy] < seen[dx][dy]){
                        seen[dx][dy] = seen[x][y] + grid[dx][dy];
                        queue.offer(new int[]{dx,dy});
                    }
                }
            }
        }
        return seen[m-1][n-1];
    }


    public int minimumObstacles_deque(int[][] grid){
        int m = grid.length, n = grid[0].length;

        int[][] dis = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        dis[0][0] = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[]{0,0});
        while(!deque.isEmpty()){
            int[] cell = deque.pollFirst();
            int x = cell[0], y = cell[1];
            for(int[] d : dirts){
                int nx = x + d[0], ny = y + d[1];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                    int g = grid[nx][ny];
                    if(dis[x][y] + g < dis[nx][ny]){
                        dis[nx][ny] = dis[x][y] + g;
                        if(g == 0){
                            deque.addFirst(new int[]{nx,ny});
                        }else{
                            deque.addLast(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return dis[m-1][n-1];
    }

}
