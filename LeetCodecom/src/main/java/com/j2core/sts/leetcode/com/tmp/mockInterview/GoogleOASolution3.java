package com.j2core.sts.leetcode.com.tmp.mockInterview;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class GoogleOASolution3 {

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> map = new HashMap();
        for (int[] c : connections) {
            map.computeIfAbsent(c[0], k -> new ArrayList()).add(new int[]{c[1], 1});
            map.computeIfAbsent(c[1], k -> new ArrayList()).add(new int[]{c[0], 0});
        }
        Queue<Integer> q = new LinkedList();
        q.offer(0);
        int res = 0;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] next : map.get(cur)) {
                if (!visited[next[0]]) {
                    visited[next[0]] = true;
                    q.offer(next[0]);
                    res += next[1];
                }
            }
        }
        return res;
    }

    @Test
    public void test(){

        Assert.assertEquals(3, minReorder(6, new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}}));
    }

}
