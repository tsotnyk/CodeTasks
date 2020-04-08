package com.j2core.sts.leetcode.com.graphs.courseSchedule;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = createGraph(prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] paths = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++){
            if (canCycle(graph, i, visited, paths)) return false;
        }

        return true;
    }

    private boolean canCycle(Map<Integer, List<Integer>> graph, int course, boolean[] visited, boolean[] paths){

        if (visited[course]) return false;

        if (paths[course]) return true;

        if (!graph.containsKey(course)) return false;

        paths[course] = true;
        boolean flag = false;

        for (int childCourse : graph.get(course)){
            if (canCycle(graph, childCourse, visited, paths)) {
                flag = true;
                break;
            }
        }

        paths[course] = false;
        visited[course] = true;

        return flag;
    }

    private Map<Integer, List<Integer>> createGraph(int[][] prerequisites){

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] array : prerequisites){

            if (graph.containsKey(array[0])){
                graph.get(array[0]).add(array[1]);
            }else {
                graph.put(array[0], new LinkedList<>(Arrays.asList(array[1])));
            }

        }

        return graph;
    }

    @Test
    public void test(){

        Assert.assertTrue(canFinish(3, new int[][]{{0,1}, {0,2}, {1,2}}));
    }
}
