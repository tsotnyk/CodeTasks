package prepInterviewApple;

import org.testng.annotations.Test;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int nextPos = 0;

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = null;
        ListNode nextNode = null;
        int sum;
        int n1;
        int n2;

        while (l1 != null && l2 != null){

            n1 = l1.val;
            l1 = l1.next;
            n2 = l2.val;
            l2 = l2.next;
            sum = n1 + n2 + nextPos;
            nextPos = 0;
            if (sum > 9){
                nextPos = 1;
                sum = sum%10;
            }
            ListNode candidate = new ListNode(sum);
            if (result == null){
                result = candidate;
                nextNode = candidate;
                continue;
            }

            nextNode.next = candidate;
            nextNode = nextNode.next;
        }

        if (l1 != null){
            addNumber(l1, nextNode, nextPos);
            nextPos = 0;
        }else if(l2 != null){
            addNumber(l2, nextNode, nextPos);
            nextPos = 0;
        }

        if (nextPos != 0){

            nextNode.next = new ListNode(nextPos);
        }

        return result;
    }

    public void addNumber(ListNode base, ListNode nextNode, int nextPos){

        while (base != null){

            int sum = base.val + nextPos;
            base = base.next;
            nextPos = 0;
            if (sum > 9){
                nextPos = 1;
                sum = sum%10;
            }

            nextNode.next = new ListNode(sum);
            nextNode = nextNode.next;
        }

        if (nextPos > 0){
            nextNode.next = new ListNode(nextPos);
        }
    }


    @Test
    public void test(){

//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
//
//        ListNode result = addTwoNumbers(l1, l2);
//
//        System.out.println(result.val);

        ListNode l12 = new ListNode(5);
        ListNode l22 = new ListNode(5);

        ListNode result2 = addTwoNumbers(l12, l22);

        System.out.println(result2.val);

        ListNode l13 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l23 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        ListNode result3 = addTwoNumbers(l13, l23);

        System.out.println(result3.val);
    }
}
