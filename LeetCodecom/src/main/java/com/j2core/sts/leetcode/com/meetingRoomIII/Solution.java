package com.j2core.sts.leetcode.com.meetingRoomIII;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<long[]> queue = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? (int) (a[1] - b[1]) : (int) (a[0] - b[0]));
        // {endTime, room}

        int[] roomCount = new int[n]; // number of meeting of the room
        int result = 0;

        for (int i = 0; i < n; i++)
            queue.add(new long[] { 0, i });

        for (int[] item : meetings) {
            int time = item[0]; // new meeting start time

            while (queue.peek()[0] < time) // order all available room by room index
                queue.add(new long[] { time, queue.poll()[1] });

            long[] current = queue.poll();
            int curRoom = (int) current[1];
            long meetingEndTime = current[0] + (item[1] - item[0]); // current room endTime + this meeting time
            roomCount[curRoom]++;

            if (roomCount[curRoom] > roomCount[result]) // update result
                result = curRoom;
            else if (roomCount[curRoom] == roomCount[result])
                result = Math.min(result, curRoom);

            queue.add(new long[] { meetingEndTime, curRoom });
        }

        return result;

//        int[] endTime = new int[n];
//        int[] rooms = new int[n];
//
//        Arrays.sort(meetings, (a, b) -> {
//            if (a[0] == b[0]) return a[1] - b[1];
//            return a[0] - b[0];
//        });
//
//        int index = 0;
//
//        while (index < meetings.length){
//            int minIndex = n;
//            int minEndTime = Integer.MAX_VALUE;
//            boolean flag = false;
//            int[] meeting = meetings[index++];
//            for (int i = 0; i < n; i++){
//                if (endTime[i] <= meeting[0]){
//                    endTime[i] = meeting[1];
//                    rooms[i] += 1;
//                    flag = true;
//                    break;
//                }
//                if (minEndTime > endTime[i]){
//                    minEndTime = endTime[i];
//                    minIndex = i;
//                }
//            }
//            if (!flag){
//                rooms[minIndex] += 1;
//                endTime[minIndex] += (meeting[1]-meeting[0]);
//            }
//        }
//
//        int maxMeetings = 0;
//
//        for (int i = 0; i < n; i++){
//            if (rooms[i] > maxMeetings){
//                index = i;
//                maxMeetings = rooms[i];
//            }
//        }
//
//        return index;

    }

    @Test
    public void test(){

        int[][] arar1 = new int[][]{
                {12,44},
                {27,37},
                {48,49},
                {46,49},
                {24,44},
                {32,38},
                {21,49},
                {13,30}

        };

        Assert.assertEquals(mostBooked(4, arar1), 1);

        int[][] arar = new int[][]{
                {19,20},
                {14,15},
                {13,14},
                {11,20}

        };

        Assert.assertEquals(mostBooked(4, arar), 1);

        int[][] arary = new int[][]{
                {1,20},
                {2,10},
                {3,5},
                {4,9},
                {6,8},

        };

        Assert.assertEquals(mostBooked(3, arary), 1);

        int[][] array = new int[][]{
                {18,19},
                {3,12},
                {17,19},
                {2,13},
                {7,10},

        };
        Assert.assertEquals(mostBooked(4, array), 0);
    }
}

class Node{

    int index;
    int finishTime;

    public Node(int index, int finishTime) {
        this.index = index;
        this.finishTime = finishTime;
    }
}
