package com.linsen.leetcode.slide.window;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author: linsen
 * @date: 2022/10/2
 * @description:
 */
public class No239 {


    /**
     * 优先级队列
     * 堆
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow_1(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //如果值不想等则直接比较大小，如果值想等，则通过下标来比较大小
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        for(int i = 0; i < k; i++){
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for(int i = k; i < n; i++){
            pq.offer(new int[]{nums[i], i});
            while(pq.peek()[1] <= i - k){
                //如果当前最大值出现在滑动窗口的最左边的左侧,则弹出堆
                //滑动窗口的范围是 : i-k.【i-k+1,i】
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }


    public int[] maxSlidingWindow_2(int[] nums, int k){
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i < k; i++){
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for(int i = k; i < n; i++){
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }

            deque.offerLast(i);
            while(deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;

    }





}
