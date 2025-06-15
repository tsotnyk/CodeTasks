package prepInterviewMeta;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConsecutiveCharacters {

    public int maxPower(String s) {

        if (s.length() < 2) return 1;
        int maxLength = 1;
        int candidateLength = 1;
        int index = 1;

        while (index < s.length()){

            if (s.charAt(index) == s.charAt(index-1)){
                candidateLength++;
            }else {
                maxLength = Math.max(maxLength, candidateLength);
                candidateLength = 1;
            }
            index++;
        }

        return Math.max(candidateLength, maxLength);
    }

    @Test
    public void test(){

        Assert.assertEquals(maxPower("leetcode"), 2);
        Assert.assertEquals(maxPower("abbcccddddeeeeedcba"), 5);
    }
}
