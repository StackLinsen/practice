package com.linsen.leetcode;

/**
 * @author: linsen
 * @date: 2024/1/25
 * @description:
 */
public class No14 {

    public static void main(String[] args) {
        String[] strs = new String[]{"a"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs){

        //找到长度最小的字符串
        int length = strs.length;
        int minLength = 200;
        int minIndex = 200;
        for(int i = 0; i < length; i++){
            if(strs[i].length() <= minLength){
                minIndex = i;
                minLength = strs[i].length();
            }
        }
        //遍历数组
        String result = "";
        while(minLength >= 0){
            String commonStr = strs[minIndex].substring(0, minLength);
            boolean isMatch = true;
            for(int i = 0; i < length; i++){
                if(!strs[i].substring(0, minLength).equals(commonStr)){
                    minLength--;
                    isMatch = false;
                    break;
                }
            }
            if(isMatch){
                result = commonStr;
                break;
            }
        }
        return result;
    }

}
