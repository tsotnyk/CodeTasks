package old.slidingWindow;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMaximumInSlidingWindow {

    public static int[] findMaxSlidingWindow(int[] nums, int w) {
        // your code will replace the placeholder return statement below

        PriorityQueue<Integer> queue = new PriorityQueue<>(w, Collections.reverseOrder());

        int [] result = new int[nums.length+1-w];

        for (int i = 0; i < w; i++){
            queue.add(nums[i]);
        }

        int index = 0;

        while (index < nums.length-w){
            result[index] = queue.peek();
            queue.remove(nums[index]);
            queue.add(nums[index+w]);
            index++;
        }

        result[index] = queue.peek();

        return result;
    }

    @Test
    public void test(){

        Assert.assertEquals(findMaxSlidingWindow(new int[]{-4, 5, 4, -4, 4, 6, 7, 20}, 2), new int[]{5, 5, 4, 4, 6, 7, 20});

    }
}
