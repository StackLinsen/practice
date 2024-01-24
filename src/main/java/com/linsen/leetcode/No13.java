package com.linsen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: linsen
 * @date: 2024/1/24
 * @description:
 */
public class No13 {
    public static Map<String, Integer> map = new HashMap<String,Integer>(){{
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
        put("IV", 4);
        put("IX", 9);
        put("XL", 40);
        put("XC", 90);
        put("CD", 400);
        put("CM", 900);
    }};

    public static void main(String[] args) {
        System.out.println(romanToInt("IX"));
    }


    public static int romanToInt(String s){
        int length = s.length();
        int sum = 0;
        int i = 0;
        while(i < length){
            String subString1 = s.substring(i, i+1);
            int maxIndex = Math.min(i + 2, length);
            String subString2 = s.substring(i, maxIndex);
            if(map.containsKey(subString2)){
                sum += map.get(subString2);
                i += 2;
            }else {
                sum += map.get(subString1);
                i++;
            }
        }
        return sum;
    }


    public static int romanToInt_2(String s){
        int ans = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            int value = map.get(s.charAt(i));
            if(i < n -1 && value < map.get(s.charAt(i + 1))){
                ans -= value;
            }else{
                ans += value;
            }
        }
        return ans;
    }





}
