package com.linsen.leetcode;


import com.sun.tools.javac.util.StringUtils;

/**
 * @author: linsen
 * @date: 2024/1/26
 * @description:
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列
 */
public class No6 {


    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
        System.out.println(convert(s, numRows));
    }


    public static String convert(String s, int numRows){
        //把字符串放在二维数组里
        int length = s.length();
        int col = length;
        String[][] array = new String[numRows][col];


        //按照Z字形排列放到二维数组中
        int rowIndex = 0;
        int colIndex = 0;
        int position = 0;
        for(int i = 0; i < length; i++){
            array[rowIndex][colIndex] = String.valueOf(s.charAt(i));
            if(rowIndex == numRows - 1){
                rowIndex = Math.max(rowIndex - 1, 0);
                colIndex = Math.min(colIndex + 1, col - 1);
                position = 1;
            }else if(rowIndex == 0){
                rowIndex++;
                position = 0;
            }else{
                if(position == 0){
                    rowIndex++;
                }else{
                    rowIndex = Math.max(rowIndex - 1, 0);
                    colIndex = Math.min(colIndex + 1, col - 1);
                }
            }
        }
        //遍历二维数组，取出字符串
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j <= colIndex; j++){
                if(array[i][j] != null && !array[i][j].equals("")){
                    stringBuffer.append(array[i][j]);
                }
            }
        }
        return stringBuffer.toString();
    }
}
