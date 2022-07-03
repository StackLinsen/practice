package com.linsen.leetcode.day_20220701;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 林森
 * @desc: 同构字符串
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，
 * 相同字符只能映射到同一个字符上，字符可以映射到自己本身
 * @date: 2022/7/1
 */
public class No205 {


    public static void main(String[] args) {

        No205 no205 = new No205();
        System.out.print(no205.isIsomorphic_2("abcdefghijklmnopqrstuvwxyzva", "abcdefghijklmnopqrstuvwxyzck"));
    }

    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int length = s.length();
        Map<Character,Character> positMap = new HashMap<>();
        Map<Character,Character> inPositMap = new HashMap<>();
        for(int i = 0; i < length; i++){
            Character c1 = s.charAt(i);
            Character c2 = t.charAt(i);

            if(positMap.containsKey(c1) && !positMap.get(c1).equals(c2)){
                return false;
            }

            if(inPositMap.containsKey(c2) && !inPositMap.get(c2).equals(c1)){
                return false;
            }
            positMap.put(s.charAt(i), t.charAt(i));
            inPositMap.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }


    public boolean isIsomorphic_2(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        if(s.equals(t)){
            return true;
        }
        return reverseNum(s).equals(reverseNum(t));

    }


    public boolean isIsomorphic_3(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            if(s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }


    public String reverseNum(String str){
        String s = "";
        int length = str.length();
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<length;i++){
            Character c = str.charAt(i);
            if(map.containsKey(c)){
                s += "_" + map.get(c);
            }else{
                map.put(c, i);
                s += "" + i;
            }
        }
        return s;
    }

}
