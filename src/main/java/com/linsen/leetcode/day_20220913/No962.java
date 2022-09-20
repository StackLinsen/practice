package com.linsen.leetcode.day_20220913;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: linsen
 * @date: 2022/9/13
 * @description:
 */
public class No962 {


    public static void main(String[] args) {


        No962 no962 = new No962();
        no962.maxWidthRamp_2(new int[]{6,0,8,2,1,5});
    }



    public int maxWidthRamp(int[] nums) {

        int n = nums.length;
        int maxWidth = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            if(stack.isEmpty() || nums[stack.peek()] > nums[i]){
                stack.push(i);
            }
        }

        for (int i = n - 1; i >=0; i--){
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                int pos = stack.pop();
                maxWidth = Math.max(maxWidth, i - pos);
            }
        }
        return maxWidth;
    }


    /**
     *
     * @param nums
     * @return
     */
    public int maxWidthRamp_2(int[] nums){
        int n = nums.length;
        Integer[] B = new Integer[n];
        for (int i = 0; i < n; i++){
            B[i] = i;
        }

        Arrays.sort(B, (i,j) -> ((Integer) nums[i]).compareTo((Integer) nums[j]));

        int ans = 0;
        int m = n;
        for(int i : B){
            ans = Math.max(ans, i - m);
            m = Math.min(m, i);
        }
        return ans;
    }
}
