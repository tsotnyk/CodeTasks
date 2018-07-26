package com.j2core.sts.leetcode.com.linkedLists.removeDuplicatesFromSortedListII;

import org.testng.annotations.Test;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return null;

        if (head.next == null) return head;

        ListNode result = null;
        ListNode firstNode = head;
        ListNode node = firstNode;
        while (node.next != null){

            if (node.val == node.next.val) {
                while (node.next != null && node.val == node.next.val) {
                    node = node.next;
                }

                node = node.next;

            }else {
                if (result == null){
                    result = node;
                    firstNode = result;
                }else {
                    firstNode.next = node;
                    firstNode = firstNode.next;
                }
                node = node.next;

            }
            if (node == null){
                firstNode.next = null;
                break;
            }
        }

        firstNode.next = node;

        if (result == null) return node;

        return result;
    }


    @Test
    public void test(){

        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next.next.next = new ListNode(6);

        ListNode result = deleteDuplicates(node);

        System.out.print(result.val);

    }

}
