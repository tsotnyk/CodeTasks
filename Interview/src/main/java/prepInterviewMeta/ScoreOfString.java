package prepInterviewMeta;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ScoreOfString {

    public int scoreOfString(String s) {

        char[] arr = s.toCharArray();
        int score = 0;

        for (int i = 1; i < arr.length; i++){
            score += Math.abs(arr[i] - arr[i-1]);
        }

        return score;
    }

    @Test
    public void test(){

        Assert.assertEquals(scoreOfString("hello"), 13);
        Assert.assertEquals(scoreOfString("zaz"), 50);
    }
}
