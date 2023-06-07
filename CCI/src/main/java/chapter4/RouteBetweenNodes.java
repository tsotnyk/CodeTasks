package chapter4;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class RouteBetweenNodes {

    public boolean searchRoute(MyDirectedNode first, MyDirectedNode second){

        HashSet<MyDirectedNode> visited = new HashSet<>();

        LinkedList<MyDirectedNode> tasks = new LinkedList<>(Collections.singleton(first));

        while (!tasks.isEmpty()){

            MyDirectedNode node = tasks.removeFirst();
            if (visited.contains(node)) continue;
            if (node.equals(second)) return true;
            tasks.addAll(node.children);
            visited.add(node);
        }
        return false;
    }

    @Test
    public void test(){
        MyDirectedNode a = new MyDirectedNode(1);
        MyDirectedNode b = new MyDirectedNode(2);
        MyDirectedNode c = new MyDirectedNode(3);
        MyDirectedNode f = new MyDirectedNode(4);
        MyDirectedNode j = new MyDirectedNode(5);

        List<MyDirectedNode> cA = new LinkedList<>();
        cA.add(b);
        cA.add(f);
        cA.add(c);
        a.setChildren(cA);
        List<MyDirectedNode> cB = new LinkedList<>();
        cB.add(c);
        cB.add(a);
        cB.add(f);
        b.setChildren(cB);
        List<MyDirectedNode> cC = new LinkedList<>();
        cC.add(j);
        c.setChildren(cC);
        List<MyDirectedNode> cF = new LinkedList<>();
        cF.add(j);
        f.setChildren(cF);

        Assert.assertTrue(searchRoute(a, j));
        Assert.assertFalse(searchRoute(c, a));
    }
}
