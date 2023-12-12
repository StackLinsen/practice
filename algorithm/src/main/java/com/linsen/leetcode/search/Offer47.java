package com.linsen.leetcode.search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: linsen
 * @date: 2023/3/8
 * @description: 礼物的最大价值
 * https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class Offer47 {


    int[][] dirts = new int[][]{{0, 1}, {1, 0}};

    public static void main(String[] args) {

        Offer47 offer47 = new Offer47();
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(offer47.maxValue_2(grid));


    }

    /**
     * 动态规划
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //下面的代码其实就是取f[i-1][j]和f[i][j-1]中的较大值，因为f[i][j]初始化时都是0
                if (i > 0) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                }
                if (j > 0) {
                    f[i][j] = Math.max(f[i][j], f[i][j - 1]);
                }

                f[i][j] += grid[i][j];
            }
        }
        return f[m - 1][n - 1];


    }

    /**
     * 广度优先搜索
     *
     * @param grid
     * @return
     */
    public int maxValue_2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 2; i++) {
                int[] dirt = dirts[i];
                int dx = dirt[0] + x, dy = dirt[1] + y;
                if (dx < m && dy < n) {
                    if(f[dx][dy] < f[x][y] + grid[dx][dy]){
                        queue.add(new int[]{dx,dy});
                        f[dx][dy] = f[x][y] + grid[dx][dy];
                    }

                }
            }
        }
        return f[m-1][n-1];
    }
}
