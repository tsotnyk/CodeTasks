package sts.facebook.codingPractice.heaps.magicalCandyBags;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

    int maxCandies(int[] arr, int k) {
        // Write your code here
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr){
            queue.add(num);
        }

        int sum = 0;
        while (k-- > 0){
            int maxValue = queue.poll();
            sum += maxValue;
            queue.add(maxValue/2);
        }
        return sum;
    }

    @Test
    public void test(){

        Assert.assertEquals(maxCandies(new int[]{2,1,7,4,2}, 3), 14);
        Assert.assertEquals(maxCandies(new int[]{19, 78, 76, 72, 48, 8, 24, 74, 29}, 3), 228);

    }

}
