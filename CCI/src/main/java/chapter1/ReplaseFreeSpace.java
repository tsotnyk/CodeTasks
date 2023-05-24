package chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReplaseFreeSpace {

    public void replaceFreeSpaces(char[] input){

        int indexReplace = input.length-1;
        int indexDest = indexReplace;
        while (input[indexReplace] == ' ') indexReplace--;

        while (indexReplace > 0){
            if (input[indexReplace] == ' '){
                input[indexDest--] = '0';
                input[indexDest--] = '2';
                input[indexDest--] = '%';
                indexReplace--;
            }else {
                input[indexDest--] = input[indexReplace--];
            }
        }
    }

    @Test
    public void test(){

        char[] testData1 = new char[]{'A', 's', ' ', 'n', 'e', 'w', ' ', ' '};
        replaceFreeSpaces(testData1);
        Assert.assertEquals(testData1, new char[]{'A', 's', '%', '2', '0', 'n', 'e', 'w'});
    }
}
