package com.j2core.sts.leetcode.com.crawlerLogFolder;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int minOperations(String[] logs) {

        int counter = 0;
        for (String log : logs){
            switch (log){
                case "../":
                    counter = counter > 0 ? counter-1 : 0;
                    break;
                case "./":
                    break;
                default:
                    counter++;
            }
        }
        return counter;
    }

    @Test
    public void test(){

        Assert.assertEquals(minOperations(new String[]{"d1/","d2/","./","d3/","../","d31/"}), 3);
        Assert.assertEquals(minOperations(new String[]{"d1/","../","../","../"}), 0);
        Assert.assertEquals(minOperations(new String[]{"d1/","d2/","../","d21/","./"}), 2);
    }
}
