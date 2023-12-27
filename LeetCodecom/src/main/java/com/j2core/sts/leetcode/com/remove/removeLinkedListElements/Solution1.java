package com.j2core.sts.leetcode.com.remove.removeLinkedListElements;

public class Solution1 {

    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val){
            head = head.next;
        }

        if (head != null) {
            ListNode curNode = head;
            ListNode candidate = curNode.next;

            while (candidate != null){
                if (candidate.val == val){
                    curNode.next = candidate.next;
                    candidate = curNode.next;
                }else {
                    curNode = curNode.next;
                    candidate = candidate.next;
                }
            }
        }
        return head;
    }
}
