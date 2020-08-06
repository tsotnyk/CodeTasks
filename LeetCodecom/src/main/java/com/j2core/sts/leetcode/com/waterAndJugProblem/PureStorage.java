package com.j2core.sts.leetcode.com.waterAndJugProblem;

import org.testng.annotations.Test;

import java.util.List;

public class PureStorage {

    public static int countPairs(List<Integer> array, int diff) {
        /* Returns the number of pairs in array that differ by diff.
        See problem statement for description of algorithm.
        array: list of unique integers
        diff: integer, the targeted difference
        return: number of pairs realizing the difference */

        int pairs = 0;

        if (array == null && array.size() < 2){
            return pairs;
        }

        for(int i = 0; i < array.size()-1; i++){
            for (int j = i+1; j < array.size(); j++){
                if (Math.abs(array.get(i)-array.get(j)) == diff){
                    pairs++;
                }
            }
        }
        return pairs;
    }

    static LinkedListNode removeAll(int n, LinkedListNode head){

        while (head != null && head.val == n){
            head = head.next;
        }

        if (head != null){
            LinkedListNode node = head;
            while (node.next != null){
                if (node.next.val == n){
                    node.next = node.next.next;
                }else {
                    node = node.next;
                }
            }
        }
        return head;
    }

    @Test
    public void test(){

        LinkedListNode root = new LinkedListNode(1);
        root.next = new LinkedListNode(3);
        root.next.next = new LinkedListNode(2);
        root.next.next.next = new LinkedListNode(3);
        root.next.next.next.next = new LinkedListNode(3);

        LinkedListNode node = removeAll(3, root);

        System.out.println(node.val);

    }
}

  class  LinkedListNode {
        int val;
        LinkedListNode next;

        public LinkedListNode(int val){
            this.val = val;
        }
    }
