package faang.apple;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MergeStringAlternately {

    public String mergeAlternately(String word1, String word2) {

        StringBuilder builder = new StringBuilder();
        int i1 = 0;
        int i2 = 0;
        while (i1 <= word1.length() && i2 <= word2.length()){
            if (i1 == word1.length() && i2 == word2.length()) break;
            if (i1 < word1.length()){
                builder.append(word1.charAt(i1++));
            }
            if (i2 < word2.length()){
                builder.append(word2.charAt(i2++));
            }
        }

        return builder.toString();
    }

    @Test
    public void test(){

        Assert.assertEquals("apbqcr", mergeAlternately("abc", "pqr"));
        Assert.assertEquals("apbqrs", mergeAlternately("ab", "pqrs"));
        Assert.assertEquals("apbqcd", mergeAlternately("abcd", "pq"));
    }

}
