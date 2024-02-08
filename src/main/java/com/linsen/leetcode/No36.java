package com.linsen.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: linsen
 * @date: 2024/2/7
 * @description:
 */
public class No36 {


    public static void main(String[] args) {
        char[][] board = new char[][]{{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));


    }




    public static boolean isValidSudoku(char[][] board){
        //先遍历每一行
        for(int i = 0; i < 9; i++){
            Map<Character,Integer> map = new HashMap<>();
            for(int j = 0; j < 9; j++){
                char character = board[i][j];
                if(!Character.isDigit(character)){
                    continue;
                }
                if(map.containsKey(character)){
                    return false;
                }else{
                    map.put(character, 1);
                }
            }
        }
        //再遍历每一列
        for(int i = 0; i < 9; i++){
            Map<Character,Integer> map = new HashMap<>();
            for(int j = 0; j < 9; j++){
                char character = board[j][i];
                if(!Character.isDigit(character)){
                    continue;
                }
                if(map.containsKey(character)){
                    return false;
                }else{
                    map.put(character, 1);
                }
            }
        }

        //再遍历每一个3*3格
        int colSize = 0;
        int rowSize = 0;
        while(colSize < 3 && rowSize < 3){

            Map<Character,Integer> map = new HashMap<>();
            int index = 0;
            int i = colSize * 3;
            int j = rowSize * 3;
            while(index < 9){
                Character character = board[i][j];
                if(Character.isDigit(character)){
                    if(map.containsKey(character)){
                        return false;
                    }else{
                        map.put(character, 1);
                    }

                }
                if(j == (rowSize + 1) * 3 - 1){
                    i++;
                    j -= 2;
                }else{
                    j++;
                }
                index++;
            }
            if(rowSize != 2){
                rowSize++;
            }else{
                colSize++;
                rowSize = 0;
            }
        }
        return true;
    }

    public boolean isValidSudoku_2(char[][] board){
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j];
                if(c != '.'){
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i/3][j/3][index]++;
                    if(rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i/3][j/3][index] > 1){
                        return false;
                    }
                }
            }
        }
        return true;

    }



}
