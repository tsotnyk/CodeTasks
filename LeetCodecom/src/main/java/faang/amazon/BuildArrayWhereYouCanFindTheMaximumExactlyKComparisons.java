package faang.amazon;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicLong;

// Time Limit Exceeded
public class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons {

    int modulo = 1000000007;
    public int numOfArrays(int n, int m, int k) {

        AtomicLong result = new AtomicLong(0);

        addNewValue(-1, 0, 0, n, m, k, result);

        return (int) (result.get()%modulo);
    }

    private void addNewValue(int maxValue, int curCost, int index, int n, int m, int k, AtomicLong result){

        if (index == n) {
            if (curCost == k) result.incrementAndGet();
            return;
        }
        if (curCost > k) return;
        int curValue = maxValue;


        for(int i = 1; i <= m; i++){
            int costDelta = 0;
            if (maxValue < i){
                costDelta = 1;
                curValue = i;
            }

            addNewValue(curValue, curCost+costDelta, index+1, n, m, k, result);
        }
    }

    @Test
    public void test_numOfArrays(){

        Assert.assertEquals(numOfArrays(2,3,1), 6);
        Assert.assertEquals(numOfArrays(5,2,3), 0);
        Assert.assertEquals(numOfArrays(9,1,1), 1);
    }
}
