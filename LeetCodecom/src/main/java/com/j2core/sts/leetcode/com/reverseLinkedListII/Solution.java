package com.j2core.sts.leetcode.com.reverseLinkedListII;

public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {

            ListNode helpNode = new ListNode(-1);
            helpNode.next = head;
            ListNode prev = helpNode;
            for (int i = 1; i < m; i++) {
                prev = prev.next;
            }

            ListNode tail = prev.next;
            ListNode nextNode = prev.next;
            ListNode tmpHead = null;
            int reverseCount = n - m + 1;
            while (reverseCount > 0) {
                ListNode tmp = nextNode.next;
                nextNode.next = tmpHead;
                tmpHead = nextNode;
                nextNode = tmp;
                reverseCount--;
            }
            prev.next = tmpHead;
            tail.next = nextNode;

            return helpNode.next;

    }
}
