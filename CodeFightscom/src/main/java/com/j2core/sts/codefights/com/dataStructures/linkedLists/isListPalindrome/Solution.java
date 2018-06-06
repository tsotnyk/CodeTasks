package com.j2core.sts.codefights.com.dataStructures.linkedLists.isListPalindrome;

public class Solution {

    public boolean isListPalindrome(ListNode<Integer> l) {

        if (l != null) {

            if (l.next == null) return true;

            int count = 1;

            ListNode<Integer> tmpNode = l;

            while (tmpNode.next != null){

                count++;
                tmpNode = tmpNode.next;

            }

            int indexSecondHead = count/2;
            int deltaParity;
            if (count%2 != 0) {
                deltaParity = 1;
            }else {
                deltaParity = 0;
            }

            tmpNode = l;

            for (int i = indexSecondHead + deltaParity; i > 0; i--){
                tmpNode = tmpNode.next;
            }

            ListNode<Integer> tmp2Node = null;
            ListNode<Integer> nextNode;

            while (tmpNode != null){

                nextNode = tmpNode.next;
                tmpNode.next = tmp2Node;
                tmp2Node = tmpNode;
                tmpNode = nextNode;

            }

            nextNode = l;

            while (indexSecondHead - deltaParity > 0){

                if (!tmp2Node.value.equals(nextNode.value)){
                    return false;
                }
                tmp2Node = tmp2Node.next;
                nextNode = nextNode.next;
                indexSecondHead--;
            }

        }
        return true;
    }
}
