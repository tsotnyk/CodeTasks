package chapter2;

import org.testng.annotations.Test;

public class DeleteMiddleNode {

    public void deleteMiddleNode(NodeSingleList head, int index){

        NodeSingleList prev = head;
        NodeSingleList next = head.next.next;

        while (index-- > 2){
            prev = prev.next;
            next = next.next;
        }

        prev.next = next;
    }

    @Test
    public void test(){

        NodeSingleList list = new NodeSingleList(1);
        list.next = new NodeSingleList(2);
        list.next.next = new NodeSingleList(3);
        list.next.next.next = new NodeSingleList(4);
        list.next.next.next.next = new NodeSingleList(5);
        list.next.next.next.next.next = new NodeSingleList(6);
        list.next.next.next.next.next.next = new NodeSingleList(7);

        deleteMiddleNode(list, 4);

        NodeSingleList print = list;
        while (print != null){
            System.out.println(print.value);
            print = print.next;
        }

        deleteNode(list.next.next);
        print = list;
        while (print != null){
            System.out.println(print.value);
            print = print.next;
        }
    }

    public void deleteNode(NodeSingleList node){

        NodeSingleList nextNode = node.next;

        node.value = nextNode.value;
        node.next = nextNode.next;

    }
}
