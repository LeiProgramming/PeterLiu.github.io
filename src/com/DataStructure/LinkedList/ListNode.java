package com.DataStructure.LinkedList;

/**
 * @author Peter
 */

@SuppressWarnings("all ")
public class ListNode {
    public ListNode next;
    public int val;

    public ListNode(int x){
        val = x;
    }

    public ListNode(int[] arr){
        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException("Empty");
        }

        this.val = arr[0];
        ListNode cur = this;
        for (int i = 0; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    // 以当前节点为头结点的链表信息字符串
    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while(cur != null){
            s.append(cur.val + "->");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}
