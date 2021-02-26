package com.j2core.sts.leetcode.com.tmp.mockInterview;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MicrosoftOASolution2 {

    // Space O(A.length*A[0].length) Time O(A.length*A[0].length) --> line complexity
    public int[][] flipAndInvertImageV1(int[][] A) {

        int[][]  newMatrix = new int[A.length][A[0].length];

        for (int i = 0; i < A.length; i++){
            int index = 0;
            for (int j = A[0].length-1; j > -1; j--){
                newMatrix[i][index++] = A[i][j] == 0 ? 1 : 0;
            }
        }
        return newMatrix;
    }

    //Space O(1) Time O(A.length*A[0].length+A.length*(A[0].length/2)) --> line complexity
    public int[][] flipAndInvertImageV2(int[][] A) {

        for (int i = 0; i < A.length; i++){
            int indexS = 0;
            int indexE = A[0].length-1;
            while (indexE > indexS){
                int tmp = A[i][indexS];
                A[i][indexS] = A[i][indexE];
                A[i][indexE] = tmp;
                indexS++;
                indexE--;
            }
        }
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A[0].length; j++){
                A[i][j] = A[i][j] == 1 ? 0 : 1;
            }
        }
        return A;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        ArrayList<Integer> leaves1 = new ArrayList<>();
        traversTree(root1, leaves1);
        ArrayList<Integer> leaves2 = new ArrayList<>();
        traversTree(root2, leaves2);

        if (leaves1.size() != leaves2.size()) return false;

        for (int i = 0; i < leaves1.size(); i++){
            if (!leaves1.get(i).equals(leaves2.get(i))) return false;
        }
        return true;
    }

    private void traversTree(TreeNode root, ArrayList<Integer> result){

        if (root.left == null && root.right == null) {
            result.add(root.val);
            return;
        }
        if (root.left != null){
            traversTree(root.left, result);
        }
        if (root.right != null){
            traversTree(root.right, result);
        }
    }

    int[] mostFrequentDigits(int[] a) {

        int[] numCounter = new int[10];

        for(int num : a){

            while (num > 0){
                numCounter[num%10] += 1;
                num /= 10;
            }
        }

        int maxCount = numCounter[0];
        int count = 1;

        for(int i = 1; i < 10; i++){
            if(numCounter[i] == maxCount){
                count++;
            }else if(numCounter[i] > maxCount){
                maxCount = numCounter[i];
                count = 1;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for(int i = 0; i < 10; i++){
            if(numCounter[i] == maxCount){
                result[index++] = i;
            }
        }
        return result;
    }

    @Test
    public void test(){

        Assert.assertArrayEquals(mostFrequentDigits(new int[]{25, 2, 3, 57, 38, 41}), new int[]{2,3,5});
    }
}
