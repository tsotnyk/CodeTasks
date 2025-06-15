package prepInterviewApple;

import org.testng.annotations.Test;


public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null) return null;
        if (lists.length < 1) return null;
        if (lists.length == 1) return lists[0];
        ListNode head = lists[0];

        for (int i = 1; i < lists.length; i++){
            head = mergeTwoLists(head, lists[i]);
        }

        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){

        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null;
        ListNode next = null;

        while (l1 != null && l2 != null){

            if (l1.val < l2.val){
                if (head == null){
                    head = new ListNode(l1.val);
                    next = head;
                }else {
                    next.next = new ListNode(l1.val);
                    next = next.next;
                }

                l1 = l1.next;
            }else {
                if (head == null){
                    head = new ListNode(l2.val);
                    next = head;
                }else {
                    next.next = new ListNode(l2.val);
                    next = next.next;
                }

                l2 = l2.next;
            }

        }

        if (l1 != null) next.next = l1;
        if (l2 != null) next.next = l2;

        return head;
    }

    @Test
    public void test(){

        ListNode result = mergeKLists(new ListNode[]{new ListNode(1, new ListNode(4, new ListNode(5))), new ListNode(1, new ListNode(3, new ListNode(4))),
        new ListNode(2, new ListNode(6))});

        System.out.println(result.val);
    }
}
