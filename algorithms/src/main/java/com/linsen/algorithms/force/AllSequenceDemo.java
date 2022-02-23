package com.linsen.algorithms.force;

import java.util.List;

/**
 * @author: linsen
 * @date: 2022/2/13
 * @description:
 */
public class AllSequenceDemo {

    public static void process(char[] str, int i, List<Character> res){
        if(i == str.length){
            printList(res);
            return;
        }
        List<Character> resKeep = copyList(res);
        resKeep.add(str[i]);
        process(str, i+1, resKeep);
        List<Character> resNoInclude = copyList(res);
        process(str, i+1, resNoInclude);
    }

    public static void process(char[] str, int i){
        if(i == str.length){
            System.out.println(String.valueOf(str));
            return;
        }
        process(str, i + 1);
        char tmp = str[i];
        str[i] = 0;
        process(str, i + 1);
        str[i] = tmp;
    }

    public static void printList(List<Character> res){

    }

    public static List<Character> copyList(List<Character> list){
        return null;
    }
}
