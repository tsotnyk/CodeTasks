package faang.apple;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MaximumNumberOfWordsFoundInSentences {

    public int mostWordsFound1(String[] sentences) {

        int maxLength = 0;

        for (String sentence : sentences){

            int candidate = sentence.split(" ").length;
            maxLength = Math.max(maxLength, candidate);
        }

        return maxLength;
    }

    public int mostWordsFound(String[] sentences) {

        int maxLength = 0;

        for (String sentence : sentences){

            int candidate = 1;

            for (char sym : sentence.toCharArray()){
                if (sym == ' ') candidate++;
            }

            maxLength = Math.max(candidate, maxLength);
        }

        return maxLength;
    }

    @Test
    public void test_mostWordsFound(){

        Assert.assertEquals(6, mostWordsFound(new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"}));
    }
}
