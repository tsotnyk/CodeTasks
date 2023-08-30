package com.j2core.sts.leetcode.com.linkedLists.mergeTwoSortedLists;

public class Solution1 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = null;
        ListNode next = null;

        while (list1 != null && list2 != null){
            ListNode curNode;
            if (list1.val < list2.val){
                curNode = list1;
                list1 = list1.next;
            }else {
                curNode = list2;
                list2 = list2.next;
            }
            if (head == null){
                head = curNode;
                next = head;
                continue;
            }
            next.next = curNode;
            next = next.next;
        }

        next.next = list1 == null ? list2 : list1;

        return head;

    }
}
