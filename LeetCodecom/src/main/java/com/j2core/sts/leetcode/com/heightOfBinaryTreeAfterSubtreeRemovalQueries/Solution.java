package com.j2core.sts.leetcode.com.heightOfBinaryTreeAfterSubtreeRemovalQueries;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    public int[] treeQueries(TreeNode root, int[] queries) {

        HashMap<Integer, MyTreeNode> map = new HashMap<>();
        createMyTree(root, null, map);

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++){
            result[i] = getHeight(queries[i], map);
        }

        return result;
    }

    private int getHeight(int query, HashMap<Integer, MyTreeNode> map) {

        ArrayList<Integer> rout = new ArrayList<>();
        MyTreeNode node = map.get(query);
        while (node.parent != null){
            rout.add(node.parent.val);
        }

        int height = map.get(rout.remove(0)).node.val;


        return -1;
    }

    public int createMyTree(TreeNode node, TreeNode parent, HashMap<Integer, MyTreeNode> map){

        if(node == null) return 0;

        MyTreeNode root = new MyTreeNode(node, parent);

        int left = createMyTree(node.left, node, map);
        int right = createMyTree(node.right, node, map);

        root.height = Math.max(left, right);

        map.put(node.val, root);
        return root.height + 1;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

class MyTreeNode{

    TreeNode node;
    TreeNode parent;
    int height;

    public MyTreeNode(TreeNode node, TreeNode parent) {
        this.parent = parent;
        this.node = node;
    }
}

/*

 private Map<Integer, Integer> leftMap = new HashMap<>();
    private Map<Integer, Integer> rightMap = new HashMap<>();
    private Map<Integer, Integer> removed = new HashMap<>();

    public int[] treeQueries(TreeNode root, int[] queries) {
        populateHeights(root, 0);
        calculateRemovedHeights(root, 0);

        int[] output = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            output[i] = removed.get(queries[i]);
        }
        return output;
    }

	// height is the max tree height with this node removed
    private void calculateRemovedHeights(TreeNode node, int height) {
        if (node == null) {
            return;
        }
        removed.put(node.val, height);

		// for each child, the height when removed is the max of the the height following
		// the opposite child, or the passed-in height with this node removed
        calculateRemovedHeights(node.left, Math.max(height, rightMap.get(node.val)));
        calculateRemovedHeights(node.right, Math.max(height, leftMap.get(node.val)));
    }

	// populate the maps with the total height of the left and right subtree of
	// each node, and return the larger of the two values
    private int populateHeights(TreeNode node, int height) {
        if (node == null) {
            return height - 1;
        }

        leftMap.put(node.val, populateHeights(node.left, height + 1));
        rightMap.put(node.val, populateHeights(node.right, height + 1));

        return Math.max(leftMap.get(node.val), rightMap.get(node.val));
    }
 */
