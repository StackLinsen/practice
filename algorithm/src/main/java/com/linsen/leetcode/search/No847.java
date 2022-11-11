package com.linsen.leetcode.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: linsen
 * @date: 2022/11/4
 * @description:
 */
public class No847 {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<>();

        boolean[][] seen = new boolean[n][1 << n];
        for(int i = 0; i < n; i++){
            queue.offer(new int[]{i, 1<<i, 0});
            seen[i][1 << i] = true;
        }

        int ans = 0;
        while(!queue.isEmpty()){
            int[] tuple = queue.poll();
            int u = tuple[0], mask = tuple[1], dist = tuple[2];
            if(mask == (1 << n) - 1){
                ans = dist;
                break;
            }
            for(int v : graph[u]){
                int maskV = mask | (1 << v);
                if(!seen[v][maskV]){
                    queue.offer(new int[]{v, maskV, dist + 1});
                    seen[v][maskV] = true;
                }
            }
        }
        return ans;
    }



}
