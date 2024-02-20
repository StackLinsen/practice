package com.linsen.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: linsen
 * @date: 2024/2/20
 * @description:
 */
public class No1 {

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer,Integer> map = new HashMap<>(length);

        for(int i = 0; i < length; i++){
            int leftNum = target - nums[i];
            if(map.containsKey(leftNum)){
                return new int[]{i, map.get(leftNum)};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }


}
