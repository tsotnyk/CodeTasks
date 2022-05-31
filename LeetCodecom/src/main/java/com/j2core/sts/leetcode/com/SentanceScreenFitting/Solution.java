package com.j2core.sts.leetcode.com.SentanceScreenFitting;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int wordsTyping(String[] sentence, int rows, int cols) {

        int counter = 0;
        int index = 0;
        while (rows-- > 0){
            int length = cols;
            while (length > 0){
                if (length < cols) length--;
                int nextLength = sentence[index].length();
                if (length-nextLength >= 0){
                    length -= nextLength;
                    index++;
                }else {
                    break;
                }
                if (index == sentence.length){
                    index = 0;
                    counter++;
                }
            }
        }

        return counter;
    }

    public int wordsTyping2(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int l = s.length();
        int pos =0;
        for(int i =0; i < rows ; i ++){
            pos +=cols;
            if(s.charAt(pos% l) == ' ') pos++; // check if sentence perfectly breaks at space
            else while(pos > 0 && s.charAt((pos-1)%l)!= ' ') pos--; // if sentence does not break in this column , track back and see where to break for this row.
        }
        return pos /l;
    }

    @Test
    public void test(){

        Assert.assertEquals(2, wordsTyping(new String[]{"a", "bcd", "e"}, 3,6));
    }
}
