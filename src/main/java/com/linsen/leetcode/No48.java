package com.linsen.leetcode;

/**
 * @author: linsen
 * @date: 2024/2/8
 * @description:
 */
public class No48 {


    /**
     * 借助额外数组
     *  @param matrix
     */
    public void rotate(int[][] matrix){
        int n = matrix.length;;
        int[][] matrix_new = new int[n][n];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                matrix_new[j][n-i-1] = matrix[i][j];
            }
        }
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }



    public void rotate_2(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < n/2; ++i){
            for(int j = 0; j < (n+1)/2;++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }

    }
}
