package sts.facebook.codingPractice.linkedList.reverseOperations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    Node reverse(Node head) {
        // Write your code here
        if (head == null) return null;
        if (head.next == null) return head;
        Node root = head;
        if (head.value%2 == 0){
            root = reversEvenNode(head);
        }
        while (head != null && head.next != null){
            if (head.next.value%2 == 0){
                head.next = reversEvenNode(head.next);
            }
            head = head.next;
        }
        return root;
    }

    Node reversEvenNode(Node root){

        Node head = null;
        Node tal = null;
        Node tmp;

        while (root != null && root.value%2 == 0){
            tmp = root;
            root = root.next;
            tmp.next = null;
            if (head == null){
                head = tmp;
                tal = tmp;
            }else {
                tmp.next = head;
                head = tmp;
            }
        }

        if (head == null){
            return root;
        }else {
            if (root != null){
                tal.next = root;
            }
            return head;
        }
    }

    @Test
    public void test(){

        Assert.assertNull(reverse(null));
        Node result1 = reverse(new Node(1));
        Assert.assertTrue(result1.value == 1 && result1.next == null);
        Node root2 = new Node(1);
        root2.next = new Node(2);
        Node result2 = reverse(root2);
        Assert.assertTrue(result2.value == 1 && result2.next.value == 2);
        Node root3 = new Node(4);
        root3.next = new Node(2);
        Node result3 = reverse(root3);
        Assert.assertTrue(result3.value == 2 && result3.next.value == 4);
        Node root4 = new Node(1);
        root4.next = new Node(2);
        root4.next.next = new Node(4);
        Node result4 = reverse(root4);
        Assert.assertTrue(result4.value == 1 && result4.next.value == 4 && result4.next.next.value == 2);
        Node root5 = new Node(1);
        root5.next = new Node(2);
        root5.next.next = new Node(4);
        root5.next.next.next = new Node(5);
        Node result5 = reverse(root5);
        Assert.assertTrue(result5.value == 1 && result5.next.value == 4 && result5.next.next.value == 2 && result5.next.next.next.value == 5);
        Node root6 = new Node(1);
        root6.next = new Node(2);
        root6.next.next = new Node(4);
        root6.next.next.next = new Node(5);
        root6.next.next.next.next = new Node(10);
        root6.next.next.next.next.next = new Node(8);
        Node result6 = reverse(root6);
        Assert.assertTrue(result6.value == 1 && result6.next.value == 4 && result6.next.next.value == 2 && result6.next.next.next.value == 5 &&
                result6.next.next.next.next.value == 8 && result6.next.next.next.next.next.value == 10);
    }
}
