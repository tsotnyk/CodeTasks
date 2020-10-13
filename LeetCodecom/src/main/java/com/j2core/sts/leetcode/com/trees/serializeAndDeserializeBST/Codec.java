package com.j2core.sts.leetcode.com.trees.serializeAndDeserializeBST;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.annotations.Test;

import java.util.Stack;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) return null;

        StringBuilder builder = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode current = stack.pop();
            if (builder.length() > 0){
                builder.append(",");
            }
            builder.append(current.val);
            if (current.right != null){
                stack.push(current.right);
            }
            if (current.left != null){
                stack.push(current.left);
            }
        }

        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null) return null;
        String[] numbersArray = data.split(",");

        if (numbersArray.length < 1) return null;
        int[] numbers = new int[numbersArray.length];

        for (int i = 0; i < numbersArray.length; i++){
            numbers[i] = Integer.parseInt(numbersArray[i]);
        }
        int index = 0;
        TreeNode root = new TreeNode(numbers[index++]);
        TreeNode currentNode = root;
        Stack<TreeNode> stack = new Stack<>();

        while (index < numbers.length){
            if (currentNode.val > numbers[index]) {
                if (currentNode.left == null) {
                    currentNode.left = new TreeNode(numbers[index++]);
                }else {
                    stack.push(currentNode);
                    currentNode = currentNode.left;
                }
            }else {
                if (stack.isEmpty()){
                    currentNode.right = new TreeNode(numbers[index++]);
                    currentNode = currentNode.right;
                }else if (numbers[index] < stack.peek().val){
                    if (currentNode.right == null){
                        currentNode.right = new TreeNode(numbers[index++]);
                    }else {
                        stack.push(currentNode);
                        currentNode = currentNode.right;
                    }
                }else {
                    currentNode = stack.pop();
                }
            }
        }
        return root;
    }

    @Test
    public void test(){

//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(1);
//        root.left.left = new TreeNode(0);
//        root.left.right = new TreeNode(2);
//        root.right = new TreeNode(5);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(6);
//        root.right.right.right = new TreeNode(8);

//        TreeNode root1 = new TreeNode(41);
//        root1.left = new TreeNode(37);
//        root1.right= new TreeNode(44);
//        root1.left.left = new TreeNode(24);
//        root1.left.right = new TreeNode(39);
//        root1.right.left = new TreeNode(42);
//        root1.right.right = new TreeNode(48);
//        root1.left.left.left = new TreeNode(1);
//        root1.left.left.right = new TreeNode(35);
//        root1.left.right.left = new TreeNode(38);
//        root1.left.right.right = new TreeNode(40);
//        root1.right.left.left = null;
//        root1.right.left.right = new TreeNode(43);
//        root1.right.right.left = new TreeNode(46);
//        root1.right.right.right = new TreeNode(49);
//
//        root1.left.left.left.left = new TreeNode(0);
//        root1.left.left.left.right = new TreeNode(2);
//        root1.left.left.right.left = new TreeNode(30);
//        root1.left.left.right.right = new TreeNode(36);
//        root1.left.right.left.left = null;
//        root1.left.right.left.right = null;
//        root1.left.right.right.left = null;
//        root1.left.right.right.right = null;
//        root1.right.left.right.left = new TreeNode(45);
//        root1.right.left.right.right = new TreeNode(47);
//        root1.right.right.left.left = null;
//        root1.right.right.left.right = null;
//        root1.right.right.right.left = null;
//        root1.right.right.right.right = null;
//        root1.left.left.left.left.left = null;
//        root1.left.left.left.left.right = new TreeNode(4);
//        root1.left.left.left.right.left = new TreeNode(29);
//        root1.left.left.left.right.right = new TreeNode(32);
//        root1.left.left.right.left.left = null;
//        root1.left.left.right.left.right = null;
//        root1.left.left.right.right.left = null;
//        root1.left.left.right.right.right = null;
//        root1.right.left.right.left.left = null;
//        root1.right.left.right.left.right = null;
//        root1.right.left.right.right.left = new TreeNode(3);
//        root1.right.left.right.right.right = new TreeNode(9);
//        root1.left.left.left.left.right.left = new TreeNode(26);
//        root1.left.left.left.left.right.right = null;
//        root1.left.left.left.right.left.left = new TreeNode(31);
//        root1.left.left.left.right.left.right = new TreeNode(34);
//        root1.left.left.left.right.right.left = null;
//        root1.left.left.left.right.right.right = null;
//        root1.right.left.right.right.left.left = new TreeNode(7);
//        root1.right.left.right.right.left.right = new TreeNode(11);
//        root1.right.left.right.right.right.left = new TreeNode(25);
//        root1.right.left.right.right.right.right = new TreeNode(27);
//
//        root1.left.left.left.left.right.left.left = null;
//        root1.left.left.left.left.right.left.right = null;
//        root1.left.left.left.right.left.left.left = new TreeNode(33);
//        root1.left.left.left.right.left.left.right = null;
//        root1.left.left.left.right.left.right.left = new TreeNode(6);
//        root1.left.left.left.right.left.right.right = new TreeNode(8);
//        root1.right.left.right.right.left.left.left = new TreeNode(10);
//        root1.right.left.right.right.left.left.right = new TreeNode(16);
//        root1.right.left.right.right.left.right.left = null;
//        root1.right.left.right.right.left.right.right = null;
//        root1.right.left.right.right.right.left.left = null;
//        root1.right.left.right.right.right.left.right = new TreeNode(28);
//        root1.right.left.right.right.right.right.left = null;
//        root1.right.left.right.right.right.right.right = null;
//        root1.left.left.left.right.left.left.left.left = new TreeNode(5);
//        root1.left.left.left.right.left.left.left.right = null;
//        root1.left.left.left.right.left.right.left.left = null;
//        root1.left.left.left.right.left.right.left.right = null;
//        root1.left.left.left.right.left.right.right.left = null;
//        root1.left.left.left.right.left.right.right.right = null;
//        root1.right.left.right.right.left.left.left.left = new TreeNode(15);
//        root1.right.left.right.right.left.left.left.right = new TreeNode(19);
//        root1.right.left.right.right.left.left.right.left = null;
//        root1.right.left.right.right.left.left.right.right = null;
//        root1.right.left.right.right.right.left.right.left = null;
//        root1.right.left.right.right.right.left.right.right = null;
//        root1.left.left.left.right.left.left.left.left.left = new TreeNode(12);
//        root1.left.left.left.right.left.left.left.left.right = null;
//        root1.right.left.right.right.left.left.left.left.left = new TreeNode(18);
//        root1.right.left.right.right.left.left.left.left.right = new TreeNode(20);
//        root1.right.left.right.right.left.left.left.right.left = null;
//        root1.right.left.right.right.left.left.left.right.right = new TreeNode(13);
//        root1.left.left.left.right.left.left.left.left.left.left = new TreeNode(17);
//        root1.left.left.left.right.left.left.left.left.left.right = null;
//        root1.right.left.right.right.left.left.left.left.left.left = null;
//        root1.right.left.right.right.left.left.left.left.left.right = new TreeNode(22);
//        root1.right.left.right.right.left.left.left.left.right.left = null;
//        root1.right.left.right.right.left.left.left.left.right.right = new TreeNode(14);
//        root1.right.left.right.right.left.left.left.right.right.left = null;
//        root1.right.left.right.right.left.left.left.right.right.right = null;
//        root1.right.left.right.right.left.left.left.left.left.right.left = new TreeNode(21);
//        root1.right.left.right.right.left.left.left.left.left.right.right = new TreeNode(23);

        TreeNode root = new TreeNode(41);
        root.left = new TreeNode(37);
        root.left.left = new TreeNode(24);
        root.left.left.left = new TreeNode(1);
        root.left.left.left.left = new TreeNode(0);
        root.left.left.left.right = new TreeNode(2);
        root.left.left.left.right.right = new TreeNode(4);
        root.left.left.left.right.right.left = new TreeNode(3);
        root.left.left.left.right.right.right = new TreeNode(9);
        root.left.left.left.right.right.right.left = new TreeNode(7);
        root.left.left.left.right.right.right.left.left = new TreeNode(6);
        root.left.left.left.right.right.right.left.left.left = new TreeNode(5);
        root.left.left.left.right.right.right.left.right = new TreeNode(8);
        root.left.left.left.right.right.right.right = new TreeNode(11);
        root.left.left.left.right.right.right.right.left = new TreeNode(10);
        root.left.left.left.right.right.right.right.right = new TreeNode(16);
        root.left.left.left.right.right.right.right.right.left = new TreeNode(15);
        root.left.left.left.right.right.right.right.right.left.left = new TreeNode(12);
        root.left.left.left.right.right.right.right.right.left.left.right = new TreeNode(13);
        root.left.left.left.right.right.right.right.right.left.left.right.right = new TreeNode(14);
        root.left.left.left.right.right.right.right.right.right = new TreeNode(19);
        root.left.left.left.right.right.right.right.right.right.left = new TreeNode(18);
        root.left.left.left.right.right.right.right.right.right.left.left = new TreeNode(17);
        root.left.left.left.right.right.right.right.right.right.right = new TreeNode(20);
        root.left.left.left.right.right.right.right.right.right.right.right = new TreeNode(22);
        root.left.left.left.right.right.right.right.right.right.right.right.left = new TreeNode(21);
        root.left.left.left.right.right.right.right.right.right.right.right.right = new TreeNode(23);
        root.left.left.right = new TreeNode(35);
        root.left.left.right.left = new TreeNode(30);
        root.left.left.right.left.left = new TreeNode(29);
        root.left.left.right.left.left.left = new TreeNode(26);
        root.left.left.right.left.left.left.left = new TreeNode(25);
        root.left.left.right.left.left.left.right = new TreeNode(27);
        root.left.left.right.left.left.left.right.right = new TreeNode(28);
        root.left.left.right.left.right = new TreeNode(32);
        root.left.left.right.left.right.left = new TreeNode(31);
        root.left.left.right.left.right.right = new TreeNode(34);
        root.left.left.right.left.right.right.left = new TreeNode(33);
        root.left.left.right.right = new TreeNode(36);
        root.left.right = new TreeNode(39);
        root.left.right.left = new TreeNode(38);
        root.left.right.right = new TreeNode(40);
        root.right = new TreeNode(44);
        root.right.left = new TreeNode(42);
        root.right.left.right = new TreeNode(43);
        root.right.right = new TreeNode(48);
        root.right.right.left = new TreeNode(46);
        root.right.right.left.left = new TreeNode(45);
        root.right.right.left.right = new TreeNode(47);
        root.right.right.right = new TreeNode(49);

        String ser = serialize(root);
        String serTreeNode = "3,1,0,2,5,4,6,8";


        TreeNode des = deserialize(ser);

        System.out.println("Ok");
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;