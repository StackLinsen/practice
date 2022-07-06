package com.linsen.leetcode.day_20220705;

import com.linsen.leetcode.ListNode;

/**
 * @author: 林森
 * @desc:
 * @date: 2022/7/5
 */
public class No206 {


    public static void main(String[] args) {

    }

    /**
     * 迭代1：重新生成一个链路
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode listNode = null;
        while(head != null){
            ListNode listNode1 = new ListNode(head.val);
            listNode1.next = listNode;
            listNode = listNode1;
            head = head.next;
        }
        return listNode;
    }

    /**
     * 迭代2：原链路反转
     * @param head
     * @return
     */
    public ListNode reverseList_2(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList_3(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList_3(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


}
