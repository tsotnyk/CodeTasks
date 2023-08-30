package fastAndSlowPointers;

public class LinkedListCycle {

    public static boolean detectCycle(LinkedListNode head) {

        LinkedListNode slow = head;
        LinkedListNode fast = head.next;

        while (fast != null && fast.next != null){
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
    
}

class LinkedListNode {
    public int data;
    public LinkedListNode next;
    // Constructor will be used to make a LinkedListNode type object
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
