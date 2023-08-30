package twoPointers;

import org.testng.annotations.Test;

public class RemoveNthNodeFromEndOfList {

    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {

        // Replace this placeholder return statement with your code

        int counter = 0;

        LinkedListNode last = head;

        while (counter++ < n){
            last = last.next;
        }

        if (last == null) return head.next;

        LinkedListNode next = head;

        while (last.next != null){
            last = last.next;
            next = next.next;
        }

        next.next = next.next.next;

        return head;
    }

    @Test
    public void test(){

        LinkedListNode root = new LinkedListNode(23);
        root.next = new LinkedListNode(28);
        root.next.next = new LinkedListNode(1);
        root.next.next.next = new LinkedListNode(10);
        root.next.next.next.next = new LinkedListNode(5);
        root.next.next.next.next.next = new LinkedListNode(67);
        root.next.next.next.next.next.next = new LinkedListNode(39);
        root.next.next.next.next.next.next.next = new LinkedListNode(70);
        root.next.next.next.next.next.next.next.next = new LinkedListNode(28);

        LinkedListNode head = removeNthLastNode(root, 2);

        System.out.println(head);
    }
}
