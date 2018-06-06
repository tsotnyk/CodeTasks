package com.j2core.sts.codefights.com.dataStructures.linkedLists.mergeTwoLinkedList;

public class Solution {

    public ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {

        ListNode<Integer> resultList = null;
        ListNode<Integer> tmpNode = null;

        if (l1 != null && l2 != null){

            while (l1 != null && l2 != null) {

                if (tmpNode == null){

                    if (l1.value < l2.value){
                        tmpNode = l1;
                        l1 = l1.next;
                    }else {
                        tmpNode = l2;
                        l2 = l2.next;
                    }
                    resultList = tmpNode;
                }else {

                    if (l1.value < l2.value) {
                        tmpNode.next = l1;
                        l1 = l1.next;
                    } else {
                        tmpNode.next = l2;
                        l2 = l2.next;
                    }
                    tmpNode = tmpNode.next;
                }
            }
            if (l1 != null){
                tmpNode.next = l1;
            }else {
                tmpNode.next = l2;
            }

        }else if (l1 == null && l2 != null){
            resultList = l2;

        }else if (l1 != null){
            resultList = l1;
        }

        return resultList;
    }

}
