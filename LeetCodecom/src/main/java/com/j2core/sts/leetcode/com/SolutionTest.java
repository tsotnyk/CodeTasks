package com.j2core.sts.leetcode.com;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class SolutionTest {

    public int solution1(int[] A) {
        // write your code in Java SE 8

        // time complexity O(nLogn)
        Arrays.sort(A);
        int num = 1;
        // time complexity O(n)
        for (int i = 0; i < A.length; i++){
            if (A[i] > num) return num;
            if (A[i] == num) num++;
        }

        // full time complexity O(n+nLogn)
        return num;
    }

//    public boolean solution2(String S, String T) {
//        // write your code in Java SE 8
//
//        String stringS = parsString(S);
//        String stringT = parsString(T);
//
//        if (stringS.length() != stringT.length()) return false;
//
//        for (int i = 0; i < stringS.length(); i++){
//            char characterS = stringS.charAt(i);
//            if (characterS != '?'){
//                char characterT = stringT.charAt(i);
//                if (characterT != '?' && characterT != characterS) return false;
//            }
//        }
//        return true;
//    }

        public boolean solution2(String S, String T) {
        // write your code in Java SE 8

        String stringS = parsString(S);

        int index = 0;



        return true;
    }

    private String parsString(String str){

        StringBuilder builder = new StringBuilder();
        int indexStart = 0;
        int index = 0;

        while (index < str.length()){
            if (Character.isLetter(str.charAt(index))){
                if (indexStart == index) {
                    builder.append(str.charAt(index++));
                }else {
                    int counter = Integer.parseInt(str.substring(indexStart, index));
                    while (counter > 0){
                        builder.append('?');
                        counter--;
                    }
                }
                indexStart = index;
            }else {
                index++;
            }
        }

        if (indexStart != index){
            int counter = Integer.parseInt(str.substring(indexStart));
            while (counter > 0){
                builder.append('?');
                counter--;
            }
        }

        return builder.toString();

    }

    public int solution(String S) {
        // write your code in Java SE 8
        int maxSleepTime = 0;
        Map<Integer, List<List<Integer>>> schedulerMap = createSchedulerMap(S);

        for (int i = 1; i <= 8; i++){
            int sleepTime;
            if (i == 1){
                sleepTime = countSleepTime(null, schedulerMap.get(i).get(0));
            }else if (i == 8){
                sleepTime = countSleepTime(schedulerMap.get(i-1).get(1), null);
            }else {
                sleepTime = countSleepTime(schedulerMap.get(i-1).get(1), schedulerMap.get(i).get(0));
            }
            maxSleepTime = Math.max(maxSleepTime, sleepTime);
        }

        return maxSleepTime;
    }

    private int countSleepTime(List<Integer> startSleepTime, List<Integer> endSleepTime){

        int sleepTime = 0;
        if (startSleepTime != null){
            sleepTime = (24 - startSleepTime.get(0))*60;
            sleepTime -= startSleepTime.get(1);
        }
        if (endSleepTime != null){
            sleepTime += endSleepTime.get(0)*60;
            sleepTime += endSleepTime.get(1);
        }

        return sleepTime;
    }

    private Map<Integer, List<List<Integer>>> createSchedulerMap(String stringScheduler){

        Map<Integer, List<List<Integer>>> schedulerMap = new HashMap<>();
        int startIndex = 0;
        int index = 3;
        while (index <= stringScheduler.length()){
            if (index == stringScheduler.length() || Character.isLetter(stringScheduler.charAt(index))){
                List<List<Integer>> daySchedule = parsTime(stringScheduler.substring(startIndex, index));
                int mapKey = 0;
                switch (stringScheduler.substring(startIndex, startIndex+3)){
                    case "Mon":
                        mapKey = 1;
                        break;
                    case "Tue":
                        mapKey = 2;
                        break;
                    case "Wed":
                        mapKey = 3;
                        break;
                    case "Thu":
                        mapKey = 4;
                        break;
                    case "Fri":
                        mapKey = 5;
                        break;
                    case "Sat":
                        mapKey = 6;
                        break;
                    case "Sun":
                        mapKey = 7;
                        break;
                }
                if (schedulerMap.containsKey(mapKey)){
                    List<List<Integer>> newTime = schedulerMap.get(mapKey);
                    if (newTime.get(0).get(0) > daySchedule.get(0).get(0)){
                        newTime.set(0, daySchedule.get(0));
                    }
                    if (newTime.get(1).get(0) < daySchedule.get(1).get(0)){
                        newTime.set(1, daySchedule.get(1));
                    }
                }else {
                    schedulerMap.put(mapKey, daySchedule);
                }
                startIndex = index;
                index += 2;
            }
            index++;
        }

        return schedulerMap;
    }

    private List<List<Integer>> parsTime(String meetingTime){

        List<List<Integer>> dayScheduled = new ArrayList<>(2);

        int index = meetingTime.indexOf(':');
        while (index > -1){
            List<Integer> timeList = new ArrayList<>(2);
            timeList.add(Integer.parseInt(meetingTime.substring(index-2, index)));
            timeList.add(Integer.parseInt(meetingTime.substring(index+1, index+3)));
            dayScheduled.add(timeList);
            index = meetingTime.indexOf(':', index+1);
        }

        return dayScheduled;
    }

    @Test
    public void test(){

        Assert.assertEquals(solution("Mon 01:00-23:00\n" +
                "Tue 01:00-23:00\n" +
                "Wed 01:00-23:00\n" +
                "Thu 01:00-23:00\n" +
                "Fri 01:00-23:00\n" +
                "Sat 01:00-23:00\n" +
                "Sun 01:00-21:00"), 180);
        Assert.assertEquals(solution("Sun 10:00-20:00 Fri 05:00-10:00 Fri 16:30-23:50 Sat 10:00-24:00 Sun 01:00-04:00 Sat 02:00-06:00 Tue 03:30-18:15 Tue 19:00-20:00 Wed 04:25-15:14 Wed 15:14-22:40 Thu 00:00-23:59 Mon 05:00-13:00 Mon 15:00-21:00"), 505);
    }

    @Test
    public void test2(){

        int num = Integer.parseInt("05");

        Assert.assertTrue(solution2("A2Le", "2pL1"));
        Assert.assertTrue(solution2("a10", "10a"));
        Assert.assertFalse(solution2("ba1", "1Ad"));
        Assert.assertFalse(solution2("3x2x", "8"));

    }


    @Test
    public void  test1(){

        Assert.assertEquals(solution1(new int[]{1,3,6,4,1,2}), 5);
        Assert.assertEquals(solution1(new int[]{1,2,3}), 4);
        Assert.assertEquals(solution1(new int[]{-1,-2}), 1);

    }
}
