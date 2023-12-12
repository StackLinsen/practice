package com.linsen.leetcode.other;

import java.util.Arrays;

/**
 * @author: linsen
 * @date: 2023/3/13
 * @description:
 */
public class No2383 {


    public static void main(String[] args) {

    }


    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience){

        int length = energy.length;
        int totalEnergy = Arrays.stream(energy).sum();

        int totalTrans = 0;
        int transEnergy =  totalEnergy >= initialEnergy ? totalEnergy - initialEnergy + 1 : 0;
        totalTrans += transEnergy;

        //依次遇上对上
        int currentEnergy = initialEnergy;
        int currentExperience = initialExperience;
        int i = 0;
        while(i < length){
            //精力只会越来越少，所以就提前算好
            if(currentExperience > experience[i]){
                currentExperience = currentExperience + experience[i];
                i++;
            }else{
                totalTrans += experience[i] - currentExperience + 1;
                currentExperience += experience[i] - currentExperience + 1;
            }
        }
        return totalTrans;
    }
}
