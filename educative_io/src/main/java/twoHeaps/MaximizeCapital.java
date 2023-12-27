package twoHeaps;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MaximizeCapital {

    class Pair{

        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public  int maximumCapital(int c, int k, int[] capitals,int[] profits) {

        int curCapital = c;

        PriorityQueue<Integer> profitQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<int[]> capitalQueue = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });

        for (int i = 0; i< capitals.length; i++){

            capitalQueue.offer(new int[]{capitals[i], i});
        }

        int[] tmp = capitalQueue.peek();

        while (k-- > 0){

            while (!capitalQueue.isEmpty() && capitalQueue.peek()[0] <= curCapital){
                int[] project = capitalQueue.poll();
                profitQueue.add(profits[project[1]]);
            }

            if (!profitQueue.isEmpty()){
                curCapital += profitQueue.poll();
            }
        }

        // Replace this placeholder return statement with your code

        return curCapital;
    }

    @Test
    public void test(){

        Assert.assertEquals(maximumCapital(1, 2, new int[]{1,2,2,3}, new int[]{2,4,6,8,}), 11);
    }
}
