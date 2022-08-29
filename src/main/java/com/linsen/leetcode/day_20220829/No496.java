package com.linsen.leetcode.day_20220829;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class No496 {


    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};
        No496 no496 = new No496();
        no496.nextGreaterElement_2(nums1, nums2);
    }





    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //先遍历nums2
        Map<Integer, Integer> num2Map = new HashMap<>();
        int length2 = nums2.length;
        for(int i = 0; i < length2; i++){
            num2Map.put(nums2[i], i);
        }
        int length1 = nums1.length;
        int[] result = new int[length1];
        for(int i = 0; i < length1; i++){
            int j = num2Map.getOrDefault(nums1[i], -1);
            if (j != -1) {
                int num = -1;
                for (; j < length2; j++) {
                    if (nums2[j] > nums1[i]) {
                        num = nums2[j];
                        break;
                    }
                }
                result[i] = num;
            }else{
                result[i] = j;
            }
        }
        return result;
    }

    /**
     * 大于某个数的第一个元素----单调栈
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement_2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = nums2.length - 1; i >= 0; --i) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }


}
