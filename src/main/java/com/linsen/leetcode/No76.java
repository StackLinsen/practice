package com.linsen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: linsen
 * @date: 2024/2/6
 * @description:
 */
public class No76 {


    public static void main(String[] args) {
        String s = "ab";
        String t = "a";
        System.out.println(minWindow(s, t));
    }




    public static String minWindow(String s, String t){
        int sl = s.length(), tl = t.length();
        Map<Character, Integer> map = new HashMap<>();
        //遍历t字符串,构造map
        for(int i = 0; i < tl; i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        //满足的元素个数，当size=tl时，表示此时的窗口是满足条件的结果之一
        int size = 0;

        int i = 0;
        int j = 0;
        String res = "";
        int resLength = sl + 1;
        while(j < sl){
            //先j滑动，找到满足条件的一个值
            while(size < map.size() && j < sl){
                Character character = s.charAt(j);
                if(map.containsKey(character)){
                    map.put(character, map.get(character) + 1);
                    if(map.get(character) == 0){
                        size++;
                    }
                    //为了避免当已经满足条件时j++，直接跳出循环不进行j++
                    if(size == map.size()){
                        if(resLength > (j-i+1)){
                            resLength = j-i+1;
                            res = s.substring(i, j+1);
                        }
                        continue;
                    }
                }
                j++;
            }
            if(size != map.size()){
                break;
            }

            while(i <= j){
                Character character = s.charAt(i);
                if(!map.containsKey(character)){
                    i++;
                }else{
                    map.put(character, map.get(character) - 1);
                    if(map.get(character) >= 0){
                        i++;
                    }else{
                        if(resLength > (j-i+1)){
                            resLength = j-i+1;
                            res = s.substring(i, j+1);
                        }
                        size--;
                        i++;
                        j++;
                        break;
                    }
                }
            }
        }
        return res;

    }
}
