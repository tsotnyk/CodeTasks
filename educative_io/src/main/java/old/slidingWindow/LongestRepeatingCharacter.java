package old.slidingWindow;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LongestRepeatingCharacter {

    public static int longestRepeatingCharacterReplacement1(String s, int k) {

        if(s.length() <= k+1) return s.length();

        int maxLength = k+1;

        for (int i = 0; i < s.length()-k; i++){
            int counter = 0;
            char sym = s.charAt(i);
            for (int j = i+1; j <= s.length(); j++){

                if (j == s.length() || s.charAt(j) != sym){
                    if (counter == k || j == s.length()){
                        maxLength = Math.max(maxLength, j-i);
                        break;
                    }
                    counter++;
                }
            }

        }

        return maxLength;
    }

    @Test
    public void test(){

//        Assert.assertEquals(longestRepeatingCharacterReplacement1("aaacbbbaabab", 2), 6);
        Assert.assertEquals(longestRepeatingCharacterReplacement1("aabccbb", 2), 5);
    }
}
