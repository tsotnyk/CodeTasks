package com.j2core.sts.leetcode.com.sortList.README;

import java.util.Arrays;

public class Solution {

    public ListNode sortListOld(ListNode head) {

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

//    public ListNode sortList(ListNode head) {
//
//        if (head == null || head.next == null) return head;
//
//        ListNode node = head;
//        ListNode newHead = sortList(head.next);
//
//        if (node.val < newHead.val){
//            node.next = newHead;
//            return node;
//        }else {
//            ListNode nextNode = newHead;
//            while (nextNode.next != null && nextNode.next.val < node.val){
//                nextNode = nextNode.next;
//            }
//            node.next = nextNode.next;
//            nextNode.next = node;
//        }
//
//        return newHead;
//    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;
        boolean changeFlag;
        int tmpVal;

        do {
            ListNode node = head;
            changeFlag = false;
            while (node.next != null){
                if (node.val > node.next.val){
                    tmpVal = node.val;
                    node.val = node.next.val;
                    node.next.val = tmpVal;
                    changeFlag = true;
                }else{
                    node = node.next;
                }
            }
        }while (changeFlag);

        return head;
    }
}
