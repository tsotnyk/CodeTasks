package sts.hackerrank.com.warmUpChallenges;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JumpingOnClouds {

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        ArrayList<Integer> arrayList = (ArrayList<Integer>) c;
        int counter = 0;
        int index = c.size()-1;

        while (index > 0){
            if (index-2 > -1 && arrayList.get(index-2) == 0){
                index -= 2;
            }else {
                index -= 1;
            }
            counter++;
        }

        return counter;
    }

    @Test
    public void test(){

        Assert.assertEquals(4, jumpingOnClouds(new ArrayList<>(Arrays.asList(0,0,1,0,0,1,0))));
    }
}
