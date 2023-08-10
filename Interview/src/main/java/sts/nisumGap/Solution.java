package sts.nisumGap;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.PriorityQueue;

public class Solution {

    public int findMaxOfTwo(int[] array){

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < 2; i++){

            queue.add(array[i]);
        }

        for (int j = 2; j < array.length; j++){

            if (array[j] > queue.peek()){
                queue.poll();
                queue.add(array[j]);
            }
        }

        int sum = 0;
        sum += queue.poll();
        sum += queue.poll();

        return sum;

    }

    @Test
    public void test(){

        Assert.assertEquals(findMaxOfTwo(new int[]{6,8,7,5,9,4,2,3}), 17);
    }

}
