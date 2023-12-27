package com.j2core.sts.leetcode.com.lowestCommonAncestorOfBinaryTreeIII;

import java.util.HashSet;

public class Solution {

    public Node lowestCommonAncestor(Node p, Node q) {

        HashSet<Node> parents = new HashSet<>();

        Node curNode = p;
        while (curNode != null){
            parents.add(curNode);
            curNode = curNode.parent;
        }

        curNode = q;

        while (curNode != null){
            if (parents.contains(curNode)) break;
            curNode = curNode.parent;
        }

        return curNode;
    }
}
