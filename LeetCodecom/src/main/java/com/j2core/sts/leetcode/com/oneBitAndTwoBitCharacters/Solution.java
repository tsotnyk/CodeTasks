package com.j2core.sts.leetcode.com.oneBitAndTwoBitCharacters;

public class Solution {

    public boolean isOneBitCharacter(int[] bits) {

        int ctr = -1;
        for(int i = 0;i<bits.length;i++){
            int a = bits[i];
            if(ctr == 1){
                ctr = -1;
            }else{
                ctr = a;
            }
        }
        return ctr == 0;
    }
}
