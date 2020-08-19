package facebook.codingPractice.heaps.largestTripleProducts;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

    int[] findMaxProduct(int[] arr){

        if (arr == null) return null;
        if (arr.length < 1) return new int[]{};

        int[] result = new int[arr.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int maxSum = -1;

        for (int i = 0; i < arr.length; i++){
            queue.add(arr[i]);
            if (i >= 2){
                maxSum = 1;
                int counter = 0;
                PriorityQueue<Integer> tmpQueue = new PriorityQueue<>(Collections.reverseOrder());
                while (counter++ < 3){
                    int num = queue.poll();
                    maxSum *= num;
                    tmpQueue.add(num);
                }
                queue = tmpQueue;
            }
            result[i] = maxSum;
        }

        return result;
    }

    @Test
    public void test(){

        Assert.assertNull(findMaxProduct(null));
        Assert.assertEquals(findMaxProduct(new int[]{}), new int[]{});
        Assert.assertEquals(findMaxProduct(new int[]{4}), new int[]{-1});
        Assert.assertEquals(findMaxProduct(new int[]{4, 8}), new int[]{-1, -1});
        Assert.assertEquals(findMaxProduct(new int[]{1,2,3}), new int[]{-1, -1, 6});
        Assert.assertEquals(findMaxProduct(new int[]{1,2,3, 4,5}), new int[]{-1, -1, 6, 24,60});
        Assert.assertEquals(findMaxProduct(new int[]{2,4,7,1,5,3}), new int[]{-1, -1, 56,56,140,140});

    }
}
