package com.j2core.sts.leetcode.com.graphs.courseScheduleII;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {


        Stack<Integer> orderStack = new Stack<>();
        Boolean[] visitCourses = new Boolean[numCourses];
        HashMap<Integer, ArrayList<Integer>> coursesMap = createCoursesMap(prerequisites);

        if (coursesMap == null) return new int[]{};

        for (int i = numCourses-1; i > -1; i--){
            if (visitCourses[i] == null || !visitCourses[i]){
                boolean result = topologicalVisit(coursesMap, visitCourses, i, orderStack);
                if (!result) return new int[]{};
            }
        }

        return createCoursesList(orderStack, numCourses);
    }

    private int[] createCoursesList(Stack<Integer> orderStack, int numCourses) {

        int[] courses = new int[numCourses];

        for (int i = 0; i < numCourses; i++){
            courses[i] = orderStack.pop();
        }

        return courses;
    }

    private boolean topologicalVisit(HashMap<Integer, ArrayList<Integer>> coursesMap, Boolean[] visitCourses, int currentCourse, Stack<Integer> orderStack){

        if (coursesMap.containsKey(currentCourse)){
            for (int course : coursesMap.get(currentCourse)){
                if (visitCourses[course] == null){
                    visitCourses[course] = false;
                    if (!topologicalVisit(coursesMap, visitCourses, course, orderStack)) return false;
                }else if (!visitCourses[course])return false;
            }
        }

        visitCourses[currentCourse] = true;
        orderStack.push(currentCourse);
        return true;
    }


    private HashMap<Integer, ArrayList<Integer>> createCoursesMap(int[][] prerequisites){

        HashMap<Integer, ArrayList<Integer>> coursesMap = new HashMap<>();

        for (int[] prerequisite : prerequisites){
            if (coursesMap.containsKey(prerequisite[0])){
                if (coursesMap.get(prerequisite[0]).contains(prerequisite[1])) return null;
            }

            if (coursesMap.containsKey(prerequisite[1])){
                coursesMap.get(prerequisite[1]).add(prerequisite[0]);
            }else {
                coursesMap.put(prerequisite[1], new ArrayList<>(Arrays.asList(prerequisite[0])));
            }

        }
        return coursesMap;
    }

    @Test
    public void test(){
        Assert.assertEquals(findOrder(2, new int[][]{ {1,0}}), new int[]{0,1});

        Assert.assertEquals(findOrder(3, new int[][]{ {1,0}, {0,2},{2,1}}), new int[]{});
    }
}
