package com.linsen.leetcode.slide.window;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author: linsen
 * @date: 2022/10/3
 * @description:
 */
public class No1499 {

    public static void main(String[] args) {

//        No1499 no1499 = new No1499();
//
//        no1499.findMaxValueOfEquation_3(new int[][]{{-19,-12},{-13,-18},{-12,18},{-11,8},{-8,2},{-7,12},{-5,16},{-3,9},{1,-7},{5,-4},{6,-20},{10,4},{16,4},{19,-9},{20,19}}, 6);
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        queue.add(new int[]{-5, -13});
        queue.add(new int[]{30, -12});
        queue.add(new int[]{19, -11});

        System.out.println(queue.poll()[0]);
        System.out.println(queue.poll()[0]);
        System.out.println(queue.poll()[0]);
    }




    /**
     * 单调队列
     * @param points
     * @param k
     * @return
     */
    public int findMaxValueOfEquation_2(int[][] points, int k){
        Deque<int[]> q = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;
        for(int[] p : points){
            int x = p[0], y = p[1];
            while(!q.isEmpty() && x - q.peekFirst()[0] > k){
                q.poll();
            }
            if(!q.isEmpty()){
                ans = Math.max(ans, y + x + q.peekFirst()[1] - q.peekFirst()[0]);
            }
            while(!q.isEmpty() && y - x > q.peekLast()[1] - q.peekLast()[0]){
                q.pollLast();
            }
            q.offer(p);
        }
        return ans;

    }

    /**
     *
     * @param points
     * @param k
     * @return
     */
    public int findMaxValueOfEquation_3(int[][] points, int k){
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        int ans = Integer.MIN_VALUE;
        for(int[] p : points){
            int x = p[0], y = p[1];
            while(!q.isEmpty() && x - q.peek()[1] > k){
                q.poll();
            }
            if(!q.isEmpty()){
                ans = Math.max(ans, y + x + q.peek()[0]);
            }
            q.offer(new int[]{y - x, x});
        }
        return ans;
    }
}
