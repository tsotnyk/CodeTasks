package chapter2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Intersection {

    public NodeSingleList intersection(NodeSingleList first, NodeSingleList second){

        if (first == null || second == null) throw new IllegalArgumentException();
        int lengthF = size(first);
        int lengthS = size(second);

        NodeSingleList longest = lengthF >= lengthS ? first : second;
        NodeSingleList shortest = lengthF >= lengthS ? second : first;
        int diff = Math.abs(lengthF - lengthS);
        while (diff-- > 0){
            longest = longest.next;
        }

        while (longest != shortest){
            longest = longest.next;
            shortest = shortest.next;
        }

        return longest;
    }

    public int size(NodeSingleList node){

        int sizeList = 1;
        while (node.next != null){
            sizeList++;
            node = node.next;
        }
        return sizeList;
    }

    @Test
    public void test(){

        NodeSingleList a = new NodeSingleList(1);
        NodeSingleList b = new NodeSingleList(2);
        NodeSingleList c = new NodeSingleList(3);
        NodeSingleList d = new NodeSingleList(4);
        NodeSingleList e = new NodeSingleList(5);
        NodeSingleList f = new NodeSingleList(6);
        NodeSingleList g = new NodeSingleList(7);
        NodeSingleList h = new NodeSingleList(8);
        NodeSingleList i = new NodeSingleList(9);
        NodeSingleList j = new NodeSingleList(10);
        NodeSingleList k = new NodeSingleList(11);
        NodeSingleList l = new NodeSingleList(12);

        NodeSingleList list1 = a;
        list1.next = b;
        list1.next.next = c;
        list1.next.next.next = d;
        list1.next.next.next.next = e;
        list1.next.next.next.next.next = f;
        list1.next.next.next.next.next.next = g;
        list1.next.next.next.next.next.next.next = h;
        list1.next.next.next.next.next.next.next.next = i;

        NodeSingleList list2 = j;
        list2.next = k;
        list2.next.next = l;
//        list2.next.next.next = a;

        Assert.assertEquals(null, intersection(list1, list2));
    }
}
