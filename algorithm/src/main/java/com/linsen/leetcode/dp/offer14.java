package com.linsen.leetcode.dp;

/**
 * @author: linsen
 * @date: 2022/11/24
 * @description:
 */
public class offer14 {

    public static void main(String[] args) {
        offer14 offer14 = new offer14();
        System.out.println(offer14.maxProductAfterCutting(4));
    }


    public int maxProductAfterCutting(int length){
        if(length < 2){
            return 0;
        }else if(length == 2){
            return 1;
        }else if(length == 3){
            return 2;
        }

        int[] products = new int[length+1];

        //这里是关键，按照上述，长度为3的绳子最大乘积为1*2=2，但是这个有一个前提是必须减一刀，如果可以不减（作为乘积的一部分），那么可以共享的就是3而不是2
        //同理长度为2的也是2而不是1*1=1
        products[0] = 0;
        products[1] = 0;
        products[2] = 2;
        products[3] = 3;
        int max = 0;
        for(int i = 4; i <= length; i++){
            max = 0;
            for(int j = 1; j <= i/2; j++){
                int product = products[j] * products[i-j];
                if(max < product){
                    max = product;
                }
                products[i] = max;
            }
        }
        max = products[length];
        return max;
    }
}
