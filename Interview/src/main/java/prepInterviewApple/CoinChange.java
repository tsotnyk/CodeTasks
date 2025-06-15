package prepInterviewApple;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        return coinChange(coins, amount, 0);
    }

    public int coinChange(int[] coin, int amount, int counter){

        if (amount < 0) return -1;
        if (amount == 0) return counter;
        for (int i = coin.length-1; i >= 0; i--){
            if (coin[i] > amount) continue;
            int candidate = coinChange(coin, amount-coin[i], counter+1);
            if (candidate > 0){
                return counter + candidate;
            }
        }

        return -1;
    }

    @Test
    public void test(){

        Assert.assertEquals(coinChange(new int[]{1,2,5}, 11), 3);
        Assert.assertEquals(coinChange(new int[]{2}, 3), -1);
        Assert.assertEquals(coinChange(new int[]{1}, 0), 0);
    }
}
