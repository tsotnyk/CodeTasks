package com.j2core.sts.leetcode.com.linkedLists.deleteNodeInLinkedList;

import org.testng.annotations.Test;

public class Solution {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }


    @Test
    public void test(){

        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);

        deleteNode(node);

        System.out.print(node.next.val);

    }
}
