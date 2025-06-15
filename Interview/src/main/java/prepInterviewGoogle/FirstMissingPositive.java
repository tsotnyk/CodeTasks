package prepInterviewGoogle;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.PriorityQueue;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums){
            queue.add(num);
        }

        int num = 1;

        while (!queue.isEmpty() && queue.peek() <= num){

            if (queue.peek() == num){
                num++;
            }
            queue.poll();
        }

        return num;
    }

    @Test
    public void test(){

        Assert.assertEquals(firstMissingPositive(new int[]{0,1,2}), 3);
    }
}
