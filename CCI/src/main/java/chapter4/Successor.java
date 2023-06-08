package chapter4;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class Successor {

    public MyParentTree nextNode(MyParentTree node){

        if (node == null) return null;
        if (node.right != null){
            return getLeftest(node.right);
        }
        MyParentTree current = node;
        while (current.parent != null && current.equals(current.parent.right)){
            current = current.parent;
        }
        return current.parent;
    }

    private MyParentTree getLeftest(MyParentTree node){
        if (node == null) return null;
        MyParentTree result = node;
        while (result.left != null){
            result = result.left;
        }
        return result;
    }

    @Test
    public void test(){

        MyParentTree root = new MyParentTree(1);
        MyParentTree b = new MyParentTree(2);
        MyParentTree c = new MyParentTree(3);
        MyParentTree d = new MyParentTree(4);
        MyParentTree e = new MyParentTree(5);
        MyParentTree f = new MyParentTree(6);
        MyParentTree g = new MyParentTree(7);
        MyParentTree h = new MyParentTree(8);
        MyParentTree i = new MyParentTree(9);
        MyParentTree j = new MyParentTree(10);

        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        b.parent = root;
        d.left = h;
        d.parent = b;
        e.left = i;
        e.parent = b;
        c.left = f;
        c.right = g;
        c.parent = root;
        f.left = j;
        f.parent = c;
        h.parent = d;
        i.parent = e;
        j.parent = f;
        g.parent = c;

        MyParentTree result1 = nextNode(h);
        MyParentTree result2 = nextNode(b);
        MyParentTree result3 = nextNode(g);
        MyParentTree result4 = nextNode(e);

        Assert.assertEquals(result1.value, 4);
        Assert.assertEquals(result2.value, 9);
        Assert.assertEquals(result4.value, 1);
        Assert.assertNull(result3);
    }
}

class MyParentTree{

    int value;
    MyParentTree parent;
    MyParentTree left;
    MyParentTree right;

    public MyParentTree(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyParentTree that = (MyParentTree) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
