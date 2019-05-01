package com.j2core.sts.leetcode.com.splitLinkedListInParts;

public class Solution {

    public ListNode[] splitListToParts(ListNode root, int k) {

        ListNode[] array = new ListNode[k];

        if (root == null){
            return array;
        }

        int counter = 1;
        ListNode tmp = root;
        while (tmp.next != null){
            tmp = tmp.next;
            counter++;
        }

        if (counter <= k){
            for (int i = 0; i < counter; i++){
                tmp = root;
                root = root.next;
                tmp.next = null;
                array[i] = tmp;
            }

            return array;
        }

        int minSize = counter/k;
        int delta = counter%k;
        int index = 0;
        while (index < k){

            counter = delta-- > 0 ? minSize+1 : minSize;
            ListNode newRoot;
            tmp = root;
            while (counter-- > 1){
                tmp = tmp.next;
            }
            newRoot = tmp.next;
            tmp.next = null;
            array[index++] = root;
            root = newRoot;
        }

        return array;
    }

}
