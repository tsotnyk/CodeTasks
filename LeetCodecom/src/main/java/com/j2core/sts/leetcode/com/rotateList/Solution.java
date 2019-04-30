package com.j2core.sts.leetcode.com.rotateList;

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0){
            return head;
        }
        int size = 1;
        ListNode tmp = head;

        while (tmp.next != null){
            size++;
            tmp = tmp.next;
        }
        int delta = k%size;

        if (delta == 0){
            return head;
        }

        int newHeadIndex = size - k%size;

        if (newHeadIndex == 0){
            return head;
        }

        tmp = head;
        ListNode newHead = null;
        int tmpIndex = 1;
        while (tmpIndex++ < newHeadIndex){
            tmp = tmp.next;
        }

        newHead = tmp.next;
        tmp.next = null;

        ListNode newTmp = newHead;

        while (newTmp.next != null){
            newTmp = newTmp.next;
        }

        newTmp.next = head;

        return newHead;
    }
}
