package com.j2core.sts.leetcode.com.trees.serializeAndDeserializeBinaryTree;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Codec {

    StringBuilder builder = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) return null;
        LinkedList<TreeNode> list = new LinkedList<>(Arrays.asList(root));
        builder.append(root.val).append(',');
        serialize(list);

        return builder.toString().substring(0, builder.length()-1);
    }

    private void serialize(LinkedList<TreeNode> list){

        LinkedList<TreeNode> nodes = new LinkedList<>();
        while (!list.isEmpty()){

            TreeNode node = list.removeFirst();
                if (node.left != null) {
                    builder.append(node.left.val).append(',');
                    nodes.add(node.left);
                } else {
                    builder.append("null,");
                }
                if (node.right != null) {
                    builder.append(node.right.val).append(',');
                    nodes.add(node.right);
                } else {
                    builder.append("null,");
                }
            }

         if (!nodes.isEmpty()) serialize(nodes);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null) return null;

        String[] array = data.split(",");
        if (array[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        deserialize(array, 1, new LinkedList<>(Arrays.asList(root)));

        return root;
    }

    private void deserialize(String[] values, int index, LinkedList<TreeNode> list){

        LinkedList<TreeNode> nodes = new LinkedList<>();

        while (!list.isEmpty()){
            TreeNode node = list.removeFirst();
            if (!values[index].equals("null")){
                node.left = new TreeNode(Integer.parseInt(values[index++]));
                nodes.add(node.left);
            }else {
                index++;
            }
            if (!values[index].equals("null")){
                node.right = new TreeNode(Integer.parseInt(values[index++]));
                nodes.add(node.right);
            }else {
                index++;
            }
        }

        if (!nodes.isEmpty()) deserialize(values, index, nodes);

    }

    @Test
    public void test(){

        ArrayList<TreeNode> list = new ArrayList<>(Arrays.asList(new TreeNode(1), new TreeNode(2), null, null, new TreeNode(3), new TreeNode(4)));

        int countNull = 0;
        int countNotNull = 0;
        for (TreeNode node : list){

            if (node == null){
                countNull++;
            }else {
                countNotNull++;
            }

        }


        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(1);

        String ser = serialize(root);

        TreeNode result = deserialize(ser);

        System.out.println(result.val);

        serialize((TreeNode) null);

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

