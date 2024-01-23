package com.linsen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: linsen
 * @date: 2024/1/3
 * @description:
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class No169 {

    public static void main(String[] args) {

    }




    public int majorityElement(int[] nums) {
        Integer maxTimes = 1;
        Integer maxNum = 0;
        Map<Integer,Integer> counts = new HashMap<>();
        for(int num : nums){
            if(counts.containsKey(num)){
                int times = counts.get(num) + 1;
                counts.put(num, times);
                if(times > maxNum){
                    maxNum = num;
                    maxTimes = times;
                }
            }else{
                counts.put(num, 1);
                maxTimes = Math.max(maxTimes, 1);
            }
        }
        return maxNum;
    }

}
