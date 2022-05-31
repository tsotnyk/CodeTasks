package sts.hackerrank.com.warmUpChallenges;

import org.junit.Assert;
import org.junit.Test;

public class CountingValleys {

    public static int countingValleys(int steps, String path) {
        // Write your code here

        int counter = 0;

        int indexStart = 0;
        int index = 0;
        int pathSum = 0;
        while (index < steps){
            if (path.charAt(index) == 'D'){
                pathSum -= 1;
            }else {
                pathSum += 1;
            }
            if (pathSum == 0){
                if (path.charAt(indexStart) == 'D'){
                    counter++;
                }
                indexStart = index+1;
            }
            index++;
        }

        return counter;
    }

    @Test
    public void test(){

        Assert.assertEquals(1, countingValleys(8, "UDDDUDUU"));
    }
}
