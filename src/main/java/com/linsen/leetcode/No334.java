package com.linsen.leetcode;

/**
 * @author: linsen
 * @date: 2023/12/18
 * @description:
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 */
public class No334 {


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(increasingTriplet(nums));
    }


    /**
     * 双向遍历
     * @param nums
     * @return
     */
    public static boolean increasingTriplet(int[] nums){
        int n = nums.length;
        if(n < 3){
            return false;
        }
        int[] leftMin = new int[n];
        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++){
            leftMin[i] = Math.min(leftMin[i - 1], nums[i-1]);
        }
        int[] rightMax = new int[n];
        rightMax[n-1] = nums[n-1];
        for(int j = n - 2; j > 0; j--){
            rightMax[j] = Math.max(rightMax[j+1], nums[j+1]);
        }
        boolean isMatch = false;
        for(int i = 1; i < n; i++){
            if(nums[i] > leftMin[i] && nums[i] < rightMax[i]){
                isMatch = true;
                break;
            }
        }
        return isMatch;
    }

    /**
     * 贪心
     * @param nums
     * @return
     */
    public static boolean increasingTriplet_2(int[] nums){
        int n = nums.length;
        if(n < 3){
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for(int i = 1; i < n;  i++){

            int num = nums[i];
            if(num > second){
                return true;
            }else if(num > first){
                second = num;
            }else{
                first = num;
            }
        }
        return false;

    }


}
