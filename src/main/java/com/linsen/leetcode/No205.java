package com.linsen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: linsen
 * @date: 2024/2/19
 * @description:
 */
public class No205 {

    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic(s, t));
    }



    public static boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Character> characterMap = new HashMap<>();
        Map<Character, Character> characterMap1 = new HashMap<>();
        int length = s.length();
        for(int i = 0; i < length; i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(characterMap.containsKey(c1)){
                if(!characterMap.get(c1).equals(c2)){
                    return false;
                }
            }else{
                characterMap.put(c1,c2);
            }
            if(characterMap1.containsKey(c2)){
                if(!characterMap1.get(c2).equals(c1)){
                    return false;
                }
            }else{
                characterMap1.put(c2,c1);
            }

        }
        return true;
    }



}
