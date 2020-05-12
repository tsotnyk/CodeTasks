package com.j2core.sts.leetcode.com.linkedLists.merge_k_SortedLists;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public ListNode mergeKListsOld(ListNode[] lists) {

        ListNode newList = null;
        ListNode nextNode = null;

        while (!isEmptyArray(lists)){

            int smaller = Integer.MAX_VALUE;
            int index = -1;

            for (int i = 0; i < lists.length; i++) {

                if (lists[i] != null) {

                    if (lists[i].val < smaller) {
                        smaller = lists[i].val;
                        index = i;
                    }
                }
            }

            if (newList == null){
                newList = addListNode(null, lists, index);
            }else if (nextNode == null){
                nextNode = addListNode(newList, lists, index);
            }else {
                nextNode = addListNode(nextNode, lists, index);
            }
        }

        return newList;
    }

    private ListNode addListNode(ListNode head, ListNode[] array, int index){

        ListNode tmp = array[index];
        ListNode tmpHead = tmp.next;
        tmp.next = null;
        array[index] = tmpHead;

        if (head == null){
            return tmp;
        }else {
            head.next = tmp;
            return tmp;
        }

    }

    private boolean isEmptyArray(ListNode[] array){

        for (ListNode node : array){

            if (node != null){
                return false;
            }
        }

        return true;
    }

    public ListNode mergeKLists1(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;
        if (lists.length < 2) return lists[0];
        ListNode base = lists[0];

        for (int i = 1; i < lists.length; i++){
            base = mergeSortListNode(base, lists[i]);
        }

        return base;
    }

    private ListNode mergeSortListNode(ListNode first, ListNode second){

        ListNode result = null;
        ListNode tmpHead = null;
        ListNode tmp;

        while (first != null && second != null){
            if (first.val <= second.val){
                tmp = first;
                first = first.next;
            }else {
                tmp = second;
                second = second.next;
            }
            tmp.next = null;
            if (result == null){
                result = tmp;
                tmpHead = tmp;
            }else {
                tmpHead.next = tmp;
                tmpHead = tmpHead.next;
            }
        }

        if (result == null){
            result = first == null ? second : first;
        }else {
            if (first != null){
                tmpHead.next = first;
            }
            if (second != null){
                tmpHead.next = second;
            }
        }

        return result;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;
        if (lists.length < 2) return lists[0];

        TreeMap<Integer, Integer> valueMap =  createNodeMap(lists);
        ListNode root = null;
        ListNode head = null;

        for (Map.Entry<Integer, Integer> entry : valueMap.entrySet()){
            int val = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++){
                if (root == null){
                    root = new ListNode(val);
                    head = root;
                }else {
                    head.next = new ListNode(val);
                    head = head.next;
                }
            }
        }

        return root;
    }

    private TreeMap<Integer, Integer> createNodeMap(ListNode[] listNodes){

        HashMap<Integer, Integer> map = new HashMap<>();

        for (ListNode node : listNodes){

            while (node != null){
                map.put(node.val, map.getOrDefault(node.val, 0)+1);
                node = node.next;
            }
        }

        return new TreeMap<>(map);
    }

    @Test
    public void test(){

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);
        node3.next.next = new ListNode(7);

        ListNode[] array = new ListNode[]{node1, node2, node3};

        ListNode result = mergeKLists(array);
        ListNode first = mergeKLists(new ListNode[]{});

    }
}
