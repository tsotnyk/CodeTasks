package com.j2core.sts.leetcode.com.swapNodesInPairs;

public class Solution {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode last = null;
        ListNode first = null;
        ListNode second = null;
        ListNode tmpHead = head;

        do {

            first = tmpHead;
            second = first.next;
            tmpHead = second.next;
            first.next = null;
            second.next = first;

            if (last == null){
                last = first;
                head = second;
            }else {
                last.next = second;
                last = last.next.next;
            }

        }while (tmpHead != null && tmpHead.next != null);

        if (tmpHead != null){
            last.next = tmpHead;
        }
        return head;
    }
}
