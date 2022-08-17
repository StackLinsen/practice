package com.linsen.leetcode.day_20220817;

public class No121 {


    public static void main(String[] args) {

    }

    /**
     * 动态规划的思想靠近:一次遍历
     * 第i天的最大收益只需要知道前i天的最低点就可以了（一个变量就可以标识前i天的最低点）
     * dp[i] = min(dp[i - 1], price[i])
     * profit = price[i] - dp[i]
     * 动态规划中只用到了dp[i-1]，所以可以借助变量来替代
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else if(prices[i] - minPrice  > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
