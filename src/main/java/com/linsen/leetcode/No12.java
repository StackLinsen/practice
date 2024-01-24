package com.linsen.leetcode;

/**
 * @author: linsen
 * @date: 2024/1/24
 * @description:
 */
public class No12 {

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    /**
     * 将数字转换成罗马数字
     * @param num
     * @return
     */
    public String intToRoman(int num){

        StringBuffer roman = new StringBuffer();
        for(int i = 0; i < values.length; ++i){
            int value = values[i];
            String symbol = symbols[i];
            while(num >= value){
                num -= value;
                roman.append(symbol);
            }
            if(num == 0){
                break;
            }
        }
        return roman.toString();
    }
}
