package com.j2core.sts.leetcode.com.thousandSeparator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public String thousandSeparator(int n) {

        if (n == 0) return "0";

        StringBuilder builder = new StringBuilder();
        int counter = 0;

        while (n > 0){
            if (counter == 3){
                builder.append('.');
                counter = 0;
            }
            builder.append(n%10);
            counter++;
            n = n/10;
        }

        return builder.reverse().toString();
    }

    public String thousandSeparatorOld(int n) {

        if (n == 0) return "0";

        String result = "";

        while (n > 0){

            if (result.length() < 1){
                result = String.valueOf(n%1000);
            }else {
                if (result.length() < 3) {
                    while (result.length() < 3){
                        result = "0" + result;
                    }
                }
                if (result.length() > 4){
                    int index = result.indexOf('.');
                    while (index++ < 3){
                        result = "0" + result;
                    }
                }
                result = n%1000 +"."+result;
            }

            n /= 1000;
        }

        return result;
    }

    @Test
    public void test(){

        Assert.assertEquals(thousandSeparator(987), "987");
        Assert.assertEquals(thousandSeparator(0), "0");
        Assert.assertEquals(thousandSeparator(1234), "1.234");
        Assert.assertEquals(thousandSeparator(123456789), "123.456.789");
        Assert.assertEquals(thousandSeparator(51040), "51.040");
        Assert.assertEquals(thousandSeparator(5004001), "5.004.001");

    }
}
