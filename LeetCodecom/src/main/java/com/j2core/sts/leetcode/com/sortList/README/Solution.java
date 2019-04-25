package com.j2core.sts.leetcode.com.sortList.README;

import java.util.Arrays;

public class Solution {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode tmp = head;
        int counter = 1;
        int index = 0;

        while (tmp.next != null){
            counter++;
            tmp = tmp.next;
        }

        tmp = head;
        int[] array = new int[counter];
        while (index < counter){
            array[index++] = tmp.val;
            tmp = tmp.next;
        }

        Arrays.sort(array);
        index = 0;
        tmp = head;
        while (index < counter){
            tmp.val = array[index++];
            tmp = tmp.next;
        }

        return head;
    }
}
