package prepInterviewWithEducativeIo.twoPointers;

import org.testng.annotations.Test;

public class RemoveNthNodeFromEndOfList {

    public static ListNode removeNthLastNode(ListNode head, int n) {

        ListNode right = head;

        while (right != null && n > 0){
            right = right.next;
            n--;
        }

        if (right == null) return head.next;

        ListNode left = head;
        while (right.next != null){
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return head;
    }

    @Test
    public void test(){

//        ListNode head = new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(40, new ListNode(50, new ListNode(60))))));
//
//        ListNode res = removeNthLastNode(head, 6);

        ListNode head1 = new ListNode(12, new ListNode(15, new ListNode(13, new ListNode(16, new ListNode(17, new ListNode(14))))));
        ListNode res1 = removeNthLastNode(head1, 5);

        System.out.println("*");
    }
}

