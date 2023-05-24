package chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringCompression {

    public String stringCompression(String input){

        char[] inputArray = input.toCharArray();
        StringBuilder builder = new StringBuilder();
        char symbol = inputArray[0];
        int counter = 1;

        for (int i = 1; i < input.length(); i++){
            if (inputArray[i] != symbol){
                builder.append(symbol).append(counter);
                symbol = inputArray[i];
                counter = 1;
            }else {
                counter++;
            }
        }

        builder.append(symbol).append(counter);

        return builder.length() < input.length() ? builder.toString() : input;
    }

    @Test
    public void test(){

        Assert.assertEquals(stringCompression("abc"), "abc");
        Assert.assertEquals(stringCompression("aabcccccaaa"), "a2b1c5a3");
    }
}
