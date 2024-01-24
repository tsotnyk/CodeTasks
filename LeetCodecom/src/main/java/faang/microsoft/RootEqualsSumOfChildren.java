package faang.microsoft;

import org.testng.annotations.Test;

public class RootEqualsSumOfChildren {

    public boolean checkTree(TreeNode root) {

        return root.left.val+root.right.val == root.val;
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
