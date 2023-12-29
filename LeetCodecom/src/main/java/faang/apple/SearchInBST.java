package faang.apple;

public class SearchInBST {

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) return null;
        if (root.val == val) return root;

        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}

class TreeNode{

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
