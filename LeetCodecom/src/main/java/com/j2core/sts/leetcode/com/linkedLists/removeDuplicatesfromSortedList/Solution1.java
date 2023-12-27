package com.j2core.sts.leetcode.com.linkedLists.removeDuplicatesfromSortedList;

public class Solution1 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode cur = head;
        ListNode candidate = cur.next;

        while (candidate != null){

            if (cur.val == candidate.val){
                cur.next = candidate.next;
                candidate = cur.next;
            }else {
                cur = candidate;
                candidate = candidate.next;
            }
        }

        return head;
    }
}
