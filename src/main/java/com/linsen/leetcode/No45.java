package com.linsen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: linsen
 * @date: 2024/1/17
 * @description:
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。*
 */
public class No45 {

    private static List<Integer> step = new ArrayList<>();


    public static void main(String[] args) {
        int[] nums = new int[]{7,0,9,1,2,3,4,1,2,3,2,0,4};
        System.out.println(jump(nums));
        System.out.println(step);

    }


    public static int jump(int[] nums){
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < length - 1; i++){
            if(i + nums[i] > maxPosition){
                maxPosition = i + nums[i];
                step.add(i);
            }
            if(i == end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
