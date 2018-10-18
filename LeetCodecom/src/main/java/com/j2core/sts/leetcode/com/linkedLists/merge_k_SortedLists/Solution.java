package com.j2core.sts.leetcode.com.linkedLists.merge_k_SortedLists;

import org.testng.annotations.Test;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode newList = null;
        ListNode nextNode = null;

        while (!isEmptyArray(lists)){

            int smaller = Integer.MAX_VALUE;
            int index = -1;

            for (int i = 0; i < lists.length; i++) {

                if (lists[i] != null) {

                    if (lists[i].val < smaller) {
                        smaller = lists[i].val;
                        index = i;
                    }
                }
            }

            if (newList == null){
                newList = addListNode(null, lists, index);
            }else if (nextNode == null){
                nextNode = addListNode(newList, lists, index);
            }else {
                nextNode = addListNode(nextNode, lists, index);
            }
        }

        return newList;
    }

    private ListNode addListNode(ListNode head, ListNode[] array, int index){

        ListNode tmp = array[index];
        ListNode tmpHead = tmp.next;
        tmp.next = null;
        array[index] = tmpHead;

        if (head == null){
            return tmp;
        }else {
            head.next = tmp;
            return tmp;
        }

    }

    private boolean isEmptyArray(ListNode[] array){

        for (ListNode node : array){

            if (node != null){
                return false;
            }
        }

        return true;
    }

    @Test
    public void test(){

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);
        node3.next.next = new ListNode(7);

        ListNode[] array = new ListNode[]{node1, node2, node3};

        ListNode result = mergeKLists(array);

    }
}
