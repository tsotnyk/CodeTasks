package com.j2core.sts.leetcode.com.ValidParentheses;

/*
    The class determine if the input string with brackets is valid
 */
public class Solution {

    /**
     * The method determine if the input string with brackets is valid
     *
     * @param s   string with brackets
     * @return    string valid or not
     */
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        char[] openBrackets = new char[]{'(', '[', '{' };
        char[] closeBrackets = new char[]{')', ']', '}'};
        String subString = s;
        char closeBracket;
        char openBracket;
        int openIndex;
        for (int k = 0; k < openBrackets.length; k++){
            openBracket = openBrackets[k];
            closeBracket = closeBrackets[k];
            openIndex = subString.indexOf(openBracket);
            while (openIndex > -1){
                for (int i = openIndex + 1; i < subString.length(); i++){
                    char tmp = subString.charAt(i);
                    if (tmp == openBracket){
                        openIndex = i;
                    }else if (tmp == closeBracket){
                        if ((i - openIndex + 1)%2 != 0) return false;
                        subString = createNewSubString(subString, openIndex, i);
                        openIndex = -1;
                        break;
                    }
                }
                if (openIndex != -1) return false;
                openIndex = subString.indexOf(openBracket);
            }
        }
        return subString.length() == 0;

    }

    /**
     * The method get subString from basic string without one pairs brackets
     *
     * @param string         basic string
     * @param openIndex      first index for subString
     * @param closeIndex     last index for subString
     * @return               new SubString
     */
    private String createNewSubString(String string, int openIndex, int closeIndex){

        StringBuilder result = new StringBuilder();
        if (openIndex > 0){
            result.append(string.substring(0, openIndex));
        }
        if (closeIndex - openIndex == 1 && closeIndex < string.length()-1){
            result.append(string.substring(closeIndex+1));
        }else {
            result.append(string.substring(openIndex + 1, closeIndex));
            if (closeIndex < string.length()-1){
                result.append(string.substring(closeIndex + 1));
            }
        }
        return result.toString();
    }
}
