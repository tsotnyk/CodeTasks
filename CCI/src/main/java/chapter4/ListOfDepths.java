package chapter4;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepths {

    public List<List<MyTree>> createListOfDepthNodes(MyTree root){

        List<List<MyTree>> result = new LinkedList<>();

        List<MyTree> current = new LinkedList<>(Collections.singletonList(root));

        while (!current.isEmpty()){

            List<MyTree> next = new LinkedList<>();

            for (MyTree node : current){
                if (node.left != null){
                    next.add(node.left);
                }
                if (node.right != null){
                    next.add(node.right);
                }
            }
            result.add(current);
            current = next;
        }

        return result;
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
        root.left.left.left = new MyTree(8);
        root.left.right.left = new MyTree(9);
        root.right.left.left = new MyTree(10);

        List<List<MyTree>> result = createListOfDepthNodes(root);

        Assert.assertEquals(result.size(), 4);
    }
}
