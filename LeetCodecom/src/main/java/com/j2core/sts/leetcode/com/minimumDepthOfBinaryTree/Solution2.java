package com.j2core.sts.leetcode.com.minimumDepthOfBinaryTree;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class Solution2 {

    public int minDepth(TreeNode root) {

        return minDepth(root, 0);

    }

    private int minDepth(TreeNode root, int curDepth){

        if (root == null) return curDepth;

        if (root.left == null && root.right == null) return curDepth+1;

        int leftDepth = minDepth(root.left, curDepth+1);

        return Math.min(leftDepth, minDepth(root.right, curDepth+1));
    }

    String[] solution(String[][] queries) {


        TreeMap<Integer, Integer> map = new TreeMap<>();

        String[] result = new String[queries.length];
        int index = 0;
        for (String[] query : queries){
            int value = Integer.parseInt(query[1]);
            switch (query[0]){
                case "ADD":
                    map.put(value, map.getOrDefault(value, 0)+1);
                    result[index++] = "";
                    break;
                case "GET_NEXT":
                    Integer counter = map.ceilingKey(value+1);
                    result[index++] = counter != null ? counter.toString() : "";
                    break;
                case "EXISTS":
                    result[index++] = map.containsKey(value) ? "true" : "false";
                    break;
                default:
                    if (map.containsKey(value)){
                        int countNum = map.get(value);
                        if (countNum == 1){
                            map.remove(value);
                        }else {
                            map.put(value, countNum-1);
                        }
                        result[index++] = "true";
                    }else {
                        result[index++] = "false";
                    }
            }
        }

        return result;
    }

    @Test
    public void test(){

        String[] result = solution(new String[][]{
                {"ADD","1"},
                {"ADD","2"},
                {"ADD","2"},
                {"ADD","4"},
        {"GET_NEXT","1"},
                {"GET_NEXT","2"},
                {"GET_NEXT","3"},
                {"GET_NEXT","4"},
                {"REMOVE","2"},
                {"GET_NEXT","1"},
                {"GET_NEXT","2"},
                {"GET_NEXT","3"},
                {"GET_NEXT","4"},

        });
    }
}
