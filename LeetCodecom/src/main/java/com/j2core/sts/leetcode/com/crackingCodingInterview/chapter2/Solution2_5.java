package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter2;

import org.junit.Test;

public class Solution2_5 {

    public ListNode addTwoNumbers(ListNode first, ListNode second){

        if (first == null) return second;
        if (second == null) return first;

        ListNode result = null;
        ListNode node = null;
        int delta = 0;
        int sum = 0;

        while (first != null && second != null){
            sum = delta + first.val + second.val;
            delta = 0;
            if (sum > 9){
                delta = sum/10;
                sum %= 10;
            }
            if (result == null){
                result = new ListNode(sum);
                node = result;
            }else {
                node.next = new ListNode(sum);
                node = node.next;
            }
            first = first.next;
            second = second.next;
        }

        if (first != null || second != null){
            ListNode lastNum = first != null ? first : second;
            while (lastNum != null){
                sum = delta + lastNum.val;
                delta = 0;
                if (sum > 9){
                    delta = sum/10;
                    sum %= 10;
                }
                node.next = new ListNode(sum);
                node = node.next;
                lastNum = lastNum.next;
            }
        }

        if (delta > 0){
            node.next = new ListNode(delta);
        }

        return result;
    }

    @Test
    public void test(){

        ListNode first = new ListNode(0);
        first.next = new ListNode(1);
        first.next.next = new ListNode(2);
        first.next.next.next = new ListNode(4);
        first.next.next.next.next = new ListNode(4);
        first.next.next.next.next.next = new ListNode(5);

        ListNode second = new ListNode(0);
        second.next = new ListNode(1);
        second.next.next = new ListNode(9);
        second.next.next.next = new ListNode(5);

        ListNode result = addTwoNumbers(first, second);

        while (result != null){
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println( "     ===>  021055 ");

    }

}
