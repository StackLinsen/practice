package com.linsen.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: linsen
 * @date: 2024/2/1
 * @description:
 */
public class No15 {



    public List<List<Integer>> threeSum(int[] nums){
        //输出的顺序和三元组的顺序并不重要，可以先排序
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                if(j > k + 1 && nums[j] == nums[j-1]){
                    j++;
                    continue;
                }
                if(k < nums.length - 1 && nums[k] == nums[k+1]){
                    k--;
                    continue;
                }

                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[j]);
                    integers.add(nums[k]);
                    ans.add(integers);
                    k--;
                }else if(nums[i] + nums[j] + nums[k] > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return ans;
    }


}
