package faang.microsoft;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyTwoChocolates {

    public int buyChoco(int[] prices, int money) {

        int min1;
        int min2;

        if (prices[0] < prices[1]){
            min1 = prices[0];
            min2 = prices[1];
        }else {
            min1 = prices[1];
            min2 = prices[0];
        }

        for (int i = 2; i < prices.length; i++){

            if (min1 > prices[i]){
                min2 = min1;
                min1 = prices[i];
                continue;
            }

            if (min2 > prices[i]){
                min2 = prices[i];
            }
        }

        return money-min1-min2 >= 0 ? money-min1-min2 : money;
    }

    @Test
    public void test(){

        Assert.assertEquals(22, buyChoco(new int[]{98,54,6,34,66,63,52,39}, 62));
        Assert.assertEquals(0, buyChoco(new int[]{1,2,2}, 3));
        Assert.assertEquals(3, buyChoco(new int[]{3,2,3}, 3));
    }
}
