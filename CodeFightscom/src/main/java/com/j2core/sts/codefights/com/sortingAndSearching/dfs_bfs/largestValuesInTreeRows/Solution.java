package com.j2core.sts.codefights.com.sortingAndSearching.dfs_bfs.largestValuesInTreeRows;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    int[] largestValuesInTreeRows(Tree<Integer> t) {
        if (t == null) return new int[0];

        List<Integer> valueList = new LinkedList<>();
        LinkedList<Tree<Integer>> nodeList = new LinkedList<>();
        nodeList.add(t);
        LinkedList<Tree<Integer>> nextLevelNodes = new LinkedList<>();
        int maxValue = Integer.MIN_VALUE;

        while (!nodeList.isEmpty()){
            Tree<Integer> node = nodeList.removeFirst();
            maxValue = Math.max(maxValue, node.value);
            if (node.left != null && node.right != null){
                nextLevelNodes.add(node.left);
                nextLevelNodes.add(node.right);

            }else if (node.left != null){
                nextLevelNodes.add(node.left);
            }else if (node.right != null){
                nextLevelNodes.add(node.right);
            }
            if (nodeList.isEmpty()){
                nodeList = nextLevelNodes;
                nextLevelNodes = new LinkedList<>();
                valueList.add(maxValue);
                maxValue = Integer.MIN_VALUE;
            }
        }

        int[] result = new int[valueList.size()];
        int index = 0;
        for (int val : valueList){
            result[index++] = val;
        }

        return result;
    }
}
