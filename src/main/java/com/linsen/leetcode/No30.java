package com.linsen.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: linsen
 * @date: 2024/2/5
 * @description:
 */
public class No30 {

    public static void main(String[] args) {
        String s = "aaaaaaaaaa";
        String[] words = new String[]{"aaa"};
        System.out.println(findSubString(s, words));
    }


    public static List<Integer> findSubString(String s, String[] words){
        List<Integer> res = new ArrayList<>();
        int m = words.length, n = words[0].length(), sl = s.length();

        for(int i = 0; i < n; i++){
            //判断临界条件
            if(i + m * n > sl){
                break;
            }
            //将滑动窗口中的单词进行分组
            Map<String,Integer> map = new HashMap<>();
            for(int j = 0; j < m; j++){
                String subString = s.substring(i + j * n, i + (j+1) * n);
                map.put(subString, map.getOrDefault(subString, 0) + 1);
            }
            //遍历数组中的单词，重新标记map
            for(int j = 0; j < m; j++){
                map.put(words[j], map.getOrDefault(words[j], 0) - 1);
                if(map.get(words[j]) == 0){
                    map.remove(words[j]);
                }
            }
            //开始基于i的初始条件进行滑动窗口
            //start的上限是窗口最左边值，有效的start右边可能还有m*n长度字符串，所以start的上限是sl-m*n+1
            for(int start = i; start < sl - m * n + 1; start+=n){
                if(start != i){
                    //滑动，右边增加一个单词
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    //为什么加入还需要判断是否为0呢，放到最后面判断不行吗？（两个word不是同一个单词）
                    //一开始初始状态可能是不符合条件的，word对应的可能是一个负数
                    if(map.get(word) == 0){
                        map.remove(word);
                    }
                    //滑动，左边移除一个单词
                    word = s.substring(start - n, start);
                    map.put(word, map.getOrDefault(word, 0) - 1);
                    if(map.get(word) == 0){
                        map.remove(word);
                    }
                }
                if(map.isEmpty()){
                    res.add(start);
                }
            }
        }
        return res;
    }
}
