package com.j2core.sts.leetcode.com.tmp.mockInterview;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AmazonPISolution {

    public boolean isArmstrong(int N) {
        int sum = 0;
        int num = N;
        List<Integer> list = new LinkedList<>();
        while (num > 0){
            list.add(num%10);
            num /= 10;
        }

        for(int nextNum : list){
            sum += (int)Math.pow(nextNum, list.size());
        }

        return sum == N;
    }

    @Test
    public void testIsArmstrong(){

        Assert.assertTrue(isArmstrong(153));
        Assert.assertFalse(isArmstrong(123));
    }

    public TreeNode bstFromPreorder(int[] preorder) {

        TreeNode root = new TreeNode(preorder[0]);
        TreeNode node;
        LinkedList<TreeNode> list = new LinkedList<>(Collections.singletonList(root));
        int index = 1;
        while (index < preorder.length){
            node = list.removeLast();
            if (preorder[index] < node.val){
                node.left = new TreeNode(preorder[index]);
                list.add(node);
                list.add(node.left);
            }else {
                if (!list.isEmpty()){
                    if (list.getLast().val < preorder[index]){
                        index--;
                    }else {
                        node.right = new TreeNode(preorder[index]);
                        list.add(node.right);
                    }
                }else {
                    node.right = new TreeNode(preorder[index]);
                    list.add(node.right);
                }
            }
            index++;
        }

        return root;
    }

    @Test
    public void testBSTFromPreorder(){

        TreeNode node = bstFromPreorder(new int[]{8,5,1,7,10,12});
    }
}
