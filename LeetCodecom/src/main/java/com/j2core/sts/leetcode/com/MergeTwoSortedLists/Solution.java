package com.j2core.sts.leetcode.com.MergeTwoSortedLists;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        int[] arrayResult = null;
        int[] array1 = createNumArray(l1);
        int[] array2 = createNumArray(l2);
        if (array1 == null && array2 == null)return null;
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        if (array1 != null && array2 != null) {

            arrayResult = new int[array1.length + array2.length];
            while (index1 < array1.length && index2 < array2.length) {
                int num1 = array1[index1];
                int num2 = array2[index2];
                int num;
                if (num1 < num2) {
                    num = num1;
                    index1++;
                } else {
                    num = num2;
                    index2++;
                }
                arrayResult[index] = num;
                index++;
            }
        }
        int[] tmpArray = null;
        int tmpIndex = -1;
        if (array1 != null && index1 < array1.length) {
            tmpArray = array1;
            tmpIndex = index1;
        } else if (array2 != null && index2 < array2.length) {
            tmpArray = array2;
            tmpIndex = index2;
        }
        if (arrayResult == null){
            arrayResult = new int[tmpArray.length];
        }
        if (tmpArray != null && tmpIndex < tmpArray.length) {
            while (tmpIndex < tmpArray.length) {
                arrayResult[index] = tmpArray[tmpIndex];
                tmpIndex++;
                index++;
            }
        }
        ListNode result = new ListNode(arrayResult[0]);
        ListNode node = result;
        for (int i = 1; i < arrayResult.length; i++) {
            node.next = new ListNode(arrayResult[i]);
            node = node.next;
        }
        return result;
    }

    private int[] createNumArray(ListNode listNode){

        if (listNode != null) {
            List<Integer> numbers = new LinkedList<Integer>();
            ListNode node = listNode;
            while (node.next != null) {
                numbers.add(node.val);
                node = node.next;
            }
            numbers.add(node.val);

            int[] result = new int[numbers.size()];

            for (int i = 0; i < numbers.size(); i++ ){

                result[i] = numbers.get(i);
            }

            return result;
        }else return null;
    }
}
