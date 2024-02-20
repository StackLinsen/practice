package com.linsen.leetcode;

/**
 * @author: linsen
 * @date: 2024/2/20
 * @description:
 */
public class No242 {


    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] arr = new int[26];
        for(Character c : s.toCharArray()){
            arr[c-'a'] += 1;
        }

        for(Character c : t.toCharArray()){
            arr[c-'a'] -= 1;
        }

        for(int i : arr){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}
