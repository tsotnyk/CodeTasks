package com.j2core.sts.leetcode.com.trees.findCorrespondingNodeOfBinaryTreeInCloneOfThatTree;

import com.j2core.sts.leetcode.com.trees.TreeNode;

public class Solution {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        if (original == null) return null;
        if (original.equals(target)) return cloned;

        TreeNode clonedTarget = getTargetCopy(original.left, cloned.left, target);
        if (clonedTarget != null) return clonedTarget;
        return getTargetCopy(original.right, cloned.right, target);
    }
}
