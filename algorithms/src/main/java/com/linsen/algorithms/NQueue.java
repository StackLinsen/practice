package com.linsen.algorithms;

/**
 * @author: linsen
 * @date: 2022/2/10
 * @description:
 */
public class NQueue {


    public static int num1(int n){
        if(n < 1){
            return 0;
        }
        int[] record = new int[n];
        return process1(0, record, n);
    }

    public static int num2(int n){
        if (n < 1 || n > 32){
            return 0;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    //record[0。。i-1]的皇后，任何皇后一定都不共行，不共列，不共斜线
    //目前来到了第i行
    //record[0..i-1]表示之前的行，放了的皇后的位置
    //n代表整体一共有多少行
    //返回的是，摆完所有的皇后，合理的摆法有多少种
    public static int process1(int i, int[] record, int n){
        if(i == n){
            return 1;
        }
        int res = 0;
        for(int j = 0; j < n; j++){
            if(isvalid(record, i, j)){
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    //colLim 列的限制，1的位置不能放皇后，0的位置可以
    //leftDiaLim 左斜线的限制，1的位置不能放皇后，0的位置可以
    //rightDiaLim 右斜线的限制，1的位置不能放皇后，0的位置可以
    public static int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim){
        if(colLim == limit){  //base case
            return 1;
        }
        int mostRightOne = 0;
        //所有候选皇后的位置，都在pos上
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while (pos != 0){
            mostRightOne = pos & (~pos + 1); //一个二进制数最右边的1提取出来
            pos = pos - mostRightOne;
            res += process2(limit, colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1, (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }


    public static boolean isvalid(int[] record, int i, int j){
        for(int k = 0; k < i; k++){
            if(j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)){
                return false;
            }
        }
        return true;
    }


}
