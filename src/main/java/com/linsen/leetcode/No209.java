package com.linsen.leetcode;

/**
 * @author: linsen
 * @date: 2024/2/2
 * @description:
 */
public class No209 {

    public static void main(String[] args) {
        int target = 11;
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(minSubArrayLen(target, nums));
    }





    public static int minSubArrayLen(int target,int[] nums){

        int length = nums.length;
        int sum = 0;
        int j = 0;
        while(j < length){
            sum += nums[j];
            if(sum >= target){
                break;
            }
            j++;
        }
        if(j == length){
            return 0;
        }
        int i = 0;
        int minSize = j - i;
        while(j < length){
            while(sum - nums[i] >= target && i < j){
                sum = sum - nums[i];
                i++;
            }
            minSize = Math.min(minSize, j - i);
            if(j == length - 1){
                //最右边，i也是最大值，直接返回
                break;
            }
            //j往后走一步，重新计算最的i
            sum += nums[++j];


        }
        return minSize + 1;
    }
}
