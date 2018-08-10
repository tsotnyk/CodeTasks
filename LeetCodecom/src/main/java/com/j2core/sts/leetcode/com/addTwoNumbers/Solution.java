package com.j2core.sts.leetcode.com.addTwoNumbers;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

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

}





