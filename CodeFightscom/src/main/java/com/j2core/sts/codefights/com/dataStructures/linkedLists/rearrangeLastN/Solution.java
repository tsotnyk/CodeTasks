package com.j2core.sts.codefights.com.dataStructures.linkedLists.rearrangeLastN;

public class Solution {

    ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {

        if (l == null || n == 0){
            return l;
        }else {

            int sizeList = 0;

            ListNode<Integer> tmp = l;
            ListNode<Integer> lastNode = null;
            ListNode<Integer> newHead;
            while (tmp != null){

                sizeList++;
                if (tmp.next == null){
                    lastNode = tmp;
                }
                tmp = tmp.next;
            }

            if (sizeList == n) return l;

            tmp = l;
            for(int i = 1; i < sizeList-n; i++){

                tmp = tmp.next;
            }

            newHead = tmp.next;
            tmp.next = null;

            lastNode.next = l;

            return newHead;

        }
    }
}
