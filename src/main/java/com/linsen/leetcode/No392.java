package com.linsen.leetcode;

/**
 * @author: linsen
 * @date: 2024/1/30
 * @description:
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 */
public class No392 {

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbdgc";
        System.out.println(isSubsequence(s, t));
    }

    /**
     * 双重遍历
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t){

        int sLength = s.length();
        int tLength = t.length();
        int sIndex = 0;
        int jIndex = 0;
        while(sIndex < sLength && jIndex < tLength){
            if(s.charAt(sIndex) == t.charAt(jIndex)){
                sIndex++;
                jIndex++;
            }else{
                jIndex++;
            }
        }
        return sIndex == sLength;
    }



    public boolean isSubsequence_2(String s, String t){
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for(int i = 0; i < 26; i++){
            f[m][i] = m;
        }

        for(int i = m - 1; i >= 0; i--){
            for(int j = 0; j < 26; j++){
                if(t.charAt(i) == j + 'a'){
                    f[i][j] = i;
                }else{
                    f[i][j] = f[i+1][j];
                }
            }
        }

        int add = 0;
        for(int i = 0; i < n; i++){
            if(f[add][s.charAt(i) - 'a'] == m){
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }

        return true;
    }


}
