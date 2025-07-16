package prepInterviewWithEducativeIo.fastAndSlowPointers;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

public class HappyNumber {

    public boolean isHappyNumber(int n) {

        HashSet<Integer> set = new HashSet<>();
        int sum = n;
        do {
            set.add(sum);
            int number = 0;

            while (sum > 0){
                number += (sum%10)*(sum%10);
                sum = sum/10;
            }
            sum = number;
        }while (sum != 1 && !set.contains(sum));

        return sum == 1 ? true : false;
    }

    @Test
    public void test(){

        Assert.assertTrue(isHappyNumber(7));
        Assert.assertFalse(isHappyNumber(4));
    }
}
