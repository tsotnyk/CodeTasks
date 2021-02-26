package com.j2core.sts.leetcode.com.tmp.mockInterview;

import org.junit.Assert;
import org.junit.Test;

public class ApplePISolution3 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode newTree = new TreeNode(t1.val+t2.val);

        newTree.left = mergeTrees(t1.left, t2.left);
        newTree.right = mergeTrees(t1.right, t2.right);

        return newTree;
    }

    class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
        public  TreeNode(){

        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void test(){

        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(3);
        node1.left.left = new TreeNode(5);
        node1.right = new TreeNode(2);

        TreeNode node2 = new TreeNode(2);
        node2.left = new TreeNode(1);
        node2.left.right = new TreeNode(4);
        node2.right = new TreeNode(3);
        node2.right.right = new TreeNode(7);

        TreeNode newTree = mergeTrees(node1, node2);
    }

    public int closedIsland(int[][] grid) {

        int counter = 0;
        int maxIsize = grid.length-1;
        int maxJsize = grid[0].length-1;

        for (int i = 1; i < maxIsize; i++){
            for (int j = 1; j < maxJsize; j++){
                if (grid[i][j] == 0){
                    if (isClosedIsland(grid, i, j, maxIsize, maxJsize)){
                        counter++;
                    }
                }
            }
        }

        return counter;
    }

    private boolean isClosedIsland(int[][] grid, int i, int j, int maxIsize, int maxJsize){

        boolean flag = true;
        if (i == 0 || j == 0 || j == maxJsize || i == maxIsize) return false;
        grid[i][j] = 1;
        if (grid[i-1][j] != 1){
            if(!isClosedIsland(grid, i-1, j, maxIsize, maxJsize)) flag = false;
        }
        if (grid[i][j-1] != 1){
            if (!isClosedIsland(grid, i, j-1, maxIsize, maxJsize)) flag = false;
        }
        if (grid[i+1][j] != 1){
            if (!isClosedIsland(grid, i+1, j, maxIsize, maxJsize)) flag = false;
        }
        if (grid[i][j+1] != 1){
            if (!isClosedIsland(grid, i, j+1, maxIsize, maxJsize)) flag = false;
        }

        return flag;
    }

    @Test
    public void test1(){


        int[][] matrix1 = new int[][]{
                {0,0,1,1,0,1,0,0,1,0},
                {1,1,0,1,1,0,1,1,1,0},
                {1,0,1,1,1,0,0,1,1,0},
                {0,1,1,0,0,0,0,1,0,1},
                {0,0,0,0,0,0,1,1,1,0},
                {0,1,0,1,0,1,0,1,1,1},
                {1,0,1,0,1,1,0,0,0,1},
                {1,1,1,1,1,1,0,0,0,0},
                {1,1,1,0,0,1,0,1,0,1},
                {1,1,1,0,1,1,0,1,1,0}};

        Assert.assertEquals(closedIsland(matrix1), 5);

        int[][] matrix = new int[][]{{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};

        Assert.assertEquals(closedIsland(matrix), 2);
    }
}
