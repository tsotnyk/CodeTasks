package old.fastAndSlowPointers;

public class LinkedListCycle {

    public static boolean detectCycle(LLN head) {
        // Write your code here

        LLN slow = head;
        LLN fast = head.next;

        while (fast != null && fast.next != null){
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}

class LinkedList<T> {
    public LLN head;
    // constructor will be used to make a LinkedList type object
    public LinkedList() {
        this.head = null;
    }
    // insertNodeAtHead method will insert a LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(LLN node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    // createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public void createLinkedList(int[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            LLN newNode = new LLN(lst[i]);
            insertNodeAtHead(newNode);
        }
    }
    // returns the number of nodes in the linked list
    public static LLN getNode(LLN head, int pos){
        LLN ptr = head;
        if (pos != -1){
            int p = 0;

            while (p < pos){
                ptr = ptr.next;
                p += 1;
            }

            return ptr;
        }
        return ptr;
    }
    // returns the node at the specified position(index) of the linked list
    public static int getLength(LLN head)
    {
        LLN temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


}

class LinkedListNode {
    public int data;
    public LLN next;
    // Constructor will be used to make a LinkedListNode type object
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
