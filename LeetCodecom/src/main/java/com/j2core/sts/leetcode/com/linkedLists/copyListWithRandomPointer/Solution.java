package com.j2core.sts.leetcode.com.linkedLists.copyListWithRandomPointer;

import java.util.HashMap;

public class Solution {


    public Node copyRandomList(Node head) {

        if (head == null) return null;

        HashMap<Node, Node> mapRandomNode = new HashMap<>();

        Node newRoot = new Node(head.val);
        mapRandomNode.put(head, newRoot);
        Node nextCopy = newRoot;
        Node nextNode = head;

        while (nextNode.next != null){
            nextCopy.next = new Node(nextNode.next.val);
            mapRandomNode.put(nextNode.next, nextCopy.next);
            nextCopy = nextCopy.next;
            nextNode = nextNode.next;
        }

        nextNode = head;
        nextCopy = newRoot;
        while (nextNode != null){
            if (nextNode.random != null){
                nextCopy.random = mapRandomNode.get(nextNode.random);
            }
            nextCopy = nextCopy.next;
            nextNode = nextNode.next;
        }

        return newRoot;
    }


}
