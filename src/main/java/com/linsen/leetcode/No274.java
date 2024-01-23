package com.linsen.leetcode;

import java.util.Arrays;

/**
 * @author: linsen
 * @date: 2024/1/18
 * @description:
 */
public class No274 {


    /**
     * 排序
     * @param citations
     * @return
     */
    public int hIndex(int[] citations){
        Arrays.sort(citations);

        int h = 0, i = citations.length - 1;
        while(i >= 0 && citations[i] > h){
            h++;
            i--;
        }
        return h;
    }

    /**
     * 计数排序
     * counter用来记录当前引用次数的论文
     * 然后找到最大值
     * @param citations
     * @return
     */
    public int hIndex2(int[] citations){
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];
        for(int i = 0; i < n; i++){
            if(citations[i] >= n){
                counter[n]++;
            }else{
                counter[citations[i]]++;
            }
        }

        for(int i = n; i >= 0; i--){
            tot += counter[i];
            if(tot >= i){
                return i;
            }
        }
        return 0;
    }

    /**
     * 二分搜索
     * @param citations
     * @return
     */
    public int hIndex3(int[] citations){
        int left = 0, right = citations.length;
        int mid = 0, cnt = 0;
        while(left < right){
            mid = (left + right + 1) >> 1;
            cnt=0;
            for (int i = 0;i<citations.length;i++){
                if(citations[i] >= mid){
                    cnt++;
                }
            }
            if(cnt >= mid){
                left = mid;
            }else {
                right=mid-1;
            }
        }
        return left;
    }





}
