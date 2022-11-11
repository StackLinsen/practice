package com.linsen.leetcode.slide.window;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: linsen
 * @date: 2022/10/5
 * @description:
 */
public class No862 {


    public static void main(String[] args) {
        No862 no862 = new No862();

        no862.shortestSubArray(new int[]{2,-1,2}, 3);
    }


    public int shortestSubArray(int[] nums, int k) {

        int n = nums.length;
        long[] p = new long[n + 1];
        for(int i = 0; i < n; i++){
            p[i+1] = p[i] + nums[i];
        }

        int ans = n+1;
        //维护一个单调递增的队列
        Deque<Integer> queue = new LinkedList<>();

        for(int y = 0; y < p.length; y++){
            //如果x1 < x2,且p[x2] <= p[x1]，那么opt(y)的值不可能为x1,这是因为x2比x1大，并且如果x1满足了p[x1]<=p[y]-k,那么p[x2]<=p[y]-k一定满足
            while(!queue.isEmpty() && p[y] <= p[queue.peekLast()]){
                queue.removeLast();
            }

            while(!queue.isEmpty() && p[y] >= p[queue.getFirst()] + k){
                ans = Math.min(ans, y - queue.removeFirst());
            }
            queue.addLast(y);
        }

        return ans < n+1 ? ans : -1;





    }
}
