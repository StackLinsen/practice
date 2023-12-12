package com.linsen.leetcode.dp;

/**
 * @author: linsen
 * @date: 2022/11/27
 * @description: 二进制中1的个数
 */
public class No15 {


    /**
     * 整数不停右移
     * 但是如果num可以为负数时，则会右移到0xFFFFFFFF而陷入死循环
     * @param num
     * @return
     */
    public int numberOf1(int num){
        int count = 0;
        while(num != 0){
            if((num & 1) != 0){
                count++;
            }
            num = num >> 1;
        }
        return count;
    }


    public int numberOf1_2(int num){
        int count = 0;
        int flag = 1;
        for(int i = 0; i < 32; i++){
            if((num & (1 << i)) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 不停的将自己和自己-1进行与运算
     * @param num
     * @return
     */
    public int numberOf_3(int num){
        int count = 0;
        while(num != 0){
            ++count;
            num = (num-1) & num;
        }
        return count;
    }












}
