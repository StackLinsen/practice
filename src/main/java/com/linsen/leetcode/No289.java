package com.linsen.leetcode;

/**
 * @author: linsen
 * @date: 2024/2/8
 * @description:
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 */
public class No289 {


    public static void main(String[] args) {
        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);

    }


    public static void gameOfLife(int[][] board) {

        int col = board.length, row = board[0].length;
        int[][] needChanged = new int[col][row];

        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){

                boolean result = checkNeedChange(i, j, board);
                if(result){
                    needChanged[i][j] = 1;
                }
            }
        }

        //遍历needChanged数组
        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                if(needChanged[i][j] == 1){
                    board[i][j] = board[i][j] == 0 ? 1 : 0;
                }
            }
        }
    }

    private static boolean checkNeedChange(int i, int j, int[][] board) {
        int liveCount = 0;
        int col = board.length, row = board[0].length;
        for(int m = -1; m < 2; m++){
            for(int n = -1; n < 2; n++){
                if(m == 0 && n == 0){
                    continue;
                }
                if(i+m < 0 || i+m > (col - 1) || j + n < 0 || j + n > (row - 1)){
                    continue;
                }
                if(board[i+m][j+n] == 1){
                    liveCount++;
                }
            }
        }
        if(board[i][j] == 1){
            //活细胞
            return liveCount < 2 || liveCount > 3;
        }else{
            //死细胞
            return liveCount == 3;
        }
    }


}
