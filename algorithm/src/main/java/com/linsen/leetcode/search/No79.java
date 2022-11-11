package com.linsen.leetcode.search;


import java.util.*;

/**
 * @author: linsen
 * @date: 2022/11/11
 * @description:
 */
public class No79 {


    public static void main(String[] args) {
        No79 no79 = new No79();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "SEE";
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCB";
        System.out.println(no79.exist(board, word));
    }

    int[][] dirts = {{0, 1}, {0, -1},{1, 0}, {-1, 0}};


    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        char start = word.charAt(0);
        //确定起始位置
        List<int[]> startList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == start) {
                    startList.add(new int[]{i, j});
                }
            }
        }
//        if(word.length() == 1){
//            if(startList.size() > 0){
//                return true;
//            }else{
//                return false;
//            }
//        }
        for(int[] cell : startList){
            boolean[][] seen = new boolean[m][n];
            boolean result = dfs(cell[0], cell[1], board, word, 0, seen);
            if(result){
                return true;
            }
        }
        return false;
//        for (int[] cell : startList) {
//            boolean result = bfs(cell[0], cell[1], board, word);
//            if (result) {
//                return result;
//            }
//        }
//        return false;
    }

    /**
     * 深度优先搜索
     * @param x
     * @param y
     * @param board
     * @param word
     * @return
     */
    private boolean dfs(int x, int y, char[][] board, String word, int index, boolean[][] seen) {
        if(board[x][y] != word.charAt(index)){
            return false;
        }
        if(index == word.length() - 1){
            return true;
        }
        seen[x][y] = true;
        int m = board.length, n = board[0].length;
        for(int d = 0; d < 4; d++){
            int nx = dirts[d][0] + x, ny = dirts[d][1] + y;
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && !seen[nx][ny]){
                boolean result = dfs(nx, ny, board, word, index+1, seen);
                if(result){
                    return true;
                }else{
                    seen[nx][ny] = false;
                }
            }
        }
        return false;
    }


    /**
     * 宽度优先搜索
     * @param x
     * @param y
     * @param board
     * @param word
     * @return
     */
    private boolean bfs(int x, int y, char[][] board, String word) {
        int m = board.length, n = board[0].length;
        //管理的太宽，应该是在某一条链路上不能重复出现，但是在可能的不同链路上是允许重复出现的，所以这里有问题
        boolean[][] seen = new boolean[m][n];
        seen[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        int step = 1;
        char c = word.charAt(step);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int a1 = cell[0], a2 = cell[1];
                for (int d = 0; d < 4; d++) {
                    int nx = dirts[d][0] + a1;
                    int ny = dirts[d][1] + a2;
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        if (board[nx][ny] == c && !seen[nx][ny]) {
                            if (step == word.length() - 1) {
                                //已经达到最后一个字母并且相等
                                return true;
                            }
                            seen[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
            step++;
            if (step >= word.length()) {
                return false;
            }
            c = word.charAt(step);
        }
        return false;
    }


}
