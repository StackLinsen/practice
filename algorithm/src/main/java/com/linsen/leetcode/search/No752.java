package com.linsen.leetcode.search;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 转盘锁
 * @author: linsen
 * @date: 2022/11/3
 * @description:
 */
public class No752 {




    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")){
            return 0;
        }
        Set<String> deadSet = Arrays.stream(deadends).collect(Collectors.toSet());
        if(deadSet.contains(target) || deadSet.contains("0000")){
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> seen = new HashSet<>();
        seen.add("0000");
        int step = 0;
        while(!queue.isEmpty()){
            ++step;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String status = queue.poll();
                for(String nextStatus : getStatus(status)){
                    if(!seen.contains(nextStatus) && !deadSet.contains(nextStatus)){
                        if(nextStatus.equals(target)){
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> getStatus(String status) {

        List<String> ret = new ArrayList<>();
        char[] array = status.toCharArray();
        for(int i = 0; i < 4; i++){
            char num = array[i];
            array[i] = numPrev(num);
            ret.add(new String(array));
            array[i] = numSucc(num);
            ret.add(new String(array));
            array[i] = num;
        }
        return ret;
    }


    public char numPrev(char x){
        return x == '0' ? '9' : (char) (x - 1);
    }

    public char numSucc(char x){
        return x == '9' ? '0' : (char) (x + 1);
    }

}
