package com.j2core.sts.leetcode.com.addTwoNumbers;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * The class count two numbers
 */
public class Solution {

    /**
     * The method count count two numbers with saved in to list node
     *
     * @param l1   first numbers witch wrote in the list node
     * @param l2   second number witch wrote in the list node
     * @return     result numbers witch wrot in list node
     */
    public ListNode addTwoNumbersOld(ListNode l1, ListNode l2) {

        ListNode result = null;
        char[] numArray1 = createNumArray(l1);
        char[] numArray2 = createNumArray(l2);
        StringBuilder builder = new StringBuilder();
        try {
            int index = 0;
            int delta = 0;
            while (index < numArray1.length && index < numArray2.length) {
                Integer num1 = Integer.parseInt(String.valueOf(numArray1[index]));
                Integer num2 = Integer.parseInt(String.valueOf(numArray2[index]));
                Integer sum = num1 + num2 + delta;
                if (delta == 1) delta = 0;
                if (sum > 9) {
                    sum = sum - 10;
                    delta = 1;
                }
                builder.append(sum.toString());
                index++;
            }
            char[] tmpArray = null;
            if (index < numArray1.length) tmpArray = numArray1;
            if (index < numArray2.length) tmpArray = numArray2;
            if (tmpArray != null) {
                for (int j = index; j < tmpArray.length; j++) {
                    if (delta != 0){
                        Integer tmp = Integer.parseInt(String.valueOf(tmpArray[j])) + delta;
                        if (tmp > 9){
                            tmp = tmp - 10;
                            delta = 1;
                        }else {
                            delta = 0;
                        }
                        builder.append(tmp.toString());
                    }else {
                        builder.append(tmpArray[j]);
                    }
                }
            }
            if (delta == 1){

                builder.append("1");
            }
            char[] resultArray = builder.toString().toCharArray();
            result = new ListNode(Integer.parseInt(String.valueOf(resultArray[0])));
            ListNode node = result;
            for (int i = 1; i < resultArray.length; i++) {

                Integer value = Integer.parseInt(String.valueOf(resultArray[i]));

                node.next = new ListNode(value);
                node = node.next;
            }
        } catch (NumberFormatException e) {

            e.getStackTrace();
        }
        return result;
    }

    /**
     * The method create array with chars from list node's with numbers
     *
     * @param listNode   list node with number
     * @return           result array with number's chars
     */
    private char[] createNumArray(ListNode listNode){

        if (listNode != null) {
            StringBuilder input = new StringBuilder();
            ListNode node = listNode;
            while (node.next != null) {

                input.append(node.val);
                node = node.next;
            }
            input.append(node.val);

            return input.toString().toCharArray();
        }else return null;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode root = null;
        ListNode tmp = null;
        int sum;
        int delta = 0;

        while (l1 != null && l2 != null){
            sum = l1.val + l2.val + delta;
            delta = 0;
            if (sum > 9){
                delta = sum/10;
                sum %= 10;
            }
            if (root == null){
                root = new ListNode(sum);
                tmp = root;
            }else {
                tmp.next = new ListNode(sum);
                tmp = tmp.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null && l2 == null){
            if (delta != 0){
                tmp.next = new ListNode(delta);
            }
            return root;
        }

        ListNode node = l1 != null ? l1 : l2;

        while (delta != 0) {
            if (node == null){
                tmp.next = new ListNode(delta);
                tmp = tmp.next;
                break;
            }
            sum = node.val + delta;
            delta = 0;
            if (sum > 9) {
                delta = sum / 10;
                sum %= 10;
            }
            tmp.next = new ListNode(sum);
            tmp = tmp.next;
            node = node.next;
        }

        tmp.next = node;
        return root;

    }

    @Test
    public void test(){

        ListNode root1 = new ListNode(1);
        ListNode root2 = new ListNode(9);
        root2.next = new ListNode(9);
        Assert.assertNotNull(addTwoNumbers(root1, root2));

    }
}





