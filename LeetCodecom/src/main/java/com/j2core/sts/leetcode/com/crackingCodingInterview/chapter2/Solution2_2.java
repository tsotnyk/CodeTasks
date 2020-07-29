package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution2_2 {

    public ListNode getKthEndElement(ListNode root, int k){

        int counter = 0;
        ListNode kElement = root;
        ListNode current = root;

        while (current != null){
            if (counter < k){
                counter++;
            }else {
                kElement = kElement.next;
            }
            current = current.next;
        }

        if (counter < k) return null;

        return kElement;
    }

    @Test
    public void test(){

        ListNode root = new ListNode(5);
        root.next = new ListNode(4);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(1);

        Assert.assertNull(getKthEndElement(null, 1));
        Assert.assertNull(getKthEndElement(root, 7));
        Assert.assertEquals(getKthEndElement(root,1).val, 1);
        Assert.assertEquals(getKthEndElement(root,5).val, 5);
        Assert.assertEquals(getKthEndElement(root,3).val, 3);

    }
}
