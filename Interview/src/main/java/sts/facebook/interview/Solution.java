package facebook.interview;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean isNumber(String string){

        if (string == null || string.length() < 1) return false;
        int digit = 0;
        boolean dots = false;
        boolean sign = false;

        for (char symbol : string.toCharArray()){

            switch (symbol){
                case ' ':
                    if (dots || sign || digit > 0) return false;
                    break;
                case '.':
                    if (dots) return false;
                    dots = true;
                    break;
                case '+':
                case '-':
                    if (sign || dots || digit > 0) return false;
                    sign = true;
                    break;
                default:
                    if (Character.isDigit(symbol)){
                        digit++;
                    }else return false;
                    break;
            }
        }

        return digit > 0;
    }

    @Test
    public void test(){

        Assert.assertTrue(isNumber(".34"));
        Assert.assertTrue(isNumber("345.34"));
        Assert.assertTrue(isNumber("  .34"));
        Assert.assertTrue(isNumber("-.34"));
        Assert.assertTrue(isNumber("+.34"));
        Assert.assertTrue(isNumber("-43.34"));
        Assert.assertTrue(isNumber("34"));
        Assert.assertTrue(isNumber("3.4"));
        Assert.assertFalse(isNumber("-hnh"));
        Assert.assertFalse(isNumber(".47fg"));
        Assert.assertFalse(isNumber("+"));
        Assert.assertFalse(isNumber("-"));
        Assert.assertFalse(isNumber("."));
        Assert.assertFalse(isNumber("-."));
        Assert.assertFalse(isNumber("345.364.34"));
        Assert.assertFalse(isNumber("234,34"));
        Assert.assertFalse(isNumber("+-6345"));
        Assert.assertFalse(isNumber(""));
        Assert.assertFalse(isNumber(null));
    }
}
