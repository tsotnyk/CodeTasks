package com.j2core.sts.leetcode.com.heightOfBinaryTreeAfterSubtreeRemovalQueries;

import java.util.*;

public class Solution1 {

    public int[] treeQueries(TreeNode root, int[] queries) {

        HashMap<Integer, HashSet<TreeNode>> levelMap = new HashMap<>();
        HashMap<Integer, Integer> nodeHeight = new HashMap<>();
        int level = -1;
        HashSet<TreeNode> levelNodeList = new HashSet<>(Collections.singletonList(root));

        while (!levelNodeList.isEmpty()){
            level++;
            HashSet<TreeNode> nextLevel = new HashSet<>();
            for (TreeNode node : levelNodeList){
                if (node.left != null){
                    nextLevel.add(node.left);
                }
                if (node.right != null){
                    nextLevel.add(node.right);
                }
            }
            levelMap.put(level, levelNodeList);
            levelNodeList = nextLevel;
        }

        int deep = level;
        while (deep >= 0){

            HashSet<TreeNode> levelList = levelMap.get(level);

            for (TreeNode node : levelList){
                int curDeep = 0;
                if (node.right != null){
                    curDeep = Math.max(nodeHeight.getOrDefault(node.right.val, 0), curDeep);
                }
                if (node.left != null){
                    curDeep = Math.max(nodeHeight.getOrDefault(node.left.val, 0), curDeep);
                }
                nodeHeight.put(node.val, curDeep);
            }
            deep--;
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++){

            for (int j = 1; j <= level; j++){
//                if ()
            }
        }

        return result;
    }
}
