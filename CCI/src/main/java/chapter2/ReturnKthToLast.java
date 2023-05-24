package chapter2;

import org.testng.annotations.Test;

public class ReturnKthToLast {

    public NodeSingleList returnKthToLast(NodeSingleList node, int k){

        NodeSingleList kThNode = node;

        while (node != null && k-- > 0){
            node = node.next;
        }

        if (k > 0) return null;

        while (node != null){
            node = node.next;
            kThNode = kThNode.next;
        }

        return kThNode;
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

        NodeSingleList result = returnKthToLast(list, 3);

        System.out.println(result.value);

    }
}
