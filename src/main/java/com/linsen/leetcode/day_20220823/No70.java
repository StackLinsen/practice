package com.linsen.leetcode.day_20220823;

import java.util.HashMap;
import java.util.Map;

public class No70 {
    Map<Integer, Integer> map = new HashMap<>();


    /**
     * 递归
     * @param n
     * @return
     */
    public int climbStairs(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        int sum1 = climbStairs(n - 1);
        map.put(n - 1, sum1);
        int sum2 = climbStairs(n - 2);
        map.put(n - 2, sum1);
        return sum1 + sum2;
    }

    /**
     * 递归改成动态规划
     * @param n
     * @return
     */
    public int climbStairs_2(int n){
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 滚动数组
     * @param n
     * @return
     */
    public int climbStairs_3(int n){
        int p = 0, q = 0, r = 1;

        for(int i = 1; i < n; i++){
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }


}
