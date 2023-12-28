package faang.apple;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {

        int maxWealth = Integer.MIN_VALUE;

        for(int i = 0; i < accounts.length; i++){
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++){
                sum += accounts[i][j];
            }
            maxWealth = Math.max(maxWealth, sum);
        }

        return maxWealth;
    }

    @Test
    public void test_maximumWealth(){

        Assert.assertEquals(6, maximumWealth(new int[][]{{1,2,3},{3,2,1}}));
    }
}
