package prepInterviewMeta;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckIfParenthesesStringCanBeValid {

    public boolean canBeValid1(String s, String locked) {

        if (s.length()%2 != 0) return false;
        int counter = 0;
        for (int i = 0; i < s.length(); i++){

            if (s.charAt(i) == '('){
                counter++;
                continue;
            }

            counter--;
            if (counter < 0){
                if (locked.charAt(i) == '0'){
                    counter = 1;
                }else {
                    return false;
                }
            }
        }

        if (counter%2 != 0) return false;

        return true;
    }

    public boolean canBeValid(String s, String locked) {

        if (s.length()%2 != 0) return false;
        int counter = 0;

        int emptySpace = 0;

        char[] array = s.toCharArray();

        for (int i = 0; i < s.length(); i++){
            if (locked.charAt(i) == '0'){
                array[i] = '!';
            }
        }

        for (char symbol : array){
            if (symbol == '!'){
                if (counter > 0) {
                    counter--;
                    continue;
                }
                emptySpace++;
                continue;
            }

            if (symbol == ')'){
                counter -= 1;
                if (counter < 0){
                    if (emptySpace == 0) return false;
                    emptySpace -= 1;
                    counter = 0;
                }
                continue;
            }

            counter++;
        }

        return counter == 0;
    }

    @Test
    public void test(){

        Assert.assertTrue(canBeValid("((()(()()))()((()()))))()((()(()", "10111100100101001110100010001001"));

        Assert.assertFalse(canBeValid("()((((", "111111"));
        Assert.assertFalse(canBeValid("()(", "111"));
        Assert.assertFalse(canBeValid("(", "0"));
        Assert.assertTrue(canBeValid("()()", "0000"));
        Assert.assertTrue(canBeValid("))()))", "010100"));
        Assert.assertTrue(canBeValid("(((())(((())", "111111010111"));
    }
}
