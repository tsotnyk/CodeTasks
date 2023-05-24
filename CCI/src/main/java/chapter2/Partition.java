package chapter2;

import org.testng.annotations.Test;

public class Partition {

    public NodeSingleList partition(NodeSingleList head, int partition){

        NodeSingleList headLess = null;
        NodeSingleList headBig = null;
        NodeSingleList cLess =  null;
        NodeSingleList cBig = null;

        NodeSingleList currentHead = head;

        while (currentHead != null){
            NodeSingleList current = currentHead;
            currentHead = currentHead.next;
            current.next = null;

            if (current.value < partition){
                if (headLess == null){
                    headLess = current;
                    cLess = current;
                }else {
                    cLess.next = current;
                    cLess = cLess.next;
                }
            }else {
                if (headBig == null){
                    headBig = current;
                    cBig = current;
                }else {
                    cBig.next = current;
                    cBig = cBig.next;
                }
            }
        }

        if (cLess == null) return headBig;

        cLess.next = headBig;

        return headLess;
    }

    public NodeSingleList bookSolution(NodeSingleList node, int partition){

        NodeSingleList head = node;
        NodeSingleList tail = node;

        while (node != null){
            NodeSingleList next = node.next;
            if (node.value < partition){
                node.next = head;
                head = node;
            }else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }

        tail.next = null;

        return head;
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

//        NodeSingleList print = partition(list, 5
//        );

        NodeSingleList print = bookSolution(list, 5);
        while (print != null){
            System.out.println(print.value);
            print = print.next;
        }
    }
}
