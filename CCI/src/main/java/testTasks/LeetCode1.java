package testTasks;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class LeetCode1 {
    public int maximumWealth(int[][] accounts) {

        int max = Integer.MIN_VALUE;
        for (int[] customer : accounts){
            int curCustomer = 0;

            for (int amount : customer){
                curCustomer += amount;
            }
            max = Math.max(max, curCustomer);
        }

        return max;
    }

    public Node findRoot(List<Node> tree) {

        Node root = tree.remove(0);
        tree.remove(0);

        LinkedList<Node> tasks = new LinkedList<>();
        List<Node> children = new LinkedList<>();
        Node curTask = root;
        for (Node node : tree){
            if (node == null){
                tasks.addAll(children);
                curTask.children = children;
                children = new LinkedList<>();
                curTask = tasks.removeFirst();
            }else {
                children.add(node);
            }
        }

        curTask.children = children;

        return root;

    }

    @Test
    public void test(){

        List<Node> tree = new LinkedList<>(Arrays.asList(new Node(1), null, new Node(3), new Node(2), new Node(4), null, new Node(5),new Node(6)));

        Node root = findRoot(tree);

        Assert.assertEquals(root.val, 1);

    }

}

class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return val == node.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
