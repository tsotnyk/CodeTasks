package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter2;

import org.junit.Test;

public class Solution2_4 {

    public ListNode sortWithPartition(ListNode root, int partition){

        ListNode smallRoot = null;
        ListNode bigRoot = null;
        ListNode smallNode = null;
        ListNode bigNode = null;
        ListNode tmp = null;

        while (root != null){
            tmp = root;
            root = root.next;
            tmp.next = null;
            if (tmp.val < partition){
                if (smallRoot == null){
                    smallRoot = tmp;
                    smallNode = smallRoot;
                }else {
                    smallNode.next = tmp;
                    smallNode = smallNode.next;
                }
            }else {
                if (bigRoot == null){
                    bigRoot = tmp;
                    bigNode = bigRoot;
                }else {
                    bigNode.next = tmp;
                    bigNode = bigNode.next;
                }
            }
        }

        if (smallRoot == null) return bigRoot;

        smallNode.next = bigRoot;
        return smallRoot;
    }

    @Test
    public void test(){

        ListNode root1 = new ListNode(5);
        root1.next = new ListNode(3);
        root1.next.next = new ListNode(8);
        root1.next.next.next = new ListNode(2);
        root1.next.next.next.next = new ListNode(1);
        root1.next.next.next.next.next = new ListNode(10);

//        ListNode result = sortWithPartition(root1, 3);
//
//        while (result != null){
//            System.out.print(result.val);
//            result = result.next;
//        }
//        System.out.println( "    == >  2153810");

//        ListNode result1 = sortWithPartition(root1, 15);
//
//        while (result1 != null){
//            System.out.print(result1.val);
//            result1 = result1.next;
//        }
//        System.out.println( "    == >  5382110");


        ListNode result1 = sortWithPartition(root1, 0);

        while (result1 != null){
            System.out.print(result1.val);
            result1 = result1.next;
        }
        System.out.println( "    == >  5382110");
    }
}
