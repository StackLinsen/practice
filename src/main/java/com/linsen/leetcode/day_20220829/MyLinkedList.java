package com.linsen.leetcode.day_20220829;

import com.linsen.leetcode.ListNode;

/**
 * NO707 设计链表
 * https://leetcode.cn/problems/design-linked-list/solution/she-ji-lian-biao-by-leetcode/
 */
public class MyLinkedList {


    int size;
    ListNode head;

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.get(0);
        myLinkedList.addAtTail(7);
        myLinkedList.get(1);
        myLinkedList.addAtHead(9);
        myLinkedList.addAtTail(8);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtHead(0);
        System.out.println(myLinkedList.get(5));
        myLinkedList.addAtHead(0);
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.get(5));
        System.out.println(myLinkedList);
    }



    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);

    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode curr = head;

        for(int i = 0; i < index + 1; i++){
            curr = curr.next;
        }
        return curr.val;

    }

    public void addAtHead(int val) {
        size++;
        ListNode node = new ListNode(val);
        node.next = head.next;
        head.next = node;
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index < 0){
            index = 0;
        }
        ++size;
        ListNode pred = head;
        for(int i = 0; i < index; i++){
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if(index > size){
            return;
        }
        size--;
        ListNode toDelPre = head;
        for(int i = 0; i < index; i++){
            toDelPre = toDelPre.next;
        }
        ListNode toDel = toDelPre.next;
        toDelPre.next = toDelPre.next.next;
        toDel.next = null;
    }

}
