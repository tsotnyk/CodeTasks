package com.j2core.sts.codefights.com.dataStructures.removeFromList;

public class Solution {

    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {

        if (l != null) {

            while (l.value == k) {
                if (l.next != null) {
                    l = l.next;
                } else {
                    return null;
                }
            }

            if (l.next == null) return l;

            ListNode<Integer> tmpNode = l;

            while (tmpNode.next != null) {

                if (tmpNode.next.value == k) {

                    tmpNode.next = tmpNode.next.next;
                } else {
                    tmpNode = tmpNode.next;
                }
            }
        }

        return l;

    }
}
