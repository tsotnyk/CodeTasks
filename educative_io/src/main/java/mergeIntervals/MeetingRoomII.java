package mergeIntervals;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class MeetingRoomII {

    public static int findSets(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        rooms.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++){
            int[] meeting = intervals[i];
            if (rooms.peek() <= meeting[0]){
                rooms.poll();
                rooms.add(meeting[1]);
            }else {
                rooms.add(meeting[1]);
            }
        }

        return rooms.size();
    }

    @Test
    public void test(){

        Assert.assertEquals(findSets(new int[][]{{2,8},{3,4},{3,9},{5,11},{8,20},{11,15}}), 3);
    }
}
