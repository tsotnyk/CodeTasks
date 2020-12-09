package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter2;

import org.testng.annotations.Test;

public class Solution2_3 {

    public void removeNthElement(ListNode root, int n){

        if (n < 3) return;

        int step = 1;
        ListNode node = root;
        ListNode nextNode = node.next;

        while (nextNode != null && step < n-1){
            node = node.next;
            nextNode = nextNode.next;
            step++;
        }

        if (step == n-1){
            node.next = nextNode.next;
        }
    }

    @Test
    public void test(){

        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next = new ListNode(5);

        removeNthElement(root, -1);
        // expect to see all 6 element(from 0 to 5)
        ListNode node = root;
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println("==>  0,1,2,3,4,5");

        // expect to see 5 elements (0,1,3,4,5)
        removeNthElement(root, 3);
        node = root;
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println("==>  0,1,3,4,5");

        removeNthElement(root, 7);
        // expect to see 3 elements (1,2,4)
        node = root;
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println("==>  0,1,3,4,5");
    }
}
