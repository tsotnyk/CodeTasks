package com.j2core.sts.leetcode.com.tmp.mockInterview.googleOA;

import com.j2core.sts.leetcode.com.trees.TreeNode;

import java.util.*;

public class GoogleOASolution4 {
    public int deepestLeavesSum(TreeNode root) {

        if (root.left == null && root.right == null) return root.val;

        List<TreeNode> levelValue = null;
        List<TreeNode> nextLevel = new LinkedList<>(Collections.singletonList(root));

        while (!nextLevel.isEmpty()){

            levelValue = nextLevel;
            nextLevel = new LinkedList<>();

            for (TreeNode node : levelValue){
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }

        }

        int sum = 0;
        for (TreeNode node : levelValue){
            sum += node.val;
        }

        return  sum;
    }

    public int[] anagramMappings(int[] nums1, int[] nums2) {

        HashMap<Integer, LinkedList<Integer>> numMap = new HashMap<>();
        int index = 0;
        for (int num : nums2){
            if (numMap.containsKey(num)){
                numMap.get(num).add(index);
            }else {
                numMap.put(num, new LinkedList<>(Collections.singletonList(index)));
            }
            index++;
        }

        int[] result = new int[nums1.length];
        index = 0;
        for (int num : nums1){
            result[index] = numMap.get(num).removeLast();
            index++;
        }

        return result;
    }
}
