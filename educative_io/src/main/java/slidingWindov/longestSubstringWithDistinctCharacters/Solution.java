package slidingWindov.longestSubstringWithDistinctCharacters;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

public class Solution {

    public static int findLength(String str) {
        // TODO: Write your code here
        HashSet<Character> charSet = new HashSet<>();

        int iS = 0;
        int iE = 0;
        int maxLength = 1;

        while (iE < str.length()){
            char symbol = str.charAt(iE++);
            if (!charSet.add(symbol)){
                while (str.charAt(iS) != symbol){
                    iS++;
                }
                iS++;
            }
            maxLength = Math.max(maxLength, iE-iS);
        }
        return maxLength;
    }

    @Test
    public void test(){

        Assert.assertEquals(3, findLength("aabccbb"));
        Assert.assertEquals(2, findLength("abbbb"));
        Assert.assertEquals(3, findLength("abccde"));
    }
}
