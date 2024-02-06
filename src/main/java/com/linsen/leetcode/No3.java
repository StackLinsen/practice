package com.linsen.leetcode;

/**
 * @author: linsen
 * @date: 2024/2/4
 * @description:
 */
public class No3 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongesSubstring(s));
    }

    public static int lengthOfLongesSubstring(String s){
        int length = s.length();
        int left = 0;
        int right = 0;
        for (int i = 1; i < length; i++){
            if(s.substring(0, i).contains(s.substring(i, i + 1))){
               right = i - 1;
               break;
            }
        }
        int maxLength = right - left;
        while(right < length - 1){
            right++;
            if(!s.substring(left, right).contains(s.substring(right, right + 1))){
                maxLength = Math.max(maxLength, right - left);
            }else{
                //从左边开始去除重复元素
                while(left < right){
                    if(s.substring(left, left + 1).equals(s.substring(right, right + 1))){
                        //最左边移除的等于右边新加进来的，剩下的就是没有重复的
                        left++;
                        maxLength = Math.max(maxLength, right - left);
                        break;
                    }
                    left++;
                }
            }
        }
        return maxLength + 1;
    }


}
