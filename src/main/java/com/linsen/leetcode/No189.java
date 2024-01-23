package com.linsen.leetcode;

/**
 * @author: linsen
 * @date: 2024/1/4
 * @description:
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class No189 {


    public static void main(String[] args) {

    }


    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if(k % length == 0){
            return;
        }

        k = k % length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0 , k-1);
        reverse(nums, k, length - 1);
    }


    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }

    }





}
