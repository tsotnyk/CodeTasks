package com.j2core.sts.leetcode.com.string.lengthOfLastWord;

import org.testng.annotations.Test;

public class Solution {


    public int lengthOfLastWordOld(String s) {
        int freeSpace = 0;
        int lastIndex = s.length()-1;

        for(int i = lastIndex; i > -1; i--){

            if(s.charAt(i) == ' '){
                if(i != lastIndex-freeSpace){
                    return lastIndex - i - freeSpace;
                }else{
                    freeSpace++;
                }
            }
        }

        return lastIndex+1 - freeSpace;

    }

    public int lengthOfLastWord(String s) {

        int countChar = 0;
        int index = s.length()-1;

        while (index > -1){
            if (Character.isLetter(s.charAt(index))){
                while (index > -1 && Character.isLetter(s.charAt(index--))){
                    countChar++;
                }
                break;
            }
            index--;
        }

        return countChar;
    }


    @Test
    public void test(){

        int result = lengthOfLastWord(" b a  ");

        System.out.print(result);
    }
}
