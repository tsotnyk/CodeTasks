package twoPoints;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseWordsInString {

    public static String reverseWords(String sentence) {

        StringBuilder builder = new StringBuilder();
        int right = sentence.length()-1;
        int left = right;
        while (right > -1 && left > -1){
            if (sentence.charAt(left) != ' '){
                left--;
                continue;
            }

            builder.append(sentence.substring(left+1, right+1));
            builder.append(' ');

            while (left > -1 && sentence.charAt(left) == ' '){
                left--;
            }
            right = left;
            left = right;
        }

        builder.append(sentence.substring(left+1, right+1));

        return builder.toString();
    }

    @Test
    public void test(){

        Assert.assertEquals(reverseWords("Hello  Friend"), "Friend Hello");
    }
}
