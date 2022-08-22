package com.linsen.leetcode.day_20220822;

/**
 * 分发糖果
 * https://leetcode.cn/problems/candy/
 */
public class No135 {


    /**
     * 左右两次遍历
     * 对于递增的序列左规则和右规则值不一样，所以要既满足左规则右满足右规则，就得是两次不同方向遍历的最大值
     * @param ratings
     * @return
     */
    public int candy(int[] ratings){
        int n = ratings.length;

        int[] left = new int[n];
        for(int i = 0; i < n; i++){
            if(i > 0 && ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        for(int i = n - 1; i >= 0; i--){
            if(i < n - 1 && ratings[i] > ratings[i + 1]){
                right++;
            }else{
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }


    /**
     *
     * @param ratings
     * @return
     */
    public int candy_2(int[] ratings){
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for(int i = 1; i < n; i++){
            if(ratings[i] >= ratings[i - 1]){
                dec = 0;
                pre = ratings[i] == ratings[i -1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            }else{
                dec++;
                if(dec == inc){
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }




}
