package com.j2core.sts.leetcode.com.graphs.cloneGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public Node cloneGraph(Node node) {
        if (node == null || node.val == 0) return node;
        if (node.neighbors.isEmpty()) return new Node(node.val);

        HashMap<Integer, Node> nodeMap = new HashMap<>();

        Node newRoot = new Node(node.val);
        nodeMap.put(1, newRoot);
        List<Node> listNode = node.neighbors;

        while (listNode.isEmpty()){
//            Node
        }

        return null;
    }
}
