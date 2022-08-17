package com.linsen.leetcode.day_20220817;

import com.linsen.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class No382 {

    ListNode head;
    Random random;

    List<Integer> list;


    public No382(ListNode head) {
        this.head = head;
        random = new Random();

        list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
    }


    public int getRandom_1(){
        return list.get(random.nextInt(list.size()));
    }


    /**
     * 水塘抽样
     * @return
     */
    public int getRandom() {
        int i = 1, ans = 0;
        for(ListNode node = head; node != null; node = node.next){
            if(random.nextInt(i) == 0){
                ans = node.val;
            }
            i++;
        }
        return ans;
    }
}
