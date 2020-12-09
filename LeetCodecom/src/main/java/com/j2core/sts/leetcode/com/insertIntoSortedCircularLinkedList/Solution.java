package com.j2core.sts.leetcode.com.insertIntoSortedCircularLinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public Node insert(Node head, int insertVal) {

        Node newNode = new Node(insertVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node tmpHead = head;
//        if (tmpHead.val == tmpHead.next.val) {
//            tmpHead.next = newNode;
//            newNode.next = tmpHead;
//            return tmpHead;
//        }

        while (true) {
            if (tmpHead.val > tmpHead.next.val && (tmpHead.val <= insertVal || tmpHead.next.val >= insertVal) ||
                    (tmpHead.val <= insertVal && insertVal <= tmpHead.next.val) || tmpHead.next == head) {
                break;
            }
            tmpHead = tmpHead.next;
        }

        newNode.next = tmpHead.next;
        tmpHead.next = newNode;

        return head;
    }

    @Test
    public void test(){

//        Node root8 = new Node(5);
//        root8.next = new Node(1);
//        root8.next.next = new Node(3);
//        root8.next.next.next = root8;
//        Assert.assertEquals(insert(root8, 2).val, 5);
//
//        Node root4 = new Node(1);
//        root4.next = new Node(3);
//        root4.next.next = new Node(5);
//        root4.next.next.next = root4;
//        Assert.assertEquals(insert(root4, 3).val, 1);
//
//        Node root = new Node(1);
//        root.next = new Node(3);
//        root.next.next = new Node(5);
//        root.next.next.next = root;
//        Assert.assertEquals(insert(root, 0).val, 1);
//
//        Node root5 = new Node(1);
//        root5.next = new Node(3);
//        root5.next.next = new Node(5);
//        root5.next.next.next = root;
//        Assert.assertEquals(insert(root5, 6).val, 1);
//
//        Node root7 = new Node(3);
//        root7.next = new Node(5);
//        root7.next.next = new Node(1);
//        root7.next.next.next = root7;
//        Assert.assertEquals(insert(root7, 0).val, 3);
//
//        Node root6 = new Node(3);
//        root6.next = new Node(5);
//        root6.next.next = new Node(1);
//        root6.next.next.next = root6;
//        Assert.assertEquals(insert(root6, 6).val, 3);
//
//                Node root1 = new Node(3);
//        root1.next = new Node(5);
//        root1.next.next = new Node(1);
//        root1.next.next.next = root1;
//        Assert.assertEquals(insert(root1, 2).val, 3);
//
//        Node root2 = new Node(3);
//        root2.next = new Node(4);
//        root2.next.next = new Node(1);
//        root2.next.next.next = root2;
//        Assert.assertEquals(insert(root2, 2).val, 3);
//
//        Node root3 = new Node(3);
//        root3.next = new Node(5);
//        root3.next.next = new Node(1);
//        root3.next.next.next = root3;
//        Assert.assertEquals(insert(root3, 4).val, 3);

                Node root9 = new Node(6);
        root9.next = new Node(6);
        root9.next.next = new Node(7);
        root9.next.next.next = new Node(1);
        root9.next.next.next.next = root9;
        Assert.assertEquals(insert(root9, 5).val, 6);
    }
}
