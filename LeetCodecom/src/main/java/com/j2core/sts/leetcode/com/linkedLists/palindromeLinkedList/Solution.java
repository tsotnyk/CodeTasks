package com.j2core.sts.leetcode.com.linkedLists.palindromeLinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean isPalindrome(ListNode head) {

        ListNode node = head;
        ListNode reversHead = reverseList(head);
        while (head != null){

            if (node.val != reversHead.val){
                return false;
            }

            node = node.next;
            reversHead = reversHead.next;

        }

        return true;

    }

    private ListNode reverseList(ListNode head) {



        ListNode reversHead = null;

        while (head != null) {

            ListNode next = head.next;
            head.next = reversHead;
            reversHead = head;
            head = next;
        }

        return reversHead;
    }


    @Test
    public void test(){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        boolean result = isPalindrome(head);

        Assert.assertTrue(result);

    }
}
