package interview.practice;

import org.junit.Assert;
import org.junit.Test;

public class DecodeString {

    public String decodeString(String s) {

        int index = s.lastIndexOf('[');
        if (index < 0) return s;

        StringBuilder builder = new StringBuilder();
        int indexE = s.indexOf(']', index);
        int numIndex = index-1;

        while (numIndex > 0 && Character.isDigit(s.charAt(numIndex-1))){
            numIndex--;
        }

        String first = s.substring(0, numIndex);
        builder.append(first);
        int counter = Integer.parseInt(s.substring(numIndex, index));

        String duplication = s.substring(index+1, indexE);
        while (counter-- > 0){

            builder.append(duplication);
        }

        builder.append(s.substring(indexE+1));

        return decodeString(builder.toString());
    }

    @Test
    public void test(){

        Assert.assertEquals(decodeString("3[a]2[bc]"), "aaabcbc");
    }
}
