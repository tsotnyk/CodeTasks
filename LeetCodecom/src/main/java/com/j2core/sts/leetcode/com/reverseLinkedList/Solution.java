package com.j2core.sts.leetcode.com.reverseLinkedList;

import org.testng.annotations.Test;

public class Solution {

    public ListNode reverseList(ListNode head) {

        ListNode newHead = null;
        ListNode tmpHead;
        ListNode tmp;

        while (head != null){

            tmpHead = head.next;
            head.next = null;
            tmp = newHead;
            newHead = head;
            newHead.next = tmp;

            head = tmpHead;

        }

        return newHead;

    }

    @Test
    public void test(){

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode result = reverseList(node);

    }

}
