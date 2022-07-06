package com.linsen.leetcode;

/**
 * @author: 林森
 * @desc:
 * @date: 2022/7/5
 */

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(){};
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
