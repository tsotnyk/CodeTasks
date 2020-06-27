package com.j2core.sts.leetcode.com.linkedLists.partitionList;

import org.testng.annotations.Test;

public class Solution {

    public ListNode partition(ListNode head, int x) {

        ListNode smallerHead = null;
        ListNode biggerHead = null;
        ListNode smaller = null;
        ListNode bigger = null;
        ListNode tmp;

        while (head != null){
            tmp = head;
            head = head.next;
            tmp.next = null;

            if (tmp.val < x){
                if (smallerHead == null){
                    smallerHead = tmp;
                    smaller = smallerHead;
                }else {
                    smaller.next = tmp;
                    smaller = smaller.next;
                }
            }else {
                if (biggerHead == null){
                    biggerHead = tmp;
                    bigger = biggerHead;
                }else {
                    bigger.next = tmp;
                    bigger = bigger.next;
                }
            }
        }

        if (smallerHead == null) return biggerHead;
        if (biggerHead == null) return smallerHead;

        smaller.next = biggerHead;

        return smallerHead;
    }
}
