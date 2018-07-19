package com.j2core.sts.leetcode.com.trees.sameTree;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        boolean result = true;

        List<TreeNode> listP = new LinkedList<>();
        listP.add(p);

        List<TreeNode> listQ = new LinkedList<>();
        listQ.add(q);

        while (!listP.isEmpty() && !listQ.isEmpty()){

            TreeNode nodeP = ((LinkedList<TreeNode>) listP).removeLast();
            TreeNode nodeQ = ((LinkedList<TreeNode>) listQ).removeLast();

            if (nodeP != null && nodeQ != null) {
                if (nodeP.val != nodeQ.val) {
                    result = false;
                    break;
                } else {
                    listP.add(nodeP.right);
                    listP.add(nodeP.left);
                    listQ.add(nodeQ.right);
                    listQ.add(nodeQ.left);
                }
            }else if ((nodeP == null && nodeQ != null) || (nodeP != null && nodeQ == null)){
                result = false;
                break;
            }
        }

        return result;

    }


    @Test
    public void test(){

        TreeNode head1 = new TreeNode(1);
        head1.left = new TreeNode(2);
        head1.right = new TreeNode(1);
        TreeNode head2 = new TreeNode(1);
        head2.left = new TreeNode(1);
        head2.right = new TreeNode(1);

        boolean result = isSameTree(head1, head2);

        System.out.print(result);

    }
}
