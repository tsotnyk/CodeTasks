package com.j2core.sts.leetcode.com.reorderList;

import org.junit.Test;

public class Solution {

    public void reorderList(ListNode head) {

        if (head != null && head.next != null) {
            int size = 0;

            ListNode tmpHead = head;
            while (tmpHead != null) {
                size++;
                tmpHead = tmpHead.next;
            }

            int half = size / 2;

            ListNode lastFirst = head;
            ListNode secondHead = head;

            while (half-- > 0) {
                lastFirst = secondHead;
                secondHead = secondHead.next;
            }

            lastFirst.next = null;
            secondHead = reversList(secondHead);

            createList(head, secondHead);
        }
    }

    private ListNode reversList(ListNode listNode){

        ListNode newHead = null;
        ListNode tmp;

        while (listNode != null){

            tmp = listNode;
            listNode = listNode.next;
            tmp.next = null;
            tmp.next = newHead;
            newHead = tmp;
        }

        return newHead;
    }

    private void createList(ListNode head, ListNode secondHead){

        ListNode firstHead = head.next;
        head.next = null;
        ListNode tmpHead = head;
        ListNode tmp;

        while (secondHead != null){

            tmp  = secondHead;
            secondHead = secondHead.next;
            tmp.next = null;

            tmpHead.next = tmp;
            tmpHead = tmpHead.next;

            if (firstHead != null) {
                tmp = firstHead;
                firstHead = firstHead.next;
                tmp.next = null;

                tmpHead.next = tmp;
                tmpHead = tmpHead.next;
            }
        }
    }

    @Test
    public void test(){

        ListNode data = new ListNode(1);
        data.next = new ListNode(2);
        data.next.next = new ListNode(3);
        data.next.next.next = new ListNode(4);
        data.next.next.next.next = new ListNode(5);

        reorderList(data);

        ListNode result = data;

    }
}
