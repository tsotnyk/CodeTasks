package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter2;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

public class Solution2_1 {

    public ListNode removeDuplicateSet(ListNode root){

        ListNode currentNode = root;
        HashSet<Integer> setNode = new HashSet<>();

        while (currentNode != null){
            setNode.add(currentNode.val);
            currentNode = currentNode.next;
        }
        ListNode newRoot = null;

        for (int val : setNode){

            if (newRoot == null){
                newRoot = new ListNode(val);
                currentNode = newRoot;
            }else {
                currentNode.next = new ListNode(val);
                currentNode = currentNode.next;
            }
        }

        return newRoot;
    }

    @Test
    public void test(){

        ListNode root = new ListNode(5);
        root.next = new ListNode(4);
        root.next.next = new ListNode(5);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(1);

        ListNode newRoot = removeDuplicateSet(root);

        int counter = 0;
        while (newRoot != null){
            counter++;
            newRoot = newRoot.next;
        }

        Assert.assertEquals(counter, 4);
    }

}
