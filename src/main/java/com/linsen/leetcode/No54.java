package com.linsen.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: linsen
 * @date: 2024/2/7
 * @description:
 */
public class No54 {

    private static int[][] steps = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }



    public static List<Integer> spiralOrder(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        int[][] tag = new int[m][n];

        int size = m * n;
        List<Integer> res = new ArrayList<>();
        int index = 0;
        int step = 0;
        int i = 0, j = 0;
        while(index < size){
            if(i < m && j < n && tag[i][j] != 1){
                res.add(matrix[i][j]);
                tag[i][j] = 1;
                if(index == size - 1){
                    break;
                }
                //检查是否要调整方向
                int[] nextIndex = getNext(i,j,step);
                int nextI = nextIndex[0];
                int nextJ = nextIndex[1];
                if(nextI < 0 || nextI == m || nextJ < 0 || nextJ == n || tag[nextI][nextJ] == 1){
                    //调整方向
                    step = (step + 1) % 4;
                    nextIndex = getNext(i, j, step);
                    nextI = nextIndex[0];
                    nextJ = nextIndex[1];
                }
                i = nextI;
                j = nextJ;
            }
            index++;
        }
        return res;


    }

    private static int[] getNext(int i, int j, int step) {
        int[] res = new int[2];
        int[] stepIndex = steps[step];
        res[0] = i+stepIndex[0];
        res[1] = j+stepIndex[1];
        return res;
    }


}
