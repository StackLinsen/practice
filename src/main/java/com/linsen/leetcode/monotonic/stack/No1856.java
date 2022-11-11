package com.linsen.leetcode.monotonic.stack;

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
        int[] minLeft = new int[n];
        int[] minRight = new int[n];
        for(int i = 0; i < n; i++){

            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                stack.pop();
            }
            minLeft[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = n - 1; i >= 0 ; i--){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            minRight[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        //一次遍历构造左边最小和右边最小
//        for(int i = 0; i < n; i++){
//            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
//                minRight[stack.peek()] = i - 1;
//                stack.pop();
//            }
//            if(!stack.empty()){
//                minLeft[i] = stack.peek() + 1;
//            }
//            stack.push(i);
//        }


        int sum = 0;
        for(int i = 0; i < n; i++){
            sum = Math.max(sum, nums[i] * sum(nums, minLeft[i], minRight[i]));
        }
        return sum;
    }

    private int sum(int[] nums, int j, int k) {

        int sum = 0;
        for(int i = j + 1; i < k; i++){
            sum += nums[i];
        }
        return sum;
    }


}
