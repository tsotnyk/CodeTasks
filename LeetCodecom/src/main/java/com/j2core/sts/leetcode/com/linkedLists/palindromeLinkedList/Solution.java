package com.j2core.sts.leetcode.com.linkedLists.palindromeLinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean isPalindrome(ListNode head) {
        ListNode tail = findReverseTail(head);
        while (tail != null) {
            if (head.val != tail.val) return false;
            head = head.next;
            tail = tail.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    private ListNode findReverseTail(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // if the length of List is odd
        if (fast != null) {
            slow = slow.next;
        }
        return reverse(slow);
    }


    @Test
    public void test(){

        ListNode head = new ListNode(0);
        head.next = new ListNode(0);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);

        boolean result = isPalindrome(head);

        Assert.assertTrue(result);

    }
}
