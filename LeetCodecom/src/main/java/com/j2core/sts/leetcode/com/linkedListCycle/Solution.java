package com.j2core.sts.leetcode.com.linkedListCycle;

public class Solution {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        int flag = 0;
        while(slow != fast || flag == 0){
            flag++;
            if(fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
