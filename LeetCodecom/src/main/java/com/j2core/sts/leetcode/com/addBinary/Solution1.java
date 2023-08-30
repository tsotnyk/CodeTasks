package com.j2core.sts.leetcode.com.addBinary;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {

    public String addBinary(String a, String b) {

        int maxIn = Math.max(a.length(), b.length());
        int index = 0;

        StringBuilder sb = new StringBuilder();

        int curr = 0;

        while (index < maxIn){
            int v1 = getValue(a, index);
            int v2 = getValue(b, index++);
            switch (v1+v2+curr){
                case 3:
                    sb.insert(0, 1);
                    curr = 1;
                    break;
                case 2 :
                    sb.insert(0, 0);
                    curr = 1;
                    break;
                case 1:
                    sb.insert(0, 1);
                    curr = 0;
                    break;
                case 0:
                    sb.insert(0, 0);
                    curr = 0;
            }
        }

        if (curr > 0) sb.insert(0, curr);

        return sb.toString();
    }

    private int getValue(String num, int index){

        if (index >= num.length()) return 0;

        return num.charAt(num.length()-1-index) == '0' ? 0 : 1;
    }

    @Test
    public void test(){
        Assert.assertEquals(addBinary("1", "11"), "100");

        Assert.assertEquals(addBinary("1010", "1011"), "10101");
    }
}
