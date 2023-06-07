package chapter4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBalanced {


    public boolean isBalanced(MyTree root){

        return depth(root) > -1;
    }

    public int depth(MyTree root){

        if (root == null) return 0;

        int depthL = depth(root.left);
        if (depthL < 0) return -1;
        int depthR = depth(root.right);
        if (depthR < 0) return -1;
        if (Math.abs(depthL-depthR) > 1) return -1;

        return Math.max(depthL, depthR)+1;
    }

    @Test
    public void test(){

        MyTree root = new MyTree(1);
        root.left = new MyTree(2);
        root.right = new MyTree(3);
        root.left.left = new MyTree(4);
        root.left.right = new MyTree(5);
        root.right.left = new MyTree(6);
        root.right.right = new MyTree(7);
        root.right.left.left = new MyTree(10);
        root.left.left.left = new MyTree(8);
        root.left.right.left = new MyTree(9);

        Assert.assertTrue(isBalanced(root));

        root.right.left.left.left = new MyTree(11);

        Assert.assertFalse(isBalanced(root));

    }

}
