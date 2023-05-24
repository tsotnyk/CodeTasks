package slidingWindov.longestSubstringWithSameLettersAfterReplacement;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Solution {

    public int findLength(String str, int k) {
        // TODO: Write your code here
        int maxLength = 1;
        int iS = 0;
        int iE = 0;

        HashMap<Character, Integer> charMap = new HashMap<>();

        while (iE < str.length()){
            char symbol = str.charAt(iE++);
            charMap.put(symbol, charMap.getOrDefault(symbol, 0)+1);
            if (!isOk(charMap, k)){
                int counter = charMap.get(str.charAt(iS));
                if (counter == 1) {
                    charMap.remove(str.charAt(iS));
                }else {
                    charMap.put(str.charAt(iS), counter-1);
                }
                iS++;
            }
            maxLength = Math.max(maxLength, iE-iS);
        }

        return maxLength;
    }

    private boolean isOk(HashMap<Character, Integer> map, int k){

        int maxValue = 0;
        int sum = 0;

        for (int value : map.values()){
            sum += value;
            maxValue = Math.max(maxValue, value);
        }

        return sum-maxValue <= k;
    }

    @Test
    public void test(){

        Assert.assertEquals(5, findLength("aabccbb", 2));
    }
}
