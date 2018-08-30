package com.j2core.sts.leetcode.com.stringCompression;

public class Solution {

    public int compress(char[] chars) {

        int resultIndex = 0;
        int counter;
        char tmpChar;
        int index = 0;

        while (index < chars.length){

            counter = 0;
            tmpChar = chars[index];
            counter++;
            index++;

            while (index < chars.length && tmpChar == chars[index]){
                counter++;
                index++;
            }
            chars[resultIndex++] = tmpChar;

            if(counter != 1)
                for(char c : Integer.toString(counter).toCharArray())
                    chars[resultIndex++] = c;
        }

        return resultIndex;
    }
}
