package com.j2core.sts.leetcode.com.convertBinaryNumberInLinkedListToInteger;

public class Solution {

    public int getDecimalValue(ListNode head) {

        StringBuilder builder = new StringBuilder();

        while (head != null){
            builder.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(builder.toString(), 2);
    }
}
