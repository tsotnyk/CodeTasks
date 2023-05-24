package chapter2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoopDetection {

    public boolean loopDetection(NodeSingleList node){

        if (node == null) throw new IllegalArgumentException();

        NodeSingleList fast = node;
        NodeSingleList slow = node;

        while (slow.next != null && fast.next.next != null){
            if (slow.next == fast.next.next) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    @Test
    public void test(){

        NodeSingleList a = new NodeSingleList(1);
        NodeSingleList b = new NodeSingleList(2);
        NodeSingleList c = new NodeSingleList(3);
        NodeSingleList d = new NodeSingleList(3);
        NodeSingleList e = new NodeSingleList(3);
        NodeSingleList f = new NodeSingleList(3);
        NodeSingleList g = new NodeSingleList(3);
        NodeSingleList h = new NodeSingleList(3);
        NodeSingleList i = new NodeSingleList(3);

        NodeSingleList list1 = a;
        list1.next = b;
        list1.next.next = c;
        list1.next.next.next = d;
        list1.next.next.next.next = e;
        list1.next.next.next.next.next = f;
        list1.next.next.next.next.next.next = g;
        list1.next.next.next.next.next.next.next = h;
        list1.next.next.next.next.next.next.next.next = i;
        list1.next.next.next.next.next.next.next.next.next = d;

        Assert.assertTrue(loopDetection(list1));

    }
}
