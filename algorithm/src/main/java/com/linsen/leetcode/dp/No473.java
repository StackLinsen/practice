package com.linsen.leetcode.dp;

import java.util.Arrays;

/**
 * @author: linsen
 * @date: 2022/11/26
 * @description: 火柴拼正方形
 */
public class No473 {

    public static void main(String[] args) {
        No473 no473 = new No473();
        no473.makeSquare_2(new int[]{1, 1, 2, 2, 2});
    }


    /**
     * 动态规划
     * 时间复杂度：O(n*2^n)
     * 空间复杂度：O(2^n)
     *
     * @param matchsticks
     * @return
     */
    public boolean makeSquare(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }

        int len = totalLen / 4, n = matchsticks.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int s = 1; s < (1 << n); s++) {
            for (int k = 0; k < n; k++) {
                //这里是保证s的第k位=1，也就是当前s状态放了第k根火柴
                if ((s & (1 << k)) == 0) {
                    continue;
                }
                //这个是在s放了第k根火柴的情况下，把第k根火柴拿掉(1左移k位表示选中第k根火柴，取反则表示把第k根火柴拿掉)
                int s1 = s & ~(1 << k);
                if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len) {
                    dp[s] = (dp[s1] + matchsticks[k]) % len;
                    break;
                }
            }
        }
        return dp[(1 << n) - 1] == 0;
    }


    /**
     * 回溯
     * 时间复杂度：0(4^n)
     * 空间复杂度：0(n)
     * @param matchsticks
     * @return
     */
    public boolean makeSquare_2(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if(totalLen % 4 != 0){
            return false;
        }
        //排序从小到大
        Arrays.sort(matchsticks);
        //首尾交换实现从大到小排序
        for(int i = 0, j = matchsticks.length - 1; i < j; i++,j--){
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        int[] edges = new int[4];
        return dfs(0, matchsticks, edges, totalLen / 4);
    }

    /**
     * 放置第index根火柴，不管放入哪条边，只要能放进去使当前边的长度小于等于len即可，直到将所有火柴都放进去就表示能拼成正方形
     * @param index
     * @param matchsticks
     * @param edges
     * @param len
     * @return
     */
    public boolean dfs(int index, int[] matchsticks, int[] edges, int len){
        if(index == matchsticks.length){
            return true;
        }
        // TODO: 2022/11/27 i在什么条件下会开始自增
        for(int i = 0; i < edges.length; i++){
            //每一趟循环代表放一条边
            edges[i] += matchsticks[index];
            if(edges[i] <= len && dfs(index + 1, matchsticks, edges, len)){
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }

}
