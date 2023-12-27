package faang.apple;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RotateString {

    public boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) return false;
        for (int i = 0; i < s.length(); i++){

            if (goal.charAt(i) == s.charAt(0)){
                int index = i+1;
                boolean sameString = true;
                for (int j = 1; j < s.length(); j++){
                    if (index == s.length()) index = 0;
                    if (goal.charAt(index++) != s.charAt(j)){
                        sameString = false;
                        break;
                    }
                }
                if (sameString) return true;
            }
        }

        return false;
    }

    @Test
    public void rotateString(){

        Assert.assertTrue(rotateString("abcde", "cdeab"));
        Assert.assertFalse(rotateString("abcde", "abced"));
    }
}
