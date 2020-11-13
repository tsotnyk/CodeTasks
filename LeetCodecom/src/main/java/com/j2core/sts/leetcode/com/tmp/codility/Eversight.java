package com.j2core.sts.leetcode.com.tmp.codility;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Eversight {

    public String solution1(String S, int K) {
        // write your code in Java SE 8

        int nextDay = K % 7;
        Map<Integer, String> mapDays = new HashMap<>();
        mapDays.put(1, "Mon");
        mapDays.put(2, "Tue");
        mapDays.put(3, "Wed");
        mapDays.put(4, "Thu");
        mapDays.put(5, "Fri");
        mapDays.put(6, "Sat");
        mapDays.put(7, "Sun");

        int currentDay;

        switch (S){
            case "Mon":
                currentDay = 1;
                break;
            case "Tue":
                currentDay = 2;
                break;
                case "Wed":
                currentDay = 3;
                break;
            case "Thu":
                currentDay = 4;
                break;
            case "Fri":
                currentDay = 5;
                break;
            case "Sat":
                currentDay = 6;
                break;
            default:
                currentDay = 7;
                break;
        }

        return mapDays.get((nextDay+currentDay)%7);
    }

    public int solution(int[] A) {
        // write your code in Java SE 8

        boolean[] visit = new boolean[A.length];
        int maxLength = 0;

        for (int i = 0; i < A.length; i++){

            if (!visit[i]){
                int counter = 1;
                visit[i] = true;
                int index = A[i];
                while (!visit[index]){
                    visit[index] = true;
                    counter++;
                    index = A[index];
                }

                maxLength = Math.max(counter, maxLength);
            }
        }

        return maxLength;
    }

    @Test
    public void test2(){

        Assert.assertEquals(solution(new int[]{5,4,0,3,1,6,2}), 4);

    }

    @Test
    public void test1(){

        Assert.assertEquals(solution1("Sat", 23), "Mon");
    }
}
