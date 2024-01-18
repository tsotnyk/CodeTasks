package faang.apple;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MaximumNumberOfEventsThatCanBeAttended {

    public int maxEvents(int[][] events) {

        Arrays.sort(events, (a,b) -> {

            if (a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[] event = events[0];
        int counter = 1;

        for (int i = 1; i < events.length; i++){
            if (events[i][0] >= event[1]){
                counter++;
                event = events[i];
            }
        }
        return counter;
    }

    @Test
    public void test(){

        Assert.assertEquals(3, maxEvents(new int[][]{{1,2},{2,3},{3,4}}));
    }
}
