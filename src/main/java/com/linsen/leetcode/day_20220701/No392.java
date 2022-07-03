package com.linsen.leetcode.day_20220701;

/**
 * @author: 林森
 * @desc: 判断子序列
 * @date: 2022/7/1
 */
public class No392 {

    public static void main(String[] args) {

    }


    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        while(i < m && j < n){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == m;
    }

    /**
     * 动态规划
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence_2(String s, String t){
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a') {
                    f[i][j] = i;
                } else{
                    f[i][j] = f[i + 1][j];
                }
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}
