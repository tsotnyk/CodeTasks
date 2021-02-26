package com.j2core.sts.leetcode.com.tmp.mockInterview;

import com.j2core.sts.leetcode.com.trees.TreeNode;

import java.util.*;

public class FacebookOASolution2 {

    public String reverseVowels(String s) {

        HashSet<Character> vowelsLetter = new HashSet<>(Arrays.asList('a', 'o', 'e', 'i', 'u', 'A', 'E', 'O', 'I', 'U'));

        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length()-1;
        while (i < j){
            if (!vowelsLetter.contains(word[i])){
                i++;
            }else if (!vowelsLetter.contains(word[j])){
                j--;
            }else {
                char tmp = word[i];
                word[i] = word[j];
                word[j] = tmp;
                i++;
                j--;
            }
        }
        return String.valueOf(word);
    }

    public List<Integer> largestValues(TreeNode root) {

        if (root == null) return new LinkedList<>();
        List<Integer> result = new LinkedList<>();

        int maxValue = Integer.MIN_VALUE;
        List<TreeNode> row = new LinkedList<>(Collections.singletonList(root));
        List<TreeNode> nextRow = new LinkedList<>();
        while (!row.isEmpty()){
            TreeNode node = row.remove(0);
            if(node.val > maxValue){
                maxValue = node.val;
            }
            if (node.left != null) nextRow.add(node.left);
            if (node.right != null) nextRow.add(node.right);
            if (row.isEmpty()){
                row = nextRow;
                nextRow = new LinkedList<>();
                result.add(maxValue);
                maxValue = Integer.MIN_VALUE;
            }
        }
        return  result;
    }

}
