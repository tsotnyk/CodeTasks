package com.j2core.sts.leetcode.com.trees.allElementsInTwoBinarySearchTrees;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public List<Integer> getAllElements1(TreeNode root1, TreeNode root2) {

        List<Integer> result = new LinkedList<>();

        traversTree(root1, result);
        traversTree(root2, result);

        Collections.sort(result);
        return result;
    }

    private void traversTree(TreeNode root, List<Integer> list){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || stack.size() > 0) {
            while (root !=  null)
            {
                stack.push(root);
                root = root.left;
            }

            /* Current must be NULL at this point */
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> result = new LinkedList<>();

        while (root1 != null || !stack1.isEmpty() || root2 != null || !stack2.isEmpty()) {
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }
            TreeNode root;

            if (stack1.isEmpty()) {
                root = stack2.pop();
                root2 = root.right;
            } else if (stack2.isEmpty()) {
                root = stack1.pop();
                root1 = root.right;
            } else {
                if (stack1.peek().val < stack2.peek().val) {
                    root = stack1.pop();
                    root1 = root.right;
                } else {
                    root = stack2.pop();
                    root2 = root.right;
                }
            }
            result.add(root.val);

        }
        return result;
    }

    public List<Integer> getAllElementsBest(TreeNode root1, TreeNode root2) {

        ArrayList<Integer> firstTree = new ArrayList<>();
        ArrayList<Integer> secondTree = new ArrayList<>();

        inOrderTraversalTree(root1, firstTree);
        inOrderTraversalTree(root2, secondTree);

        List<Integer> mergedTree = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;

        while (index1 < firstTree.size() && index2 < secondTree.size()){
            if (firstTree.get(index1) < secondTree.get(index2)){
                mergedTree.add(firstTree.get(index1++));
            }else {
                mergedTree.add(secondTree.get(index2++));
            }
        }

        if (index1 < firstTree.size()){
            mergedTree.addAll(firstTree.subList(index1, firstTree.size()));
        }else {
            mergedTree.addAll(secondTree.subList(index2, secondTree.size()));
        }

        return mergedTree;
    }

    private void inOrderTraversalTree(TreeNode root, ArrayList<Integer> result){

        if (root != null){
            inOrderTraversalTree(root.left, result);
            result.add(root.val);
            inOrderTraversalTree(root.right, result);
        }
    }

    @Test
    public void test(){

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);

        Assert.assertEquals(getAllElements(root1, root2), new LinkedList<>(Arrays.asList(0,1,1,2,3,4)));

        HashMap<Integer, Integer> map = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet());
    }

}
