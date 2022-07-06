package com.linsen.leetcode.day_20220705;

import com.linsen.leetcode.ListNode;

/**
 * @author: 林森
 * @desc: 链表的中间节点
 * @date: 2022/7/5
 */
public class No876 {



    public ListNode middleNode(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
}
