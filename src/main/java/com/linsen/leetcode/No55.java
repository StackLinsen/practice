package com.linsen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: linsen
 * @date: 2024/1/16
 * @description:
 */
public class No55 {

    private static Map<Integer,Boolean> resultMap = new HashMap<>();




    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    /**
     * 贪心
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums){
        int n = nums.length;
        int rightMost = 0;
        for(int i = 0; i < n; i++){
            if(i <= rightMost){
                rightMost = Math.max(rightMost, i + nums[i]);
                if(rightMost >= n -1){
                    return true;
                }
            }
        }
        return false;
    }



    private static boolean canJump(int[] nums, int k){
        if(resultMap.containsKey(k)){
            return resultMap.get(k);
        }
        //找到
        if(k == nums.length - 1){
            resultMap.put(k, true);
            return true;
        }
        int value = nums[k];
        if(value == 0){
            resultMap.put(k, false);
            return false;
        }
        boolean result = false;
        for(int i = 1; i <= value; i++){
            result = result || canJump(nums, k + i);
        }
        if(result){
            resultMap.put(k,result);
        }
        return result;
    }
}
