package com.j2core.sts.leetcode.com.pathWithMaximunProbability;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        for (int i = 0; i < n - 1; i++) {
            boolean hasUpdate = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double pathProb = succProb[j];
                if (maxProb[u] * pathProb > maxProb[v]) {
                    maxProb[v] = maxProb[u] * pathProb;
                    hasUpdate = true;
                }
                if (maxProb[v] * pathProb > maxProb[u]) {
                    maxProb[u] = maxProb[v] * pathProb;
                    hasUpdate = true;
                }
            }
            if (!hasUpdate) {
                break;
            }
        }

        return maxProb[end_node];
    }

    @Test
    public void test(){

        Assert.assertEquals(maxProbability(3, new int[][]{{0,1}, {1,2}, {0,2}}, new double[]{0.5, 0.5, 0.2}, 0, 2), 0.25);
    }
}
