package chapter4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstCommonAncestor {

    public MyTree firstCommonAncestor(MyTree node1, MyTree node2, MyTree root){

        FindObject result = findNodes(node1, node2, root);
        return result.getNode();
    }

    private FindObject findNodes(MyTree node1, MyTree node2, MyTree root){

        FindObject object = new FindObject();
        if (root == null) return object;
        if (root.equals(node1)) object.first = true;
        if (root.equals(node2)) object.second = true;

        FindObject left = findNodes(node1, node2, root.left);

        if (left.node != null) return left;

        checkAncestor(object, left, root);

        FindObject right = findNodes(node1, node2, root.right);

        if (right.node != null) return right;

        return checkAncestor(object, right, root);

    }

    private FindObject checkAncestor(FindObject base, FindObject child, MyTree root){

        if (!base.first) base.first = child.first;
        if (!base.second) base.second = child.second;

        if (base.first && base.second){
            base.node = root;
        }

        return base;
    }

    @Test
    public void test(){

        MyTree a = new MyTree(1);
        MyTree b = new MyTree(2);
        MyTree c = new MyTree(3);
        MyTree d = new MyTree(4);
        MyTree e = new MyTree(5);
        MyTree f = new MyTree(6);
        MyTree g = new MyTree(7);
        MyTree h = new MyTree(8);
        MyTree i = new MyTree(9);

        a.left = b;
        a.right = c;
        a.left.left= d;
        a.left.right = e;
        a.left.right.left = f;
        a.right.left = g;
        a.right.right = h;
        a.right.left.right = i;

        Assert.assertEquals(b, firstCommonAncestor(d, f, a));
        Assert.assertEquals(a, firstCommonAncestor(f, i, a));
        Assert.assertNull(firstCommonAncestor(a, c, a));
    }
}

class FindObject{

    boolean first;
    boolean second;
    MyTree node;

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isSecond() {
        return second;
    }

    public void setSecond(boolean second) {
        this.second = second;
    }

    public MyTree getNode() {
        return node;
    }

    public void setNode(MyTree node) {
        this.node = node;
    }

    public FindObject() {
        this.first = false;
        this.second = false;
    }
}
