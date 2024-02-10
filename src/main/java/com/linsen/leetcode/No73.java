package com.linsen.leetcode;

/**
 * @author: linsen
 * @date: 2024/2/8
 * @description:
 */
public class No73 {

    public void setZeroes(int[][] matrix){
        int col = matrix.length;
        int row = matrix[0].length;
        int[] colChanged = new int[col];
        int[] rowChanged = new int[row];
        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                if(matrix[i][j] == 0){
                    colChanged[i] = 1;
                    rowChanged[j] = 1;
                }
            }
        }

        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                if(matrix[i][j] != 0 && (colChanged[i] == 1 || rowChanged[j] == 1)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
