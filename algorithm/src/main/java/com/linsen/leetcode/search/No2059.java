package com.linsen.leetcode.search;

import java.util.*;

/**
 * @author: linsen
 * @date: 2022/11/4
 * @description:
 */
public class No2059 {



    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.offer(start);
        seen.add(start);
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int cell = queue.poll();
                for(int next : getNext(cell, nums, seen)){
                    if(next == goal){
                        return ++step;
                    }
                    if(next >= 0 && next <= 1000 && !seen.contains(next)){
                        seen.add(next);
                        queue.offer(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private Set<Integer> getNext(int cell, int[] nums, Set<Integer> seen) {
        Set<Integer> nextList = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int next1 = cell + nums[i];
            int next2 = cell - nums[i];
            int next3 = cell ^ nums[i];
            if(!seen.contains(next1)){
                nextList.add(next1);
            }
            if(!seen.contains(next2)){
                nextList.add(next2);
            }
            if(!seen.contains(next3)){
                nextList.add(next3);
            }
        }
        return nextList;
    }


}
