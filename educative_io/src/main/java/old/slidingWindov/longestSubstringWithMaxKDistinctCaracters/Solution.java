package old.slidingWindov.longestSubstringWithMaxKDistinctCaracters;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Solution {

    public static int findLength(String str, int k) {
        // TODO: Write your code here
        HashMap<Character, Integer> charMap = new HashMap<>();

        int maxLength = 0;
        int iS = 0;
        int iE = 0;

        while (iE < str.length()){
            char symbol = str.charAt(iE++);
            charMap.put(symbol, charMap.getOrDefault(symbol, 0)+1);
            if (charMap.size() > k){
                while (charMap.size() > k){
                    char removeChar = str.charAt(iS++);
                    int count = charMap.get(removeChar);
                    if (count == 1){
                        charMap.remove(removeChar);
                    }else {
                        charMap.put(removeChar, count-1);
                    }
                }
            }
            maxLength = Math.max(maxLength, iE-iS);
        }

        return maxLength;
    }

    @Test
    public void test(){

        Assert.assertEquals(4, findLength("araaci", 2));
        Assert.assertEquals(2, findLength("araaci", 1));
        Assert.assertEquals(5, findLength("cbbebi", 3));
        Assert.assertEquals(6, findLength("cbbebi", 10));

    }
}
