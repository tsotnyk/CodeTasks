package fastAndSlowPointers;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashSet;

public class HappyNumber {

    public static boolean isHappyNumber(int n) {

        HashSet<Integer> setResults = new HashSet<>();

        while (!setResults.contains(n)){

            int sum = 0;
            setResults.add(n);

            while (n > 0){
                int num = n%10;
                n = n/10;

                sum += num * num;
            }

            if (sum == 1) return true;
            n = sum;
        }

        return false;
    }

    @Test
    public void test(){

        Assert.assertTrue(isHappyNumber(23));
        Assert.assertFalse(isHappyNumber(2));
        Assert.assertTrue(isHappyNumber(28));
        Assert.assertFalse(isHappyNumber(4));
    }
}
