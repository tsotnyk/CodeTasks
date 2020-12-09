package com.j2core.sts.leetcode.com.crackingCodingInterview.charter16;

import java.util.Random;

public class Solution16_23 {

    public int rand7(){

        int random = rand5()+(rand5()/2);
        return random%7;
    }

    private int rand5(){

        //todo
        return 0;
    }
}
