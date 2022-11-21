package com.linsen.leetcode.search;

import java.util.Arrays;

/**
 * 2305 公平分发饼干
 *
 */
public class No2305 {


    /**
     * 答案和输入的顺序无关
     * 有消耗的概念，集合的划分------->状压DP
     * @param cookies
     * @param k
     * @return
     */
    public int distributeCookies(int[] cookies, int k){


        //f[i][j] 表示消耗了i个子序列(每个孩子修需要一个子序列，这些子序列组成了集合j)
        //这i个子序列的元素和的最大值的最小值为f[i][j]

        //f[i][j] = 枚举j的子集s
        // min max(f[i-1][j^s], sum[s]) for s in j
        int n = cookies.length;
        //这里的j为啥是1<<n呢？
        int[] f = new int[1<<n];
        int[] sum = new int[1<<n];

        for(int i = 0; i < 1<<n; i++){
            for(int j = 0, bit = 1 << i; j < bit; j++){
                sum[bit | j] = sum[j] + cookies[i];
            }
        }
        f = sum.clone();
        for(int i = 1; i < k; i++){
            for(int j = (1<<n) - 1; j > 0; j--){
                for(int s = j; s > 0; s=(s-1) & j){
                    f[j] = Math.min(f[j], Math.max(f[j^s], sum[s]));
                }
            }
        }
        return f[(1<<n)-1];
    }


    /**
     * 答案和输入的顺序无关
     * 有消耗的概念，集合的划分------->状压DP
     * @param cookies
     * @param k
     * @return
     */
    public int distributeCookies_2(int[] cookies, int k){


        //f[i][j] 表示消耗了i个子序列(每个孩子修需要一个子序列，这些子序列组成了集合j)
        //这i个子序列的元素和的最大值的最小值为f[i][j]

        //f[i][j] = 枚举j的子集s
        // min max(f[i-1][j^s], sum[s]) for s in j
        int n = cookies.length;
        //这里的j为啥是1<<n呢？
        int[][] f = new int[k][1<<n];
        int[] sum = new int[1<<n];

        for(int i = 0; i < n; i++){
            for(int j = 0, bit = 1 << i; j < bit; j++){
                sum[bit | j] = sum[j] + cookies[i];
            }
        }
        f[0] = sum.clone();
        for(int i = 1; i < k; i++){
            for(int j = (1<<n) - 1; j > 0; j--){
                f[i][j] = Integer.MAX_VALUE;
                for(int s = j; s > 0; s=(s-1) & j){
                    f[i][j] = Math.min(f[i][j], Math.max(f[i-1][j^s], sum[s]));
                }
            }
        }
        return f[k-1][(1<<n)-1];
    }
}
