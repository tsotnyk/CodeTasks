package com.j2core.sts.leetcode.com.reverseNodesInK_Group;

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null){
            return head;
        }

        ListNode tempHead = head, tmp = null;
        int count = 0;
        while(head != null && count < k){
            tmp = head;
            head = head.next;
            count++;
        }
        if(head == null && count < k){
            return tempHead;
        }

        tmp.next = null;

        ListNode result = revers(tempHead);

        tempHead.next = reverseKGroup(head, k);

        return result;
    }

    private ListNode revers(ListNode head){

        if(head == null || head.next == null) return head;

        ListNode second = head.next;
        head.next = null;

        ListNode rest = revers(second);
        second.next = head;
        return rest;
    }

}
