package com.linsen.leetcode.search;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: linsen
 * @date: 2022/11/11
 * @description:
 */
public class No79 {

    int[][] dirts = {{0,1},{0,-1}{1,0},{-1,0}};


    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        char start = word.charAt(0);
        //确定起始位置
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == start){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int length = word.length();
        if(length == 1){
            if(queue.isEmpty()){
                return false;
            }else{
                return true;
            }
        }
        int d = 1;
        boolean[][] seen = new boolean[m][n];
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for(int i = 0; i < 4; i++){
                int nx = dirts[i][0] + x;
                int ny = dirts[i][1] + y;
                if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                    if()
                    if(board[nx][ny] == word.charAt(d)){
                        if(d == length-1){
                            return true;
                        }
                        d++;

                    }



                }


            }




        }






    }


}
