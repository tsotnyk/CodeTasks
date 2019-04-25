package com.j2core.sts.leetcode.com.insertionSortList;

public class Solution {

    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode newHead = head.next;
        head.next = null;

        while (newHead != null){
            ListNode newTmp = newHead;
            newHead = newHead.next;
            newTmp.next = null;
            head = sortList(head, newTmp);
        }

        return head;
    }

    private ListNode sortList(ListNode head, ListNode tmp){

        if (head.val > tmp.val){
            tmp.next = head;
            return tmp;
        }

        ListNode tmpHead = head;
        while (tmpHead.next != null){
            if (tmpHead.next.val > tmp.val){
                tmp.next = tmpHead.next;
                tmpHead.next = tmp;
                return head;
            }
            tmpHead = tmpHead.next;
        }

        tmpHead.next = tmp;
        return head;
    }
}
