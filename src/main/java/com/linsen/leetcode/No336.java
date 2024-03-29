package com.linsen.leetcode;

import java.util.*;

/**
 * @author: linsen
 * @date: 2023/12/19
 * @description:
 */
public class No336 {

    private static List<String> wordsRev = new ArrayList<>();
    private static Map<String,Integer> indices = new HashMap<>();


    public static void main(String[] args) {
        String[] words = new String[]{"abc","cba"};
        System.out.println(palindromePairs(words));
    }


    public static List<List<Integer>> palindromePairs(String[] words){
        int n = words.length;
        for(String word : words){
            wordsRev.add(new StringBuffer(word).reverse().toString());
        }
        for(int i = 0; i < n; i++){
            indices.put(wordsRev.get(i), i);
        }


        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String word = words[i];
            int m = words[i].length();
            if(m == 0){
                continue;
            }

            for(int j = 0; j <= m; j++){
                if(isPalindrome(word, j, m-1)){
                    int leftId = findWord(word,0,j-1);
                    if(leftId != -1 && leftId != i){
                        ret.add(Arrays.asList(i, leftId));
                    }
                }

                if(j != 0 && isPalindrome(word, 0 , j-1)){

                    int rightId = findWord(word, j, m-1);
                    if(rightId != -1 && rightId != i){
                        ret.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ret;
    }


    public static boolean isPalindrome(String s, int left, int right){
        int len = right - left + 1;
        for(int i = 0; i < len/2; i++){
            if(s.charAt(left + i) != s.charAt(right - i)){
                return false;
            }
        }
        return true;
    }


    public static int findWord(String s, int left, int right){
        return indices.getOrDefault(s.substring(left, right + 1), -1);
    }
}
