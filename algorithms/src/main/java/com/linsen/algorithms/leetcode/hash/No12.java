package com.linsen.algorithms.leetcode.hash;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: linsen
 * @date: 2022/2/23
 * @description: 整数转罗马数字
 */
public class No12 {


    public static void main(String[] args) {
        System.out.println(intToRoman(10000));
    }


    static Map<Integer,String> map = new HashMap<Integer, String>(){{

       put(1000,"M");
       put(900,"CM");
       put(500,"D");
       put(400,"CD");
       put(100,"C");
       put(90,"XC");
       put(50,"L");
       put(40,"XL");
       put(10,"X");
       put(9,"IX");
       put(5,"V");
       put(4,"IV");
       put(1,"I");
    }};




    public static String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer e : map.keySet().stream().sorted(Comparator.comparing(Integer::intValue).reversed()).collect(Collectors.toList())) {
            while(num >= e){
                num -= e;
                stringBuilder.append(map.get(e));
            }
            if(num == 0){
                break;
            }
        }
        return stringBuilder.toString();
    }

}
