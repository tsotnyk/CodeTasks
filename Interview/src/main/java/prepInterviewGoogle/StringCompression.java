package prepInterviewGoogle;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class StringCompression {

    public int compress(char[] chars) {

        int indexFree = 1;
        int index = 1;
        int counter = 1;
        while (index < chars.length){

            if (chars[index] == chars[indexFree-1]){
                counter++;
            }else {
                if (counter > 1){
                    String num = String.valueOf(counter);
                    System.arraycopy( num.toCharArray(), 0, chars, indexFree, num.length());
                    indexFree += num.length();
                    chars[indexFree++] = chars[index];
                    counter = 1;
                }else {
                    chars[indexFree++] = chars[index];
                }

            }
            index++;
        }

        if (counter > 1){
            String num = String.valueOf(counter);
            System.arraycopy( num.toCharArray(), 0, chars, indexFree, num.length());
            indexFree += num.length();
        }

        return indexFree;
    }

    @Test
    public void test(){

        Assert.assertEquals(compress(new char[]{'a','a','a','b','b','a','a'}), 6);
        Assert.assertEquals(compress(new char[]{'a','a','b','b','c','c','c'}), 6);
        Assert.assertEquals(compress(new char[]{'a'}), 1);
        Assert.assertEquals(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}), 4);
    }

}
