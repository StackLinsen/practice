package com.linsen.leetcode.day_20220702;

/**
 * @author: linsen
 * @date: 2022/7/3
 * @description: 合并两个升序的链表成新的升序的链表
 */

public class No21 {


    public static void main(String[] args) {

    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        while(list1 != null && list2 != null){

            ListNode listNode1 = new ListNode();
            if(list1.val <= list2.val){
                listNode1.val = list1.val;
                list1 = list1.next;
            }else{
                listNode1.val = list2.val;
                list2 = list2.next;
            }
            listNode.next = listNode1;
            listNode = listNode.next;
        }
        if(list1 != null){
            listNode.next = list1;
        }
        if(list2 != null){
            listNode.next = list2;
        }
        return head.next;
    }



     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
