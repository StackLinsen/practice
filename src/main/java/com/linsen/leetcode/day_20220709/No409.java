package com.linsen.leetcode.day_20220709;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: linsen
 * @date: 2022/7/9
 * @description:
 */
public class No409 {

    public static void main(String[] args) {

    }



    public int longestPalindrome(String s) {
        int length = s.length();
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < length; i++){
            Character character = s.charAt(i);
            if(map.containsKey(character)){
                map.put(character, map.get(character) + 1);
            }else{
                map.put(character, 1);
            }
        }
        int sum = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer v = entry.getValue();
            if (v % 2 == 0) {
                sum += v;
            }else{
                sum += v - 1;
            }
        }
        if(sum < length){
            return sum + 1;
        }else{
            return sum;
        }
    }

    public int longestPalindrome_2(String s){
        int length = s.length();
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < length; i++){
            Character character = s.charAt(i);
            if(map.containsKey(character)){
                map.put(character, map.get(character) + 1);
            }else{
                map.put(character, 1);
            }
        }
        int sum = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer v = entry.getValue();
            sum += v / 2 * 2;
            if(v % 2 == 1 && sum % 2 == 0){
                sum++;
            }
        }

        return sum;



    }

}
