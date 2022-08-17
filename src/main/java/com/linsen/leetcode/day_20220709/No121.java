package com.linsen.leetcode.day_20220709;

/**
 * @author: linsen
 * @date: 2022/7/9
 * @description:
 */
public class No121 {


    public static void main(String[] args) {

    }


    public int maxProfit(int[] prices) {
        int length = prices.length;
        int abs = 0;
        for(int i = 0; i < length; i++){
            if(i != 0 && prices[i] > prices[i - 1]){
                continue;
            }
            for(int j = i + 1; j < length; j++){
                abs = Math.max(abs, prices[j] - prices[i]);
            }
        }
        return abs;
    }


    public int maxProfit_2(int[] prices){
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        int length = prices.length;
        for(int i = 0; i < length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
