package com.linsen.leetcode.slide.window;

/**
 * @author: linsen
 * @date: 2023/3/9
 * @description:
 */
public class No2379 {


    public static void main(String[] args) {



    }



    public int minimumRecolors(String blocks, int k){
        int count = 0;
        for(int i = 0; i < k; i++){
            if(blocks.charAt(i) == 'W'){
                count++;
            }
        }
        if(count == 0){
            return 0;
        }
        int length = blocks.length();
        if(k == length){
            return count;
        }
        int i = 0, j = k - 1;
        int min = count;
        while(j < length - 1){
            if(blocks.charAt(i) == 'W'){
                count--;
            }
            if(blocks.charAt(j + 1) == 'W'){
                count++;
            }
            min = Math.min(min, count);
            i++;
            j++;
        }
        return min;
    }


}
