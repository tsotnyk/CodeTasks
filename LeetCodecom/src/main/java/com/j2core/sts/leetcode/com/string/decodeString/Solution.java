package com.j2core.sts.leetcode.com.string.decodeString;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
The class given an encoded string, return it's decoded string.
 */
public class Solution {

    /**
     * The method given an encoded string, return it's decoded string.
     *
     * @param s     string for decode
     * @return      decoded string
     */
    public String decodeStringOld(String s) {

        String result = s;
        char openBracket = '[';
        char closeBracket = ']';
        int openBracketIndex = result.lastIndexOf(openBracket);
        while (openBracketIndex > -1){
            String subString;
            String tmpString;
            int closeBracketIndex = result.indexOf(closeBracket, openBracketIndex);
            int startIndex = openBracketIndex-1;
            while (startIndex != 0 && Character.isDigit(result.charAt(startIndex-1))){
                startIndex--;
                if (startIndex == 0)break;
            }
            if (closeBracketIndex < result.length()-1) {
                tmpString = result.substring(startIndex, closeBracketIndex + 1);
            }else {
                tmpString = result.substring(startIndex);
            }
            subString = createSubString(tmpString);
            result = result.replace(tmpString, subString);
            openBracketIndex = result.lastIndexOf(openBracket);
        }

        return result;
    }

    /**
     * The method decode subString
     *
     * @param tmpString      subString
     * @return               decoded string
     */
    private String createSubString(String tmpString){

        int amount = 0;
        char openBracket = '[';
        int indexBracket = tmpString.indexOf(openBracket);
        try {
            amount = Integer.parseInt(tmpString.substring(0, indexBracket));
        }catch (Exception ex){
            ex.getStackTrace();
        }
        tmpString = tmpString.substring(indexBracket+1, tmpString.length()-1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < amount; i++){
            builder.append(tmpString);
        }
        return builder.toString();
    }

    public String decodeString(String s) {

        int indexOpen = s.lastIndexOf('[');
        String str = s;
        while (indexOpen != -1){

            str = openBracket(str, indexOpen);
            indexOpen = str.lastIndexOf('[');
        }

        return str;
    }

    private String openBracket(String string, int index) {

        int last = string.indexOf(']', index);
        StringBuilder builder = new StringBuilder();
        int first = index-1;
        while (first > 0 && Character.isDigit(string.charAt(first-1))){
            first--;
        }
        int counter = Integer.parseInt(string.substring(first, index));

        while (counter > 0){
            builder.append(string.substring(index+1, last));
            counter--;
        }

        return string.substring(0, first) + builder.toString() + string.substring(last+1);
    }

    @Test
    public void test(){

        Assert.assertEquals(decodeString("2[abc]"), "abcabc");
        Assert.assertEquals(decodeString("2[abc]3[d]"), "abcabcddd");
        Assert.assertEquals(decodeString("2[ab3[d]]"), "abdddabddd");

    }
}
