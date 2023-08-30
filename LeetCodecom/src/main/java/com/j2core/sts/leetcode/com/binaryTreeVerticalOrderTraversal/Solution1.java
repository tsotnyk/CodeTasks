package com.j2core.sts.leetcode.com.binaryTreeVerticalOrderTraversal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public List<List<Integer>> verticalOrder(TreeNode root) {

        if(root == null) return new LinkedList<>();

        HashMap<Integer, List<Integer>> vertLevelMap = new HashMap<>();
        LinkedList<Task> tasks = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        tasks.add(new Task(0, root));

        while (!tasks.isEmpty()){
            Task task = tasks.removeFirst();
            min = Math.min(min, task.delta);
            max = Math.max(max, task.delta);
            List<Integer> list = vertLevelMap.getOrDefault(task.delta, new LinkedList<>());
            list.add(task.node.val);
            vertLevelMap.put(task.delta, list);
            if (task.node.left!= null){
                tasks.add(new Task(task.delta-1, task.node.left));
            }
            if (task.node.right != null){
                tasks.add(new Task(task.delta+1, task.node.right));
            }
        }

        List<List<Integer>> output = new LinkedList<>();

        for (int i = min; i <= max; i++){
            output.add(vertLevelMap.get(i));
        }

        return output;
    }



}

class Task{

    int delta;

    TreeNode node;

    public Task(int delta, TreeNode node) {
        this.delta = delta;
        this.node = node;
    }
}
