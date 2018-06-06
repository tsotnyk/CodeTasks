package com.j2core.sts.codefights.com.dataStructures.linkedLists.addTwoHugeNumbers;

public class Solution {

    public ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {

        ListNode<Integer> result = null;

        if (a != null && b != null){

            a = reversListNode(a);
            b = reversListNode(b);

            result = addHugeNumbers(a, b);
            result = reversListNode(result);


        }else if (a == null && b != null){

            result = b;
        }else if (a != null){

            result = a;
        }

        return result;
    }

    private ListNode<Integer> addHugeNumbers(ListNode<Integer> first, ListNode<Integer> second){

        int maxNum = 9999;
        int tmpNum;
        ListNode<Integer> head = null;
        ListNode<Integer> result = null;
        int delta = 0;

        while (first != null && second!= null){

            tmpNum = first.value + second.value + delta;
            if (tmpNum > maxNum){
                delta = 1;
                tmpNum = tmpNum - maxNum - delta;
            }else {
                delta = 0;
            }

            if (result == null){
                result = new ListNode<>(tmpNum);
                head = result;
            }else {
                result.next = new ListNode<>(tmpNum);
            }

            first = first.next;
            second = second.next;
            if (result.next != null){
                result = result.next;
            }
        }

        ListNode<Integer> tmpNode = null;
        if (first != null) {
            tmpNode = first;
        } else if (second != null) {
            tmpNode = second;
        }

        while (tmpNode != null && result != null) {

            if (delta > 0) {

                tmpNum = tmpNode.value + delta;
                if (tmpNum > maxNum) {
                    tmpNode.value = tmpNum - maxNum - delta;
                } else {
                    delta = 0;
                    tmpNode.value = tmpNum;
                }

            }
            result.next = tmpNode;
            result = result.next;
            tmpNode = tmpNode.next;

        }

        if (delta > 0){

            result.next = new ListNode<Integer>(delta);
        }
        return head;
    }


    private ListNode<Integer>  reversListNode(ListNode<Integer> listNode){

        ListNode<Integer> nextNode;
        ListNode<Integer> newHead = null;
        ListNode<Integer> oldHead = listNode;

        while (oldHead != null) {

            nextNode = oldHead.next;
            oldHead.next = newHead;
            newHead = oldHead;
            oldHead = nextNode;
        }
        return newHead;

    }
}
