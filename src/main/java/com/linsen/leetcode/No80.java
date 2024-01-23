package com.linsen.leetcode;

/**
 * @author: linsen
 * @date: 2023/12/28
 * @description:
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。*
 */
public class No80 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,2,2,2,3,3};
        System.out.println(removeDuplicates(nums));
    }


    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length <= 2){
            return length;
        }
        int i = 0, j = 1;
        int dup = 1;
        while(j <= length - 1){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
                dup = 1;
            }else{
                if(dup == 1){
                    nums[++i] = nums[j];
                }
                dup++;
            }
            j++;
        }
        return i+1;
    }


}
