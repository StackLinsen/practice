package com.linsen.leetcode;

/**
 * @author: linsen
 * @date: 2024/1/22
 * @description:
 */
public class No134 {

    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    /**
     * 如果从x最远能达到y，那么从x到y之间的任何一个加油站都无法达到y后面的加油站
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost){
        int n =  gas.length;
        int i = 0;
        while(i < n){
            int sumOfGas = 0,sumOfCost = 0;
            int cnt = 0;
            while(cnt < n){
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];

                if(sumOfCost > sumOfGas){
                    break;
                }
                cnt++;
            }
            if(cnt == n){
                return i;
            }else{
                i = i + cnt + 1;
            }
        }
        return -1;
    }


}
