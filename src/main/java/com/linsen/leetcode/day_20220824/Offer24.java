package com.linsen.leetcode.day_20220824;

import com.linsen.leetcode.ListNode;

public class Offer24 {


    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //退出条件，如果空列表或者最后一个节点，则直接返回
        if(head == null || head.next == null){
            return head;
        }
        //只反转了除了首节点后面的节点
        ListNode newHead = reverseList(head.next);
        //处理首节点
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 借助辅助节点从前往后遍历
     * @param head
     * @return
     */
    public ListNode reverseList_2(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null){
            ListNode node = curr.next;
            curr.next = pre;
            pre = curr;
            curr = node;
        }
        return pre;
    }
}
