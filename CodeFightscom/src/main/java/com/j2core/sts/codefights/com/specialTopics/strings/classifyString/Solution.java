package com.j2core.sts.codefights.com.specialTopics.strings.classifyString;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    String classifyStrings(String s) {

        if (s.length() < 3) return "good";

        if (s.indexOf('?') > -1){

            List<String> optionsStringCollection = createOptionsStringCollection(s);

            for (String optionString: optionsStringCollection){

                if (verifyString(s, optionString)){
                    return "mixed";
                }
            }
            return "bad";

        }else {

            return verifyString(s, null) ? "good" : "bad";
        }
    }

    private List<String> createOptionsStringCollection(String s){


        List<String> result = new LinkedList<String>();

        for (int i = 0; i < s.length(); i++){

            if (s.charAt(i) == '?'){

                if (result.isEmpty()){
                    result.add("a");
                    result.add("b");
                }else {
                    List<String> tmpResult = new LinkedList<String>();
                    for (String s1 : result){
                        tmpResult.add(s1 + "a");
                        tmpResult.add(s1 + "b");
                    }
                    result = tmpResult;
                }
            }
        }

        return result;
    }

    private boolean verifyString(String s, String tmpLetters){

        String vowelsLetters = "aeiou";
        int sLength = s.length();
        int amountVowelsLetters = 0;
        int amountConsonantsLetters = 0;
        int tmpIndex = -1;

        char tmp = s.charAt(0);
        for (int i = 0; i < sLength; ) {

            if (tmp == '?') {
                tmp = tmpLetters.charAt(++tmpIndex);
            } else if (vowelsLetters.indexOf(tmp) > -1) {
                amountVowelsLetters++;
                i++;
                if (i < sLength) {
                    tmp = s.charAt(i);
                    if (tmp == '?') tmp = tmpLetters.charAt(++tmpIndex);
                    while (vowelsLetters.indexOf(tmp) > -1) {
                        amountVowelsLetters++;
                        if (amountVowelsLetters > 2) return false;
                        i++;
                        if (i < sLength) {
                            tmp = s.charAt(i);
                            if (tmp == '?')tmp = tmpLetters.charAt(++tmpIndex);
                        } else break;
                    }
                    amountVowelsLetters = 0;
                }
            } else {
                amountConsonantsLetters++;
                i++;
                if (i < sLength) {
                    tmp = s.charAt(i);
                    if (tmp == '?') tmp = tmpLetters.charAt(++tmpIndex);
                    while (vowelsLetters.indexOf(tmp) < 0) {
                        amountConsonantsLetters++;
                        if (amountConsonantsLetters > 4) return false;
                        i++;
                        if (i < sLength) {
                            tmp = s.charAt(i);
                            if (tmp == '?')tmp = tmpLetters.charAt(++tmpIndex);
                        } else break;
                    }
                    amountConsonantsLetters = 0;
                }
            }
        }
        return true;
    }
}
