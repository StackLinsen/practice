package com.linsen.leetcode.day_20220824;

import com.linsen.leetcode.ListNode;

public class No25 {

    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k){
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while(head != null){
            ListNode tail = pre;
            for(int i = 0; i < k; i++){
                tail = tail.next;
                if(tail == null){
                    return hair.next;
                }
            }

            ListNode next = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail){
        ListNode prev = tail.next;
        ListNode p = head;
        while(prev != tail){
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return new ListNode[]{tail, head};
    }
}
