package com.linsen.leetcode;

/**
 * @author: linsen
 * @date: 2024/1/30
 * @description:
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 *
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 */
public class No167 {


    /**
     * 双指针
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target){

        int length = numbers.length;
        int i = 0;
        int j = length - 1;
        while(i < j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                return new int[]{i+1,j+1};
            }else if(sum > target){
                j--;
            }else{
                i++;
            }
        }
        return new int[]{-1,-1};
    }


}
