package com.j2core.sts.leetcode.com.rotateList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public ListNode rotateRightOld(ListNode head, int k) {

        if (head == null || head.next == null || k == 0){
            return head;
        }
        int size = 1;
        ListNode tmp = head;

        while (tmp.next != null){
            size++;
            tmp = tmp.next;
        }
        int delta = k%size;

        if (delta == 0){
            return head;
        }

        int newHeadIndex = size - k%size;

        if (newHeadIndex == 0){
            return head;
        }

        tmp = head;
        ListNode newHead = null;
        int tmpIndex = 1;
        while (tmpIndex++ < newHeadIndex){
            tmp = tmp.next;
        }

        newHead = tmp.next;
        tmp.next = null;

        ListNode newTmp = newHead;

        while (newTmp.next != null){
            newTmp = newTmp.next;
        }

        newTmp.next = head;

        return newHead;
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) return head;
        if (k == 0) return head;

        ListNode newHead = head;
        ListNode prevNode = null;
        ListNode node = head;
        int counter = 1;

        while (node.next != null){
            counter++;
            if (counter > k){
                if (prevNode == null){
                    prevNode = newHead;
                }else {
                    prevNode = prevNode.next;
                }
                newHead = newHead.next;
            }
            node = node.next;
        }

        if (counter <= k){
            return rotateRight(head, k%counter);
        }

        prevNode.next = null;
        node.next = head;

        return newHead;
    }

    @Test
    public void test(){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode head1 = new ListNode(0);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);

        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);

        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        Assert.assertEquals(rotateRight(head3, 2).val, 1);


        Assert.assertEquals(rotateRight(head, 2).val, 4);

        Assert.assertEquals(rotateRight(head1, 1).val, 2);
        Assert.assertEquals(rotateRight(head2, 4).val, 2);
    }
}
