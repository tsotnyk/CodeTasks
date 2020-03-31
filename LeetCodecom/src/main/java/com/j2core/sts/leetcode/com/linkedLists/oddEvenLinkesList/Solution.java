package com.j2core.sts.leetcode.com.linkedLists.oddEvenLinkesList;

import org.testng.annotations.Test;

public class Solution {

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) return head;

        ListNode newHead = null;
        ListNode tmpHead = null;
        ListNode evenNodes = null;
        ListNode tmpEven = null;

        while (head != null){

            if (newHead == null){
                newHead = head;
                head = head.next;
                newHead.next = null;
                tmpHead = newHead;
            }else {
                tmpHead.next = head;
                head = head.next;
                tmpHead.next.next = null;
                tmpHead = tmpHead.next;
            }

            if (head != null) {

                if (evenNodes == null) {
                    evenNodes = head;
                    head = head.next;
                    evenNodes.next = null;
                    tmpEven = evenNodes;
                } else {
                    tmpEven.next = head;
                    head = head.next;
                    tmpEven.next.next = null;
                    tmpEven = tmpEven.next;
                }
            }
        }

        tmpHead.next = evenNodes;

        return newHead;
    }

    @Test
    public void test(){

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        oddEvenList(root);

    }
}
