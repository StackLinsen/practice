package com.linsen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: linsen
 * @date: 2024/2/19
 * @description:
 */
public class No383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int rLength = ransomNote.length(), mLength = magazine.length();
        if(rLength > mLength){
            return false;
        }
        //先遍历magazine，将数组放到map中
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < mLength; i++){
            Character character = magazine.charAt(i);
            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        //遍历ransomNote，扣减map
        for(int i = 0; i < rLength; i++){
            Character character = ransomNote.charAt(i);
            Integer value = map.getOrDefault(character, 0);
            if(value <= 0){
                return false;
            }
            map.put(character, value - 1);
        }
        return true;
    }

}
