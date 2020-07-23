package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1_3 {

    public char[] replaceSpaces(char[] text){

        int addIndex = text.length-1;
        int currentIndex = addIndex;

        while (currentIndex > -1){
            if (text[currentIndex] != ' '){
                text[addIndex--] = text[currentIndex--];
            }else {
                if (addIndex < text.length-1){
                    text[addIndex--] = '0';
                    text[addIndex--] = '2';
                    text[addIndex--] = '%';
                }
                currentIndex--;
            }
        }

        return text;
    }


    public String replaceSpaces(String text){

        if (text == null || text.length() < 1) return text;

        int firstIndex = 0;
        while (firstIndex < text.length() && text.charAt(firstIndex) == ' '){
            firstIndex++;
        }
        if (firstIndex == text.length()) return "";

        int lastIndex = text.length()-1;
        while (lastIndex > -1 && text.charAt(lastIndex) == ' '){
            lastIndex--;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = firstIndex; i <= lastIndex; i++){
            char symbol = text.charAt(i);
            if (symbol == ' '){
                builder.append("%20");
            }else {
                builder.append(symbol);
            }
        }

        return builder.toString();
    }

    @Test
    public void test(){

        Assert.assertEquals(replaceSpaces(new char[]{'c','c',' ', 'q',' ',' '}), new char[]{'c','c','%', '2','0','q'});
        Assert.assertEquals(replaceSpaces(new char[]{'c','c', 'q'}), new char[]{'c','c','q'});

        Assert.assertEquals(replaceSpaces(""), "");
        Assert.assertEquals(replaceSpaces("a"), "a");
        Assert.assertEquals(replaceSpaces("asddffghjkj"), "asddffghjkj");
        Assert.assertEquals(replaceSpaces("    rfgdfdfg"), "rfgdfdfg");
        Assert.assertEquals(replaceSpaces("rfgdfdfg    "), "rfgdfdfg");
        Assert.assertEquals(replaceSpaces("rfgd fdfg"), "rfgd%20fdfg");
        Assert.assertEquals(replaceSpaces("    rfgd fdfg"), "rfgd%20fdfg");
        Assert.assertEquals(replaceSpaces("rfgd fdfg    "), "rfgd%20fdfg");
        Assert.assertEquals(replaceSpaces("   rfgd fdfg    "), "rfgd%20fdfg");

    }
}
