package com.j2core.sts.leetcode.com.string.fractionToResurringDecimal;

import org.testng.annotations.Test;

import java.util.HashMap;

public class Solution {

    public String fractionToDecimal(int numerator, int denominator) {

        long num = numerator;
        long denom = denominator;

        StringBuilder builder = new StringBuilder();

        if((num > 0 && denom < 0)||(denom > 0 && num < 0)){
            builder.append("-");
        }
        num = Math.abs(num);
        denom = Math.abs(denom);

        builder.append(num/denom);
        if(num%denom == 0) return builder.toString();
        builder.append(".");

        long divider = num%denom;
        HashMap<Long, Integer> map = new HashMap<>();
        int idx = 0;

        while(true){
            if(map.containsKey(divider)){
                builder.insert( builder.indexOf(".")+1+map.get(divider), "(" );
                builder.append(")");
                break;
            }

            map.put(divider, idx);
            divider *= 10;
            long res = divider/denom;
            builder.append(res);
            if(divider%denom == 0) break;
            if(res != 0) divider = divider%denom;

            idx++;
        }


        return builder.toString();
    }

    @Test
    public void test(){

        System.out.println("4 / 333 = 0.(012)");
        System.out.println(fractionToDecimal(4,333));
        System.out.println("1 / 2 = 0.5");
        System.out.println(fractionToDecimal(1,2));
        System.out.println("10 / 2 = 5");
        System.out.println(fractionToDecimal(10,2));
        System.out.println("2 / 3 = 0.(6)");
        System.out.println(fractionToDecimal(2,3));
        System.out.println("2 / 2 = 1");
        System.out.println(fractionToDecimal(2,2));
        System.out.println("5 / 1 = 5");
        System.out.println(fractionToDecimal(5,1));


    }
}
