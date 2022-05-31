package com.j2core.sts.codefights.com.dataStructures.graphs.hasDeadlock;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    boolean hasDeadlock(int[][] connections) {
        boolean[] visited = new boolean[connections.length];
        boolean[] recStack = new boolean[connections.length];

        for (int i = 0; i < connections.length; i++)
            if (isCyclicUtil(i, visited, recStack, connections))
                return true;

        return false;
    }

    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack, int[][] connections) {
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        int[] children = connections[i];

        for (int child: children)
            if (isCyclicUtil(child, visited, recStack, connections))
                return true;

        recStack[i] = false;

        return false;
    }

    @Test
    public void test(){

        Assert.assertTrue(hasDeadlock(new int[][]{{1},{2},{3,4},{4},{0}}));
        Assert.assertFalse(hasDeadlock(new int[][]{{1,2,3},{2,3},{3},{}}));

    }

}
