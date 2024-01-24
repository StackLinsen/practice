package com.linsen.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: linsen
 * @date: 2024/1/23
 * @description:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 和题目238很想，都是计算两边的
 * 关键点：对于下标i，下雨后水能到达的最大高度等于下标i两边的最大高度的最小值，下标i处能接的雨水量等于下标i处的水能到达的最大高度减去height[i]*
 */
public class No42 {

    /**
     * 动态规划
     * @param height
     * @return
     */
    public int trap(int[] height){
        int n = height.length;
        if(n == 0){
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i = n - 2; i >= 0; --i){
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;

    }

    /**
     * 单调栈
     * @param height
     * @return
     */
    public int trap_2(int[] height){
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public int trap_3(int[] height){
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(height[left] < height[right]){
                ans += leftMax - height[left];
                ++left;
            }else{
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}
