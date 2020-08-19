package sts.facebook.codingPractice.string.minimumLengthSubStrings;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Solution {

    int minLengthSubstring(String s, String t) {
        // Write your code here
        if (t.length() == 1) return s.indexOf(t.charAt(0)) == -1 ? -1 : 1;
        if (s.length() < t.length()) return -1;

        int minLengthSubString = -1;
        boolean[] findSymbol = new boolean[t.length()];
        int startIndex = 0;
        boolean first = true;
        for (int i = t.length()-1; i < s.length(); i++){
            int minLength = isSubArray(s,t,findSymbol,startIndex, i, first);
            first = false;
            if (minLength > -1){
                if (minLengthSubString > -1) {
                    minLengthSubString = Math.min(minLength, minLengthSubString);
                    startIndex++;
                }else {
                    minLengthSubString = minLength;
                }
            }
        }
        return minLengthSubString;
    }

    private int isSubArray(String s, String t, boolean[] findSymbol, int start, int end, boolean first){

        if (first){
            for (int i = start; i <= end; i++){
                char symbol = s.charAt(i);
                int index = t.indexOf(symbol);
                while (index > -1 && findSymbol[index]){
                    index = t.indexOf(symbol, index);
                }
                if (index > -1){
                    findSymbol[index] = true;
                }
            }
        }else {
            if (start > 0) {
                int indexRemove = t.indexOf(s.charAt(start - 1));
                if (indexRemove > -1) {
                    findSymbol[indexRemove] = false;
                }
            }
            int indexAdd = t.indexOf(s.charAt(end));
            while (indexAdd > -1 && findSymbol[indexAdd]){
                indexAdd = t.indexOf(s.charAt(end), indexAdd);
            }
            if (indexAdd > -1){
                findSymbol[indexAdd] = true;
            }
        }

        for (boolean flag : findSymbol){
            if (!flag) return -1;
        }
        return end-start+1;

    }

    @Test
    public void test(){

        Assert.assertEquals(minLengthSubstring("dcbefebce", "fd"), 5);
    }
}
