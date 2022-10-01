package com.linsen.leetcode.day_20221001;

import java.util.Stack;

/**
 * @author: linsen
 * @date: 2022/10/1
 * @description:
 */
public class No1856 {


    public int maxSumMinProduct(int[] nums) {


        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int maxSum = 0;
        for(int i = 0; i < n; i++){

            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                stack.pop();
            }
            stack.push(i);
            int sum = nums[i] * sum(nums, j, k);
            maxSum = Math.max(maxSum, sum);
        }

    }

}
