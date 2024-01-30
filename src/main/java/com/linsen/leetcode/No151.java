package com.linsen.leetcode;

/**
 * @author: linsen
 * @date: 2024/1/26
 * @description:
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class No151 {

    public static void main(String[] args) {
        String s = "a good    example";
        System.out.println(reverseWords(s));
    }



    public static String reverseWords(String s){
        StringBuffer stringBuffer = new StringBuffer();
        int length = s.length();
        int rightIndex = 0;
        int leftIndex = 0;
        for(int i = length - 1; i >= 0; i--){
            if((s.charAt(i) == ' ' || i == 0) && rightIndex != 0){
                leftIndex = s.charAt(i) == ' ' ? i + 1 : i;
                //将此时的leftIndex到rightIndex复制到字符串中
                stringBuffer.append(s.substring(leftIndex, rightIndex+1)).append(" ");
                leftIndex = 0;
                rightIndex = 0;
            }else if(s.charAt(i) != ' ' && rightIndex == 0){
                rightIndex = i;
                if(i == 0){
                    leftIndex = i;
                    stringBuffer.append(s.substring(leftIndex, rightIndex+1));
                }
            }
        }
        return stringBuffer.toString().trim();
    }
}
