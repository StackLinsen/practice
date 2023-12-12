package com.linsen.leetcode.other;

import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: linsen
 * @date: 2023/3/14
 * @description:
 */
public class No1605 {


    public static void main(String[] args) {
        ConcurrentHashMap<Type, String> map = new ConcurrentHashMap<>();


    }


    public int[][] restoreMatrix(int[] rowsSum, int[] colSum){
         int n = rowsSum.length;
         int m = colSum.length;
         int[][] result = new int[n][m];

         int i = 0, j = 0;
         while(i < n && j < m){
             int v = Math.min(rowsSum[i], colSum[j]);
             result[i][j] = v;
             rowsSum[i] -= v;
             colSum[j] -= v;
             if(rowsSum[i] == 0){
                 //这一行已经没有数值可以分配，所以剩下的数都是0
                 ++i;
             }
             if(colSum[j] == 0){
                 //这一列已经没有数值可以分配，所以剩下的数都是0
                 ++j;
             }
         }
         return result;

    }


}
