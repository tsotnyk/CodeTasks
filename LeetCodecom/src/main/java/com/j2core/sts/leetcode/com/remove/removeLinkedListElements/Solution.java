package com.j2core.sts.leetcode.com.remove.removeLinkedListElements;

import org.testng.annotations.Test;

public class Solution {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) return null;

        if (head.next == null){
            if (head.val != val){
                return head;
            }else {
                return null;
            }
        }else {
            ListNode first = head;
            ListNode second = first.next;

            while (second != null && first.val == val){
                first = second;
                second = first.next;
            }
            if (first.val == val){

                return null;
            }
            head = first;
            while (second != null){

                if (second.val == val){
                    first.next = second.next;
                    second = first.next;
                }else {

                    first = first.next;
                    second = first.next;
                }

                if (second == null){
                    return head;
                }
            }
            return head;
        }
    }


    @Test
    public void test(){

        Solution solution = new Solution();

        ListNode first = new ListNode(1);
        first.next = new ListNode(2);

        ListNode node2 = first.next;
        node2.next = new ListNode(6);

        first.next.next.next = new ListNode(3);
        first.next.next.next.next = new ListNode(4);
        first.next.next.next.next.next = new ListNode(5);
        first.next.next.next.next.next.next = new ListNode(6);


        ListNode head = solution.removeElements(first, 6);

        System.out.print(head);
    }
}
