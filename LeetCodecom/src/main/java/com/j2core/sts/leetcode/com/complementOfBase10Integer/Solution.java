package com.j2core.sts.leetcode.com.complementOfBase10Integer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int bitwiseComplementOLD(int N) {
        String array = Integer.toBinaryString(N);

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < array.length(); i++){

            char tmp = array.charAt(i);

            if (tmp == '0'){
                builder.append('1');
            }else {
                builder.append('0');
            }

        }

        return Integer.parseInt(builder.toString(), 2);
    }

    public int bitwiseComplement(int N) {

        String num = Integer.toBinaryString(N);

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < num.length(); i++){
            if (num.charAt(i) == '1'){
                if (builder.length() > 0){
                    builder.append('0');
                }
            }else {
                builder.append('1');
            }
        }

        if (builder.length() == 0) return 0;

        return Integer.parseInt(builder.toString(), 2);
    }

    @Test
    public void test(){

        Assert.assertEquals(bitwiseComplement(5),2);
        Assert.assertEquals(bitwiseComplement(7),0);
        Assert.assertEquals(bitwiseComplement(10),5);

    }
}
