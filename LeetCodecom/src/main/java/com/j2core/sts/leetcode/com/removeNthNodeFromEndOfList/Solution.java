package com.j2core.sts.leetcode.com.removeNthNodeFromEndOfList;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || (head.next == null && n == 1)) {
                return null;
            }

            int size = 1;
            ListNode tmp = head;

            while (tmp.next != null){
                size++;
                tmp = tmp.next;

            }

            if (n == size){
                return head.next;
            }

            int removeIndex = size-n-1;

            tmp = head;
            for (int i = 0; i < removeIndex; i++){
                tmp = tmp.next;
            }

            if (n == 1){
                tmp.next = null;
                return head;
            }

            tmp = tmp.next;

            while (true){

                tmp.val = tmp.next.val;
                if (tmp.next.next == null){
                    tmp.next = null;
                    break;
                }
                tmp = tmp.next;
            }

            return head;

    }
}
