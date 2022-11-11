package com.linsen.leetcode.search;


import java.util.*;

/**
 * @author: linsen
 * @date: 2022/11/4
 * @description:
 */
public class No773 {


    public static void main(String[] args) {
        No773 no773 = new No773();
        no773.slidingPuzzle(new int[][]{{1,2,3},{4,0,5}});
    }


    public int slidingPuzzle(int[][] board) {

        int[][] target = new int[][]{{1,2,3},{4,5,0}};
        if(compare(board, target)){
            return 0;
        }


        Queue<int[][]> queue = new LinkedList<>();
        queue.offer(board);
        Set<String> seen = new HashSet<>();
        seen.add(Arrays.toString(board[0]) + Arrays.toString(board[1]));
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[][] cell = queue.poll();
                for(int[][] next : getNext(cell)){
                    if(compare(next, target)){
                        return ++step;
                    }
                    if(!seen.contains(Arrays.toString(next[0]) + Arrays.toString(next[1]))){
                        queue.add(next);
                        seen.add(Arrays.toString(next[0]) + Arrays.toString(next[1]));
                    }

                }
            }
            step++;
        }
        return -1;
    }

    private List<int[][]> getNext(int[][] cell) {
        List<int[][]> list = new ArrayList<>();
        //找到0的位置
        int x = 0, y = 0;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                if(cell[i][j] == 0){
                    x = i;
                    y = j;
                }
            }
        }
        //0和上面的交换

        if(x == 1){
            list.add(changeUp(cell, x, y));
        }

        //0和下面的交换
        if(x == 0){
            list.add(changeDown(cell, x, y));
        }

        //0和左面的交换
        if(y != 0){
            list.add(changeLeft(cell, x, y));
        }

        //0和右面的交换
        if(y != 2){
            list.add(changeRight(cell, x, y));
        }
        return list;
    }


    private int[][] changeRight(int[][] cell, int x, int y) {
        int[][] next = new int[][]{{cell[0][0],cell[0][1],cell[0][2]},{cell[1][0],cell[1][1],cell[1][2]}};
        next[x][y] = next[x][y+1];
        next[x][y+1] = 0;
        return next;
    }

    private int[][] changeLeft(int[][] cell, int x, int y) {
        int[][] next = new int[][]{{cell[0][0],cell[0][1],cell[0][2]},{cell[1][0],cell[1][1],cell[1][2]}};
        next[x][y] = next[x][y-1];
        next[x][y-1] = 0;
        return next;
    }

    private int[][] changeDown(int[][] cell, int x, int y) {
        int[][] next = new int[][]{{cell[0][0],cell[0][1],cell[0][2]},{cell[1][0],cell[1][1],cell[1][2]}};
        next[x][y] = next[x+1][y];
        next[x+1][y] = 0;
        return next;
    }

    private int[][] changeUp(int[][] cell, int x, int y) {
        int[][] next = new int[][]{{cell[0][0],cell[0][1],cell[0][2]},{cell[1][0],cell[1][1],cell[1][2]}};
        next[x][y] = next[x-1][y];
        next[x-1][y] = 0;
        return next;
    }

    private boolean compare(int[][] next, int[][] target) {
        return Arrays.equals(next[0], target[0]) && Arrays.equals(next[1], target[1]);
    }

}
