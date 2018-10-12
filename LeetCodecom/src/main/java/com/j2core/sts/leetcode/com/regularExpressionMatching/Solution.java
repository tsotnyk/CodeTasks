package com.j2core.sts.leetcode.com.regularExpressionMatching;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean isMatch(String s, String p) {

        //TODO


        if(!findSymbols(p, p.length())){

            return s.equals(p);
        }else {

            int indexS = s.length()-1;
            int indexP = p.length()-1;

            while (indexS > -1 && indexP > -1){

                char tmp = p.charAt(indexP);

                if (tmp == '*'){

                    tmp = p.charAt(--indexP);
                    if (tmp == '.'){
                        indexS = 0;
                    }else {
                        int tmpIndex = indexS;
                        while (tmpIndex > -1 && s.charAt(tmpIndex) == tmp) {
                            tmpIndex--;
                        }
                        indexS = ++tmpIndex;

                    }
                }else if (tmp != '.'){
                    if (s.charAt(indexS) != p.charAt(indexP)){
                        return false;
                    }
                }

                indexP--;
                indexS--;
            }

            if (indexP == -1 && indexS == -1){
                return true;
            }else if (indexP == -1){
                return false;
            }else {

                String subStr = p.substring(0, indexP+1);
                if (subStr.indexOf('*') < 0){
                    return false;
                }else {
                    return zeroElements(subStr);
                }
            }
        }

    }

    private boolean zeroElements(String string){

        int index = string.length()-1;
        while (index > -1){

            if (string.charAt(index--) != '*' && (!Character.isLetter(string.charAt(index)) || string.charAt(index) != '.')){
                return false;
            }
            index--;
        }
        return true;
    }


    private boolean findSymbols(String string, int length){

        String str;

        if (string.length() == length){
            str = string;

        }else {

            str = string.substring(0, length);
        }

        return str.indexOf('*') >= 0 || str.indexOf('.') >= 0;

    }


    @Test
    public void test(){

        Assert.assertTrue(isMatch("aaa", "ab*ac*a"));

    }
}
