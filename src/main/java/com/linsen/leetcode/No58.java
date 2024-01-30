package com.linsen.leetcode;

/**
 * @author: linsen
 * @date: 2024/1/25
 * @description:
 */
public class No58 {

    public int lengthOfLastWord(String s){

        String[] sArray = s.split(" ");
        int length = sArray.length;
        int lastLength = 0;
        for(int i = length - 1; i >= 0; i--){
            if(sArray[i].trim().length() != 0){
                lastLength = s.length();
                break;
            }
        }
        return lastLength;
    }


    public int lengthOfLastWord_2(String s){
        int index = s.length() - 1;
        while(s.charAt(index) == ' '){
            index--;
        }
        int wordLength = 0;
        while(index >= 0 && s.charAt(index) != ' '){
            wordLength++;
            index--;
        }
        return wordLength;
    }
}
