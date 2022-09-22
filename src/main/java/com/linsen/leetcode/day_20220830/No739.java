package com.linsen.leetcode.day_20220830;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class No739 {

    public static void main(String[] args) {
        No739 no739 = new No739();
        no739.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }


    /**
     * 反向遍历数组
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = length - 1; i >= 0; i--){
            int num = temperatures[i];
            while(!stack.isEmpty() && num >= temperatures[stack.peek()]){
                stack.pop();
            }
            map.put(i, stack.isEmpty() ? 0 : stack.peek() - i);
            stack.push(i);
        }
        for(int i = 0; i < length; i++){
            result[i] = map.get(i);
        }
        return result;
    }


    /**
     * 正向遍历数组
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures_2(int[] temperatures){
        int length = temperatures.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < length; i++){
            int num = temperatures[i];
            if(!stack.isEmpty() && num > temperatures[stack.peek()]){
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
