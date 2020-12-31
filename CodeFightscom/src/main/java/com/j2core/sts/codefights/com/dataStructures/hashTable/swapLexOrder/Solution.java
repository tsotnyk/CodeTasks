package com.j2core.sts.codefights.com.dataStructures.hashTable.swapLexOrder;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    String swapLexOrder(String str, int[][] pairs) {

        for(int[] pair : pairs){
            str = swapPair(str, pair);
        }

        return str;
    }

    private String swapPair(String str, int[] pair){

        if (str.charAt(pair[0]) == str.charAt(pair[1])) return str;
        char[] swapStr = str.toCharArray();
        swapStr[pair[0]] = swapStr[pair[1]];
        swapStr[pair[1]] = str.charAt(pair[0]);
        int index = 0;
        while (index < swapStr.length){
            if (swapStr[index] > str.charAt(index)){
                return new String(swapStr);
            }
            index++;
        }

        return str;
    }

    @Test
    public void test(){

        Assert.assertEquals(swapLexOrder("abcd", new int[][]{{1,4},{3,4}}), "dbca");
    }
}
