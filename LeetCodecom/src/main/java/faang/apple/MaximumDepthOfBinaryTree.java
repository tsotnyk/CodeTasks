package faang.apple;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {

        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode root, int curDep){

        if (root == null) return curDep;
        int left = maxDepth(root.left, curDep+1);
        int right = maxDepth(root.right, curDep+1);

        return Math.max(left, right);
    }
}
