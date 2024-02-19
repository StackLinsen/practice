package com.linsen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: linsen
 * @date: 2024/2/19
 * @description:
 */
public class No290 {


    public static void main(String[] args) {

    }


    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        int pLength = pattern.length();
        String[] sArray = s.split(" ");
        int sLength = sArray.length;
        if(pLength != sLength){
            return false;
        }

        for(int i = 0; i < pLength; i++){
            Character c1 = pattern.charAt(i);
            String s1 = sArray[i];
            if((map1.containsKey(c1) && !map1.get(c1).equals(s1)) || (map2.containsKey(s1) && !map2.get(s1).equals(c1))){
                return false;
            }
            map1.put(c1,s1);
            map2.put(s1,c1);
        }
        return true;
    }

}
