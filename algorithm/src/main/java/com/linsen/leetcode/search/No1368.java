package com.linsen.leetcode.search;

import java.util.*;

/**
 * @author: linsen
 * @date: 2022/11/7
 * @description: 1368.Minimum Cost to Make at Least One Valid Path in a Grid
 * Return the minimum cost to make the grid have at lease one valid path
 * The valid path does not have to be the shortest.
 */
public class No1368 {
    int[][] dirts = {{0,1},{0,-1},{1,0},{-1,0}};


    /**
     * 每条边的权值不再是1，所以一个点"权值路径"小于当前的就可以加入队列
     * 也可以用双端队列来优化时间
     * @param grid
     * @return
     */
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == n && m == 1){
            return 0;
        }

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
            for(int i = 0; i < 4; i++){
                int dx = dirts[i][0] + x, dy = dirts[i][1] + y;
                if(dx >= 0 && dx < m && dy >= 0 && dy < n){
                    int cost = grid[x][y] == i+1 ? 0 : 1;
                    if(seen[x][y] + cost < seen[dx][dy]){
                        queue.add(new int[]{dx,dy});
                        seen[dx][dy] = seen[x][y] + cost;
                    }
                }
            }
        }
        return seen[m-1][n-1];

    }

}
