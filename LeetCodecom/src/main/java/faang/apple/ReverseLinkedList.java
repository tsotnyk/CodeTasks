package faang.apple;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode newHead = null;
        ListNode nextNode;

        while (head != null){

            nextNode = head;
            head = head.next;
            nextNode.next = newHead;
            newHead = nextNode;
        }

        return newHead;
    }
}
