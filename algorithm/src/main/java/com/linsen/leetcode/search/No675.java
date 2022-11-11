package com.linsen.leetcode.search;


import java.util.*;

/**
 * 675 Cut off Trees for Golf Event
 * @author: linsen
 * @date: 2022/11/5
 * @description:
 */
public class No675 {

    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        int row = forest.size();
        int col = forest.get(0).size();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(forest.get(i).get(j) > 1){
                    trees.add(new int[]{i,j});
                }
            }
        }

        Collections.sort(trees, (a,b) -> forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]));
        //排好序之后，就将问题转化为从一个接口到下一个节点的最短
        int cx = 0;
        int cy = 0;
        int ans = 0;
        for(int i = 0; i < trees.size(); i++){
            int steps = bfs(forest, cx, cy, trees.get(i)[0], trees.get(i)[1]);
            if(steps == -1){
                //终止条件，只要有一步无法完成，整个都无法完成
                return -1;
            }
            ans += steps;
            cx = trees.get(i)[0];
            cy = trees.get(i)[1];
        }
        return ans;
    }


    public int bfs(List<List<Integer>> forest, int sx, int sy, int tx, int ty){
        if(sx == tx && sx == ty){
            return 0;
        }
        int row = forest.size();
        int col = forest.get(0).size();
        int step = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[row][col];
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        while(!queue.isEmpty()){
            step++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cell = queue.poll();
                int cx = cell[0], cy = cell[1];
                for(int d = 0; d < 4; d++){
                    int dx = cx + dirs[d][0];
                    int dy = cy + dirs[d][1];
                    if(dx >= 0 && dx < row && dy >= 0 && dy < col){
                        if(!visited[dx][dy] && forest.get(dx).get(dy) > 0){
                            if(dx == tx && dy == ty){
                                return step;
                            }
                            queue.offer(new int[]{dx, dy});
                            visited[dx][dy] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }



}
