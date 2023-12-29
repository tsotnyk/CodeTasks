package faang.apple;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new LinkedList<>();
        travers(root, res);

        return res;
    }

    private void travers(TreeNode root, List<Integer> res){

        if (root == null) return;

        travers(root.left, res);
        res.add(root.val);
        travers(root.right, res);
    }
}
