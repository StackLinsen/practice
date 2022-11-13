package com.linsen.leetcode.search;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: linsen
 * @date: 2022/11/13
 * @description: Matchsticks to square
 */
public class No473 {


    public static void main(String[] args) {
        int[] matchsticks = {5,5,5,5,4,4,4,4,3,3,3,3};
        No473 no473 = new No473();
        System.out.println(no473.makeSquare(matchsticks));
    }


    public boolean makeSquare(int[] matchsticks) {

        int sum = 0;
        int length = matchsticks.length;
        for(int i : matchsticks){
            sum += i;
        }
        if(sum % 4 != 0 || length < 4){
            return false;
        }
        //如果可以组成正方形，则边长是固定的，确定边长是多少
        int sing = sum / 4;
        //组合成目标答案
        int answer = 0;
        boolean[] seen = new boolean[length];
        //不一定是两根拼接，可能是多根拼接，所以采用深度搜索，目标和是sing，用seen标记已经拼接过的
        for(int i = 0; i < length; i++){
            if(matchsticks[i] > sing){
                return false;
            }
            //如何保证深度优先搜索找出"合适"的答案，而不是遇到不合适的答案就直接返回
            boolean result = dfs(0, sing, matchsticks, seen);
            if(!result){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, int sing, int[] matchsticks, boolean[] seen) {
        if(!seen[i] && matchsticks[i] == sing){
            seen[i] = true;
            return true;
        }
        seen[i] = true;
        for(int j =i; j < matchsticks.length; j++){
            boolean result = dfs(j, sing-matchsticks[i], matchsticks, seen);
            if(result){
                return true;
            }
        }
        seen[i] = false;
        return false;
    }


}
