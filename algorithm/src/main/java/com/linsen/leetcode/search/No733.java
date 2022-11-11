package com.linsen.leetcode.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: linsen
 * @date: 2022/10/13
 * @description:
 */
public class No733 {

    int[] dx = {1,0,0,-1};
    int[] dy = {0,1,-1,0};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        image[sr][sc] = color;
        //涂上方向的
        if(sr - 1 >= 0 && image[sr-1][sc] != color && image[sr-1][sc] == oldColor){
            floodFill(image, sr-1, sc, color);
        }

        if(sr + 1 < image.length && image[sr+1][sc] != color && image[sr+1][sc] == oldColor){
            floodFill(image, sr+1, sc, color);
        }

        if(sc - 1 >= 0 && image[sr][sc-1] != color && image[sr][sc-1] == oldColor){
            floodFill(image, sr, sc-1, color);
        }
        if(sc + 1 < image[0].length && image[sr][sc+1] != color && image[sr][sc+1] == oldColor){
            floodFill(image, sr, sc+1, color);
        }
        return image;
    }


    /**
     * 广度优先搜索
     * @param image
     * @param sr
     * @param sc
     * @param color
     * @return
     */
    public int[][] floodFill_2(int[][] image, int sr, int sc, int color){
        int currColor = image[sr][sc];
        if(currColor == color){
            return image;
        }
        int n = image.length, m = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++){
                int mx = x+dx[i], my = y+dy[i];
                if(mx > 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor){
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = color;
                }
            }
        }
        return image;
    }

    /**
     * 深度优先搜索
     * @param image
     * @param sr
     * @param sc
     * @param color
     * @return
     */
    public int[][] floodFill_3(int[][] image, int sr, int sc, int color){
        int currColor = image[sr][sc];
        if(currColor != color){
            dfs(image, sr, sc, currColor, color);
        }

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int currColor, int color) {
        if(image[sr][sc] == currColor){
            image[sr][sc] = color;
            for(int i = 0; i < 4; i++){
                int mx = sr + dx[i], my = sc + dy[i];
                if(mx > 0 && mx < image.length && my >= 0 && my < image[0].length && image[mx][my] == currColor){
                    dfs(image, mx, my, currColor, color);
                }
            }
        }
    }


}
