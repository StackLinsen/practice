package com.linsen.leetcode;

/**
 * @author: linsen
 * @date: 2023/12/19
 * @description:
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class No27 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1};
        System.out.println(removeElement(nums, 1));
    }





    public static int removeElement(int[] nums, int val){
        int length = nums.length;
        int i = 0, j = length - 1;
        int returnLength = 0;
        while(i <= j){
            if(nums[j] == val){
                j--;
                returnLength++;
            }else if(nums[i] == val){
                nums[i] = nums[j];
                nums[j] = val;
                j--;
                returnLength++;
            }else{
                i++;
            }
        }
        return length - returnLength;
    }
}
