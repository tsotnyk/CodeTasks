package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter2;

import org.junit.Assert;
import org.junit.Test;

public class Solution2_6 {

    public boolean isPalindrome(ListNode root){

        if (root == null) return false;
        if (root.next == null) return true;

        ListNode reverse = reverseListNode(root);

        while (root != null){
            if (root.val != reverse.val) return false;
            root = root.next;
            reverse = reverse.next;
        }
        return true;
    }

    private ListNode reverseListNode(ListNode root){

        ListNode reverseRoot = null;
        ListNode reverseNode = null;
        ListNode tmp = null;

        while (root != null){
            tmp = root;
            root = root.next;
            tmp.next = null;
            if (reverseRoot == null){
                reverseRoot = tmp;
            }else {
                reverseNode = reverseRoot;
                reverseRoot = tmp;
                reverseRoot.next = reverseNode;
            }
        }

        return reverseRoot;
    }


    @Test
    public void test(){

        ListNode root = null;

        Assert.assertFalse(isPalindrome(root));

        ListNode root1 = new ListNode(5);
        Assert.assertTrue(isPalindrome(root1));

        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(1);
        Assert.assertTrue(isPalindrome(root2));

        ListNode root3 = new ListNode(1);
        root3.next = new ListNode(2);
        Assert.assertFalse(isPalindrome(root3));

        ListNode root4 = new ListNode(1);
        root4.next = new ListNode(2);
        root4.next.next = new ListNode(1);
        Assert.assertTrue(isPalindrome(root4));

        ListNode root5 = new ListNode(1);
        root5.next = new ListNode(2);
        root5.next.next = new ListNode(2);
        Assert.assertFalse(isPalindrome(root5));
    }
}
