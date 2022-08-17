package com.linsen.leetcode.day_20220721;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: 林森
 * @desc: 快乐数
 * 快乐数定义：每个位置上的数字平方和相加，一直累加得到1，能得到1就为快乐数
 * @date: 2022/7/21
 */
public class No202 {

    public static void main(String[] args) {


    }




    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while(n != 1 && !seen.contains(n)){
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }


    public boolean isHappy_2(int n){
        int slow = n;
        int fast = getNext(n);

        while(fast != 1 && slow != fast){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;

    }

    private int getNext(int n) {
        int totalSum = 0;
        while(n > 0){
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }


}
