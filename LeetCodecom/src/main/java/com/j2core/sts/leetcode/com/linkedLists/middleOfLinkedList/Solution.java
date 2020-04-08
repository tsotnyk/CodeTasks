package com.j2core.sts.leetcode.com.linkedLists.middleOfLinkedList;

public class Solution {

    public ListNode middleNode(ListNode head) {

        if (head.next == null) return head;

        ListNode tmp = head.next;
        ListNode result = head.next;

        while (tmp.next != null){
            tmp = tmp.next;
            if (tmp.next != null){
                result = result.next;
                tmp = tmp.next;
            }
        }

        return result;
    }
}
