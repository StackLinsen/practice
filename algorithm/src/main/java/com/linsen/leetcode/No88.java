package com.linsen.leetcode;

import java.util.Arrays;

/**
 * @author: linsen
 * @date: 2023/12/11
 * @description:
 */
public class No88 {


    public static void main(String[] args) {

        int[] nums1 = new int[]{2,0};
        int m = 1;
        int[] nums2 = new int[]{1};
        int n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(nums1);

    }



    public static void merge(int[] nums1, int m, int[] nums2, int n){
        if(m == 0){
            for(int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        if(n == 0){
            return;
        }

        int i = m - 1, j = n - 1;
        int index = m + n - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] <= nums2[j]){
                nums1[index] = nums2[j];
                j--;
            }else{
                nums1[index] = nums1[i];
                i--;
            }
            index--;
        }

        while(j >= 0){
            nums1[index--] = nums2[j--];
        }
    }
}
