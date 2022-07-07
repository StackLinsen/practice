package com.linsen.leetcode.day_20220707;

import com.linsen.leetcode.ListNode;

/**
 * @author: 林森
 * @desc: 环形链表
 * @date: 2022/7/7
 */
public class No142 {


    public static void main(String[] args) {

    }



    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode slow = head, fast = head;
        while(fast != null){
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            }else{
                return null;
            }

            if(fast == slow){
                ListNode ptr = head;
                while(ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
