package com.linsen.leetcode;

/**
 * @author: linsen
 * @date: 2024/1/29
 * @description:
 */
public class No125 {


    public static void main(String[] args) {

        String s = "race a car";

        System.out.println(isPalindrome(s));

    }



    public static boolean isPalindrome(String s){
        int length = s.length();
        int i = 0;
        int j = length - 1;
        boolean isPalindrome = true;
        while(i < j){
            char left = s.charAt(i);
            if(!Character.isLetterOrDigit(left)){
                i++;
                continue;
            }
            char right = s.charAt(j);
            if(!Character.isLetterOrDigit(right)){
                j--;
                continue;
            }
            if(Character.toLowerCase(left) != Character.toLowerCase(right)){
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }
        return isPalindrome;
    }
}
