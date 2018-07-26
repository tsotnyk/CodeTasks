package com.j2core.sts.leetcode.com.linkedLists.removeDuplicatesfromSortedList;

import org.testng.annotations.Test;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return null;
        ListNode node = head;
        while (node.next != null) {

            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    @Test
    public void test(){

        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(3);

        ListNode result = deleteDuplicates(node);

        System.out.print(result.val);

    }
}
