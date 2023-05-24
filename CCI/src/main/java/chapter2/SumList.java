package chapter2;

import org.testng.annotations.Test;

public class SumList {

    public NodeSingleList sumLists(NodeSingleList first, NodeSingleList second){

        if (first == null) return second;
        if (second == null) return first;
        int next = 0;
        first = reverse(first);
        second = reverse(second);

        NodeSingleList result = null;
        NodeSingleList current = null;

        while (first != null && second != null){

            int sum = first.value + second.value + next;
            if (sum > 9){
                next = sum/10;
                sum = sum%10;
            }
            if (result == null){
                result = new NodeSingleList(sum);
                current = result;
            }else {
                current.next = new NodeSingleList(sum);
                current = current.next;
            }
            first = first.next;
            second = second.next;
        }

        if (first != null || second != null){
            first = first == null ? second : first;

            while (first != null){
                int sum = first.value + next;
                if (sum > 9){
                    next = sum/10;
                    sum = sum%10;
                }
                current.next  = new NodeSingleList(sum);
                current = current.next;
                first = first.next;
            }
        }

        if (next > 0){
            current.next = new NodeSingleList(next);
        }

        return reverse(result);
    }

    public NodeSingleList reverse(NodeSingleList head){

        NodeSingleList newHead = head;
        head = head.next;
        newHead.next = null;

        while (head != null){
            NodeSingleList next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }

    @Test
    public void test(){

        NodeSingleList list = new NodeSingleList(3);
        list.next = new NodeSingleList(5);
        list.next.next = new NodeSingleList(8);
        list.next.next.next = new NodeSingleList(5);
        list.next.next.next.next = new NodeSingleList(10);
        list.next.next.next.next.next = new NodeSingleList(2);
        list.next.next.next.next.next.next = new NodeSingleList(1);

        NodeSingleList print = reverse(list);
        while (print != null){
            System.out.println(print.value);
            print = print.next;
        }

        System.out.println("**************");

        NodeSingleList list1 = new NodeSingleList(3);
        list1.next = new NodeSingleList(5);
        list1.next.next = new NodeSingleList(8);


        NodeSingleList list2 = new NodeSingleList(9);
        list2.next = new NodeSingleList(6);
        list2.next.next = new NodeSingleList(8);
        list2.next.next.next = new NodeSingleList(5);

        print = sumLists(list1, list2);

        while (print != null){
            System.out.println(print.value);
            print = print.next;
        }

    }
}
