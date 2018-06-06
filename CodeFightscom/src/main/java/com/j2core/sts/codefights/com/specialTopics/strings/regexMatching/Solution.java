package com.j2core.sts.codefights.com.specialTopics.strings.regexMatching;

public class Solution {

    boolean regexMatching(String pattern, String test) {

        boolean prefFlag = false;
        boolean sufFlag = false;
        int patternLength = pattern.length();

        for (int i = 0; i < patternLength; i++){

            char tmp = pattern.charAt(i);
            if (tmp == '^'){
                prefFlag = true;
                break;
            }else if (tmp == '$'){
                sufFlag = true;
                break;
            }
        }

        if (prefFlag){

            return verifySubString(test, pattern, patternLength-1, patternLength-1, patternLength-2);

        }else if (sufFlag){

            return verifySubString(test, pattern, patternLength-2, patternLength-1, test.length()-1);

        }else {

            char firstSymbolPattern = pattern.charAt(0);
            for (int j = 0; j < test.length()-(patternLength-1); j++){

                if (test.charAt(j) == firstSymbolPattern){

                    if (verifySubString(test, pattern, patternLength-1, patternLength, j+patternLength-1)){
                        return true;
                    }
                }
            }
        }

        return false;

    }


    private boolean verifySubString(String test, String pattern, int lastIndexPattern, int amountSymbols, int lastIndexText){

        for (int i = 0; i < amountSymbols; i++){

            if (test.charAt(lastIndexText-i) != pattern.charAt(lastIndexPattern-i)){
                return false;
            }
        }

        return true;
    }
}
