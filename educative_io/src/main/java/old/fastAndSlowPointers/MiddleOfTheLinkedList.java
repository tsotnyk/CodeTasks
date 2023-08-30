package old.fastAndSlowPointers;

public class MiddleOfTheLinkedList {

    public static LLN middleNode(LLN head) {

        // Your code will replace this placeholder return statement
        return head;
    }
}

class LL<T> {
    public LLN head;
    // constructor will be used to make a LinkedList type object
    public LL() {
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


}

class LLN {
    public int data;
    public LLN next;
    // Constructor will be used to make a LinkedListNode type object
    public LLN(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListReversal{
    static LLN reverseLinkedList(LLN node){
        LLN prev = null;
        LLN current = node;
        LLN next = null;

        while (current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}

class LinkedListTraversal{
    static void traverseLinkedList(LLN head){
        LLN temp = head;
        while (temp != null) {
            System.out.print(temp.data); // print node value
            temp = temp.next;
        }
    }
}
