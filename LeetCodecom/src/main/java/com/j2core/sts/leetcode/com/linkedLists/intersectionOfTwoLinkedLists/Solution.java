package com.j2core.sts.leetcode.com.linkedLists.intersectionOfTwoLinkedLists;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        boolean existListA = false;
        boolean existListB = false;
        ListNode result = null;

        if (node1 == null || node2 == null) {
            return result;
        } else if (node1 == node2) {
            return node1;
        }

        while(node1.next != null || node2.next !=null) {
            if (node1 == node2) {
                return node1;
            }

            if (node1.next == null) {
                existListA = true;
            }

            if (node2.next == null) {
                existListB = true;
            }

            if (existListA) {
                node1 = headB;
                existListA = false;
            } else {
                node1 = node1.next;
            }

            if (existListB) {
                node2 = headA;
                existListB = false;
            } else {
                node2 = node2.next;
            }
        }

        if (node1 == node2) {
            return node1;
        }

        return result;
    }
}
