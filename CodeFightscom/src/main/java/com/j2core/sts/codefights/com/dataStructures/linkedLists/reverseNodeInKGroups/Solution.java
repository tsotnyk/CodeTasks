package com.j2core.sts.codefights.com.dataStructures.linkedLists.reverseNodeInKGroups;

public class Solution {

    public ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {

        if (l.next == null || k == 1){
            return l;
        }else{

            ListNode<Integer> head = null;
            ListNode<Integer> a = l;
            ListNode<Integer> b = a.next;
            ListNode<Integer> afterB;
            ListNode<Integer> beforeA = null;

            while (b != null){

                for (int i = 1; i < k-1; i++){

                    b = b.next;
                    if (b == null) break;

                }
                if (b != null) {
                    afterB = b.next;
                    b.next = null;

                    ListNode<Integer> tmp;
                    ListNode<Integer> tmpHead = null;
                    ListNode<Integer> nextNode = a;

                    while (nextNode != null) {

                        tmp = nextNode.next;
                        nextNode.next = tmpHead;
                        tmpHead = nextNode;
                        nextNode = tmp;

                    }

                    if (head == null) {
                        head = tmpHead;
                    }

                    if (beforeA != null) {
                        beforeA.next = b;
                    }

                    a.next = afterB;

                    beforeA = a;
                    a = beforeA.next;
                    if (a != null) {
                        b = a.next;
                    }else {
                        b = null;
                    }
                }

            }

            return head;

        }
    }
}
