package com.linsen.leetcode.day_20220919;

/**
 * @author: linsen
 * @date: 2022/9/19
 * @description:
 */
public class No769 {

    /**
     * 暴力破解
     * 如何判断【0，1，，n-1】中前k+1个元素是不是【0，1，，k】的时候，只需要检查其中最大的数是不是k就可以了
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int ans = 0, max = 0;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            if(max == i){
                ans++;
            }
        }
        return ans;
    }

}
