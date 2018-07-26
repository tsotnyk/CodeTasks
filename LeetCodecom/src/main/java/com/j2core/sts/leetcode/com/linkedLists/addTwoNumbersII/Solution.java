package com.j2core.sts.leetcode.com.linkedLists.addTwoNumbersII;

import org.testng.annotations.Test;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode head1, head2, l1Node, l2Node, tmp;
        int num1, num2;
        int length1 = nodeLength(l1);
        int length2 = nodeLength(l2);

        if (length2 > length1){
            head1 = l2;
            head2 = l1;
            int tmpLength = length1;
            length1 = length2;
            length2 = tmpLength;
        }else {
            head1 = l1;
            head2 = l2;
        }

        int delta = 0;
        while (length2 > 0) {

            l1Node = head1;
            for (int i = 1; i < length1; i++){
                l1Node = l1Node.next;
            }
            num1 = l1Node.val;
            length1--;

            l2Node = head2;
            for (int j = 1; j < length2; j++){
                l2Node = l2Node.next;
            }
            num2 = l2Node.val;
            length2--;

            int tmpSum = num1 + num2 + delta;
            delta = 0;

            if (tmpSum > 9){
                delta = 1;
                tmpSum = tmpSum - 10;
            }

            if (result == null){
                result = new ListNode(tmpSum);
            }else {

                tmp = result;
                result = new ListNode(tmpSum);
                result.next = tmp;
            }
        }

        if (length1 > 0){

            while (length1 > 0) {

                l1Node = head1;
                for (int i = 1 ; i < length1; i++){
                    l1Node = l1Node.next;
                }
                num1 = l1Node.val + delta;
                delta = 0;
                length1--;

                if (num1 > 9){
                    delta = 1;
                    num1 = num1 - 10;
                }

                if (result == null){
                    result = new ListNode(num1);
                }else {
                    tmp = result;
                    result = new ListNode(num1);
                    result.next = tmp;
                }
            }
        }

        if (delta > 0){

            tmp = result;
            result = new ListNode(delta);
            result.next = tmp;
        }

        return result;
    }

    private int nodeLength(ListNode node){

        int length;
        if (node != null){
            length = 1;
        }else return 0;

        while (node.next != null){

            length++;
            node = node.next;
        }

        return length;

    }

    @Test
    public void test(){


        ListNode node = new ListNode(7);
        node.next = new ListNode(2);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(3);

        ListNode node1 = new ListNode(5);
        node1.next = new ListNode(6);
        node1.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(node, node1);

        System.out.print(result.val);
    }
}
