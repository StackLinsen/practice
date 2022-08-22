package com.linsen.leetcode.day_20220822;

public class No1545 {

    public static void main(String[] args) {
        No1545 no1545 = new No1545();
        no1545.findKthBit(2, 2);
    }


    /**
     * 模拟
     * @param n
     * @param k
     * @return
     */
    public char findKthBit(int n, int k){
        StringBuilder sb = new StringBuilder();
        //s1=0;
        sb.append("0");
        while (sb.length() < k) {
            int i = sb.length() - 1;
            //s2 = s1 + "1" + "reverse(invert(Si-1))",其实就相当于从后往前遍历Si-1,并且遇到1，就增加一个0，遇到0就增加一个1
            //继续往下构造，先加“1”
            sb.append("1");
            while (i >= 0) {
                //从后往前遍历，相当于reverse，1->0,0->1相当于invert
                char c = sb.charAt(i--) == '1' ? '0' : '1';
                sb.append(c);
            }
        }
        return sb.charAt(k - 1);
    }



    public char findKthBit_2(int n, int k){
        if(k == 1){
            return '0';
        }
        int mid = 1 << (n-1);
        if(k == mid){
            return '1';
        }else if(k < mid){
            return findKthBit_2(n - 1, k);
        }else {
            k = mid * 2 - k;
            return invert(findKthBit_2(n - 1, k));
        }
    }

    public char invert(char bit){
        return (char) ('0' + '1' - bit);
    }

}
