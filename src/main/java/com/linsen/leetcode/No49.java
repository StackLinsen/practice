package com.linsen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: linsen
 * @date: 2024/2/20
 * @description:
 */
public class No49 {


    public List<List<String>> groupAnagrams(String[] strs) {

        int size = strs.length;
        int[][] map = new int[size][26];
        for(int i = 0; i < size; i++){
            String s = strs[i];
            for(Character c : s.toCharArray()){
                map[i][c-'a'] += 1;
            }
        }

        int[] visit = new int[size];
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < size; i++){
            if(visit[i] == 1){
                continue;
            }
            List<String> list = new ArrayList<>();
            visit[i] = 1;
            list.add(strs[i]);
            for(int j = i + 1; j < size; j++){
                if(visit[j] == 1){
                    continue;
                }
                if(isSame(map[j], map[i])){
                    visit[j] = 1;
                    list.add(strs[j]);
                }
            }
            res.add(list);
        }
        return res;
    }

    private boolean isSame(int[] ints, int[] ints1) {

        for(int i = 0; i < 26; i++){
            if(ints[i] != ints1[i]){
                return false;
            }
        }
        return true;
    }
}
