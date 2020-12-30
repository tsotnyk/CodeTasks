package com.j2core.sts.leetcode.com.parallelCourses;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    public int minimumSemesters(int N, int[][] relations) {

        boolean[] studiedCourses = new boolean[N+1];
        studiedCourses[0] = true;
        int semesters = 0;
        HashMap<Integer, List<Integer>> coursesMap = new HashMap<>();
        List<Integer> coursesList = new LinkedList<>();

        for (int course = 1; course <= N; course++){
            coursesMap.put(course, new LinkedList<>());
            coursesList.add(course);
        }
        for (int[] relation : relations){
            coursesMap.get(relation[1]).add(relation[0]);
        }
        while (semesters > -1 && !coursesList.isEmpty()){

            semesters = findCoursesForSemester(N, semesters, studiedCourses, coursesMap, coursesList);

        }

        return semesters;

    }

    private int findCoursesForSemester(int amountCourses, int semesters, boolean[] studiedCourses, Map<Integer, List<Integer>> coursesMap, List<Integer> coursesList){

        List<Integer> coursesInSemester = new LinkedList<>();
        for (int course : coursesList){
            if (studiedCourses[course]) continue;
            if (coursesMap.get(course).isEmpty()){
                coursesInSemester.add(course);
            }else {
                boolean thisSemester = true;
                for (int nextCourse : coursesMap.get(course)){
                    if (!studiedCourses[nextCourse]){
                        thisSemester = false;
                        break;
                    }
                }
                if (thisSemester){
                    coursesInSemester.add(course);
                }
            }
        }
        for (Integer course : coursesInSemester){
            studiedCourses[course] = true;
            coursesList.remove(course);
        }
        return coursesInSemester.isEmpty() ? -1 : semesters+1;
    }

    @Test
    public void test(){

        Assert.assertEquals(minimumSemesters(3, new int[][]{{1,3},{2,3}}), 2);
        Assert.assertEquals(minimumSemesters(3, new int[][]{{1,2},{2,3},{3,1}}), -1);

    }


}
