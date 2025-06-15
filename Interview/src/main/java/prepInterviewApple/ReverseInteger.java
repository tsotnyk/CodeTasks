package prepInterviewApple;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseInteger {

    public int reverse(int x) {

        long base = x;
        boolean negative = false;
        if (x < 0){
            negative = true;
            base *= -1;
        }
        long result = base%10;
        base = base/10;

        while (base > 0){
            result *= 10;
            result += base%10;
            base = base/10;
        }

        if (negative) result *= -1;

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;

        return (int)result;
    }

    @Test
    public void test(){

        Assert.assertEquals(reverse(-2147483648), 0);
    }
}
