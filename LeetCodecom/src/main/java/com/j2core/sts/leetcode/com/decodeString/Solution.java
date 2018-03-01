package com.j2core.sts.leetcode.com.decodeString;

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
    public String decodeString(String s) {

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
}
