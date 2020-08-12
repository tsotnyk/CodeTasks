package facebook.codingPractice.slowSums;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution {

    int getTotalTime(int[] arr) {
        // Write your code here

        if (arr.length == 1) return 0;

        int penalty = 0;
        Arrays.sort(arr);
        for (int i = arr.length-2; i > -1; i--){
            int sum = arr[i+1] + arr[i];
            penalty += sum;
            arr[i] = sum;
        }

        return penalty;
    }

    @Test
    public void test(){

        Assert.assertEquals(getTotalTime(new int[]{1}), 0);
        Assert.assertEquals(getTotalTime(new int[]{1, 22}), 23);
        Assert.assertEquals(getTotalTime(new int[]{1, 2,3}), 11);
        Assert.assertEquals(getTotalTime(new int[]{1,2,3,4}), 26);
        Assert.assertEquals(getTotalTime(new int[]{4, 2, 1, 3}), 26);
        Assert.assertEquals(getTotalTime(new int[]{2, 3, 9, 8, 4}), 88);

    }
}
