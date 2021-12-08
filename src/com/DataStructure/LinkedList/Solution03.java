package com.DataStructure.LinkedList;

/**
 * @author Peter
 */
@SuppressWarnings("all")

public class Solution03 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
//
//        Method01:
        ListNode res = removeElements(head.next, val);
        if (head.val == val){
            return res;
        }
        else {
            head.next = res;
            return head;
        }

//        head.next = removeElements(head.next, val);
//        return head.val == val ? head.next : head;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,5,3,4,5,6};

        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution03()).removeElements(head, 6);
        System.out.println(res);
    }
}

